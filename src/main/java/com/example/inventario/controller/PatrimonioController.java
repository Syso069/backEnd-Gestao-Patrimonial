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
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @Autowired
    private PatrimonioService patrimonioService;

    @GetMapping
    public ResponseEntity<List<Patrimonio>> pegaTodosPatrimonios(){
        return ResponseEntity.ok(patrimonioService.pegaPatrimonio());
    }

    @PostMapping
    public ResponseEntity<Patrimonio> registraPatrimonio(@RequestBody @Valid PatrimonioRequest data){
        Patrimonio patrimonio = new Patrimonio(data);
        patrimonioService.salvaNovoPatrimonio(patrimonio, data.idLocalizacao());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Patrimonio> editaPatrimonio(@PathVariable Long id, @RequestBody @Valid PatrimonioRequest data){
        var atualizaPatrimonio = patrimonioService.editaPatrimonio(id, data);
        return ResponseEntity.ok(atualizaPatrimonio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patrimonio> excluiPatrimonio(@PathVariable Long id){
        var deletaPatrimonio = patrimonioService.deletaPatrimonio(id);
        return ResponseEntity.ok(deletaPatrimonio);
    }
}