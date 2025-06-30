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
    @Column(name = "id")
    private Long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private int numero;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "setor")
    private String setor;

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
