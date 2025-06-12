package com.example.inventario.model;

import jakarta.validation.constraints.NotBlank;

public record LocalizacaoRequest (
        Long id,

        @NotBlank
        String logradouro,

        @NotBlank
        int numero,

        @NotBlank
        String uf,

        @NotBlank
        String cidade,

        @NotBlank
        String setor,

        @NotBlank
        String cep,
        String complemento){
}
