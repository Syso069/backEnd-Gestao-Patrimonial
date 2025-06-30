package com.example.inventario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatrimonioRequest(
    Long id,

    @NotBlank
    String codigoPatrimonio,

    @NotBlank
    String nome,

    @NotBlank
    String tipo,

    @NotBlank
    Long  idLocalizacao,

    @NotBlank
    String estado,

    @NotBlank
    String responsavelAtual,

    @NotBlank
    float valor,

    @NotBlank
    String numeroSerie,

    @NotBlank
    String fabricante,

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate dataAquisicao

){}
