package com.henrique.gerenciadornfsemei.repository;

import com.henrique.gerenciadornfsemei.entities.NotaServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NFSERepository extends JpaRepository<NotaServico, Long> {
    NotaServico getReferenceByNumeroNFSE(int numero);
}
