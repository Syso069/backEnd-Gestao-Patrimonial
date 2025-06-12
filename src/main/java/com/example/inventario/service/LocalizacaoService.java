package com.example.inventario.service;

import com.example.inventario.model.Localizacao;
import com.example.inventario.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public Localizacao buscarPorId(Long id){
        return localizacaoRepository.findById(id).orElse(null);
    }
}