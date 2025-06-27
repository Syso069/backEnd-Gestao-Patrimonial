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
        var patrimonioCriado  = patrimonioService.criar(data);
        return ResponseEntity.ok(patrimonioCriado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Patrimonio> atualizarPatrimonio(@PathVariable Long id, @RequestBody @Valid PatrimonioRequest data){
        var patrimonio = patrimonioService.atualizar(id, data);
        return ResponseEntity.ok(patrimonio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patrimonio> deletarUsuario(@PathVariable Long id){
        patrimonioService.deletar(id);
        return ResponseEntity.ok().build();
    }
}