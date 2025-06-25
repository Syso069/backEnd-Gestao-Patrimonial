package com.example.inventario.service;

import com.example.inventario.model.Inventario;
import com.example.inventario.model.Localizacao;
import com.example.inventario.model.Patrimonio;
import com.example.inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    @Autowired
    LocalizacaoService localizacaoService;

    public void salvar(Patrimonio patrimonio, Long idLocalizacao){
        Inventario inventario = new Inventario();
        Localizacao localizacaoPersist = localizacaoService.listarPorId(idLocalizacao);
        inventario.setPatrimonio(patrimonio);
        inventario.setLocalizacao(localizacaoPersist);
        inventarioRepository.save(inventario);
    }
}