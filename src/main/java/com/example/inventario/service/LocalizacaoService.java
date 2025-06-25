package com.example.inventario.service;


import com.example.inventario.model.Localizacao;
import com.example.inventario.model.LocalizacaoRequest;
import com.example.inventario.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> listarTodos(){
        List<Localizacao> localizacoes = localizacaoRepository.findAll(Sort.by("cidade").ascending());
        if (localizacoes.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado");
        }else {
            return localizacoes;
        }
    }

    public Localizacao listarPorId(Long id){
        return localizacaoRepository.findById(id).orElse(null);
    }

    public Localizacao criar(Localizacao novaLocalizacao){
        Localizacao localizacao = localizacaoRepository.save(novaLocalizacao);
        if (localizacao == null){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar produto.");
        }else {
            return localizacao;
        }
    }

    public Localizacao atualizar(Long id, LocalizacaoRequest data){
        Optional<Localizacao> localizacoes = localizacaoRepository.findById(id);
        Localizacao localizacao = localizacoes.get();
        localizacao.setLogradouro(data.logradouro());
        localizacao.setNumero(data.numero());
        localizacao.setUf(data.uf());
        localizacao.setCidade(data.cidade());
        localizacao.setCep(data.cep());
        localizacao.setComplemento(data.complemento());
        localizacao.setSetor(data.setor());
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao deletar(Long id){
        Optional<Localizacao> localizacoes = localizacaoRepository.findById(id);
        Localizacao localizacao = localizacoes.get();
        localizacaoRepository.deleteById(id);
        return localizacao;
    }
}