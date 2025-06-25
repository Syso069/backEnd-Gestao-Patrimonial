package com.example.inventario.controller;

import com.example.inventario.model.Patrimonio;
import com.example.inventario.model.PatrimonioRequest;
import com.example.inventario.service.PatrimonioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrimonios")
public class PatrimonioController {

    @Autowired
    private PatrimonioService patrimonioService;

    @GetMapping
    public ResponseEntity<List<Patrimonio>> listarPartimonios(){
        return ResponseEntity.ok(patrimonioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Patrimonio> criarPatrimonio(@RequestBody @Valid PatrimonioRequest data){
        Patrimonio patrimonio = new Patrimonio(data);
        patrimonioService.criar(patrimonio, data.idLocalizacao());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Patrimonio> atualizarPatrimonio(@PathVariable Long id, @RequestBody @Valid PatrimonioRequest data){
        var atualizaPatrimonio = patrimonioService.atualizar(id, data);
        return ResponseEntity.ok(atualizaPatrimonio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patrimonio> deletarUsuario(@PathVariable Long id){
        var deletaPatrimonio = patrimonioService.deletar(id);
        return ResponseEntity.ok(deletaPatrimonio);
    }
}