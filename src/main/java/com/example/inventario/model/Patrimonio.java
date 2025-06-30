package com.example.inventario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "patrimonio")
@Entity()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patrimonio {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patrimonio_id_seq")
    @SequenceGenerator(name = "patrimonio_id_seq", sequenceName = "patrimonio_id_seq", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "FK_LOCALIZACAO")
    private Localizacao localizacao;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "RESPOSAVEL_ATUAL")
    private String responsavelAtual;

    @Column(name = "VALOR")
    private float valor;

    @Column(name = "NUMERO_SERIE")
    private String numeroSerie;

    @Column(name = "FABRICANTE")
    private String fabricante;

    @Column(name = "DATA_AQUISICAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    public Patrimonio(PatrimonioRequest patrimonioRequest){
        this.codigo = patrimonioRequest.codigoPatrimonio();
        this.tipo = patrimonioRequest.tipo();
        this.estado = patrimonioRequest.estado();
        this.responsavelAtual = patrimonioRequest.responsavelAtual();
        this.valor = patrimonioRequest.valor();
        this.numeroSerie = patrimonioRequest.numeroSerie();
        this.fabricante = patrimonioRequest.fabricante();
        this.dataAquisicao = patrimonioRequest.dataAquisicao();
    }
}