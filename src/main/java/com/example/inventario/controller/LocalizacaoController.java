package com.example.inventario.controller;

import com.example.inventario.model.Localizacao;
import com.example.inventario.model.LocalizacaoRequest;
import com.example.inventario.service.LocalizacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity<List<Localizacao>> listarLocalizacoes(){
        return ResponseEntity.ok(localizacaoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Localizacao> criarLocalizacao(@RequestBody @Valid LocalizacaoRequest data){
        var localizacao = localizacaoService.criar(data);
        return ResponseEntity.ok(localizacao);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Localizacao> atualizaLocalizacao(@PathVariable Long id, @RequestBody @Valid LocalizacaoRequest data){
        var atualiza = localizacaoService.atualizar(id, data);
        return ResponseEntity.ok(atualiza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Localizacao> deletaLocalizacao(@PathVariable Long id){
        localizacaoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
