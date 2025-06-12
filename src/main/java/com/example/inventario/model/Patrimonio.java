package com.example.inventario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "patrimonio")
@Entity(name = "patrimonio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patrimonio {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patrimonio_id_seq")
    @SequenceGenerator(name = "patrimonio_id_seq", sequenceName = "patrimonio_id_seq", allocationSize = 1)
    private Long id;

    private String codigoPatrimonio;

    private String tipo;

    private Long idLocalizacao;

    private String estado;

    private String responsavelAtual;

    private float valor;

    private String numeroSerie;

    private String fabricante;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    public Patrimonio(PatrimonioRequest patrimonioRequest){
        this.codigoPatrimonio = patrimonioRequest.codigoPatrimonio();
        this.tipo = patrimonioRequest.tipo();
        this.idLocalizacao = patrimonioRequest.idLocalizacao();
        this.estado = patrimonioRequest.estado();
        this.responsavelAtual = patrimonioRequest.responsavelAtual();
        this.valor = patrimonioRequest.valor();
        this.numeroSerie = patrimonioRequest.numeroSerie();
        this.fabricante = patrimonioRequest.fabricante();
        this.dataAquisicao = patrimonioRequest.dataAquisicao();
    }
}
