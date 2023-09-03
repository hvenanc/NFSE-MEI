package com.henrique.gerenciadornfsemei.entities.dto;

public record AtualizarNFSE(

        String CNPJTomador,
        String nomeTomador,
        String chave,
        int numeroNFSE,
        String dataEmissao,
        double valorNFSE
) {
}
