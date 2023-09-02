package com.henrique.gerenciadornfsemei.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroNFSE(

        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String CNPJTomador,

        @NotBlank
        String nomeTomador,

        @NotBlank
        @Pattern(regexp = "\\d{44}")
        String chave,

        int numeroNFSE,

        @NotBlank
        String dataEmissao,
        double valorNFSE
) {
}