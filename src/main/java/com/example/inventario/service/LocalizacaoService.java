package com.example.inventario.service;


import com.example.inventario.model.Localizacao;
import com.example.inventario.model.LocalizacaoRequest;
import com.example.inventario.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> listarTodos(){
        return localizacaoRepository.findAll(Sort.by("cidade").ascending());
    }

    public Localizacao buscarPorId(Long id){
        return localizacaoRepository.findById(id).orElse(null);
    }

    public Localizacao criar(LocalizacaoRequest data){
        Localizacao localizacao = new Localizacao(data);
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao atualizar(Long id, LocalizacaoRequest data){
        var localizacao = localizacaoRepository.findById(id).orElse(null);

        if (Objects.nonNull(localizacao)){
            localizacao.setLogradouro(data.logradouro());
            localizacao.setNumero(data.numero());
            localizacao.setUf(data.uf());
            localizacao.setCidade(data.cidade());
            localizacao.setCep(data.cep());
            localizacao.setComplemento(data.complemento());
            localizacao.setSetor(data.setor());
            return localizacaoRepository.save(localizacao);
        }
        return null;
    }

    public void deletar(Long id){
        localizacaoRepository.deleteById(id);
    }
}