package com.example.inventario.controller;

import com.example.inventario.model.Localizacao;
import com.example.inventario.model.LocalizacaoRequest;
import com.example.inventario.service.LocalizacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity listarLocalizacoes(){
        return ResponseEntity.ok(localizacaoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity criarLocalizacao(@RequestBody @Valid LocalizacaoRequest data){
        Localizacao localizacao = new Localizacao(data);
        localizacaoService.criar(localizacao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizaLocalizacao(@PathVariable Long id, @RequestBody @Valid LocalizacaoRequest data){
        var atualiza = localizacaoService.atualizar(id, data);
        return ResponseEntity.ok(atualiza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaLocalizacao(@PathVariable Long id){
        var deletar = localizacaoService.deletar(id);
        return ResponseEntity.ok(deletar);
    }
}
