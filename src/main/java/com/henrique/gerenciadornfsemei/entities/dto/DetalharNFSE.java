package com.henrique.gerenciadornfsemei.entities.dto;

import com.henrique.gerenciadornfsemei.entities.NotaServico;

public record DetalharNFSE(String CNPJTomador, String nomeTomador, int numeroNFSE, String dataEmissao, String chave, double valorNFSE) {

    public DetalharNFSE(NotaServico nota) {
        this(nota.getCNPJTomador(), nota.getNomeTomador(), nota.getNumeroNFSE(),
                nota.getDataEmissao(), nota.getChave(), nota.getValorNFSE());
    }
}
