package com.example.inventario.service;

import com.example.inventario.model.Inventario;
import com.example.inventario.model.Localizacao;
import com.example.inventario.model.Patrimonio;
import com.example.inventario.model.PatrimonioRequest;
import com.example.inventario.repository.InventarioRepository;
import com.example.inventario.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository repository;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    LocalizacaoService localizacaoService;

    public List<Patrimonio> pegaPatrimonio(){
        List<Patrimonio> inventarios = repository.findAll(Sort.by("codigoPatrimonio").ascending());
        if (inventarios.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum patrimônio encontrado");
        }else {
            return inventarios;
        }
    }

    public Patrimonio salvaNovoPatrimonio(Patrimonio novoPatrimonio, Long idLocalizacao){
        Patrimonio patrimonio = repository.save(novoPatrimonio);
        inventarioService.salvar(patrimonio, idLocalizacao);
        return patrimonio;
    }

    public Patrimonio editaPatrimonio(Long id, PatrimonioRequest data){
        Patrimonio inventarios = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patrimônio não encontrado"));

        inventarios.setCodigoPatrimonio(data.codigoPatrimonio());
        inventarios.setTipo(data.tipo());
        inventarios.setResponsavelAtual(data.responsavelAtual());
        inventarios.setDataAquisicao(data.dataAquisicao());
        return repository.save(inventarios);
    }

    public Patrimonio deletaPatrimonio(Long id){
        Patrimonio inventario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patrimônio não encontrado"));;

        repository.deleteById(inventario.getId());
        return inventario;
    }
}
