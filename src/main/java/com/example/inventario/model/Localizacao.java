package com.example.inventario.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "localizacao")
@Entity(name = "localizacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private int numero;

    private String uf;

    private String cidade;

    private String setor;

    private String cep;

    private String complemento;

    public Localizacao(LocalizacaoRequest localizacaoRequest){
        this.logradouro = localizacaoRequest.logradouro();
        this.numero = localizacaoRequest.numero();
        this.uf = localizacaoRequest.uf();
        this.cidade = localizacaoRequest.cidade();
        this.setor = localizacaoRequest.setor();
        this.cep = localizacaoRequest.cep();
        this.complemento = localizacaoRequest.complemento();
    }
}
