package com.example.inventario.service;

import com.example.inventario.model.Patrimonio;
import com.example.inventario.model.PatrimonioRequest;
import com.example.inventario.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository repository;

    @Autowired
    LocalizacaoService localizacaoService;

    public List<Patrimonio> listarTodos(){
        return repository.findAll(Sort.by("codigoPatrimonio").ascending());
    }

    public Patrimonio criar(PatrimonioRequest data){
        Patrimonio patrimonio = new Patrimonio(data);
        var localizacao = localizacaoService.buscarPorId(data.idLocalizacao());
        patrimonio.setLocalizacao(localizacao);
        return repository.save(patrimonio);
    }

    public Patrimonio atualizar(Long id, PatrimonioRequest data){
        Patrimonio patrimonio = repository.findById(id).orElse(null);

        if (Objects.nonNull(patrimonio)){
            patrimonio.setCodigo(data.codigoPatrimonio());
            patrimonio.setNome(data.nome());
            patrimonio.setTipo(data.tipo());
            patrimonio.setResponsavelAtual(data.responsavelAtual());
            patrimonio.setDataAquisicao(data.dataAquisicao());
            return repository.save(patrimonio);
        }
        return null;
    }

    public void deletar(Long id){
       repository.deleteById(id);
    }
}
