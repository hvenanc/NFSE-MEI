package com.henrique.gerenciadornfsemei.entities;

import com.henrique.gerenciadornfsemei.entities.dto.CadastroNFSE;
import com.henrique.gerenciadornfsemei.entities.dto.DetalharNFSE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "notas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "NotaServico")
public class NotaServico {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "cnpj")
    private String CNPJTomador;
    @Column(name = "tomador")
    private String nomeTomador;
    @Column(name = "numero")
    private int numeroNFSE;
    private String chave;
    @Column(name = "emissao")
    private String dataEmissao;
    @Column(name = "valor")
    private double valorNFSE;

    public NotaServico(CadastroNFSE dados) {
        this.CNPJTomador = dados.CNPJTomador();
        this.nomeTomador = dados.nomeTomador();
        this.numeroNFSE = dados.numeroNFSE();
        this.dataEmissao = dados.dataEmissao();
        this.valorNFSE = dados.valorNFSE();
        this.chave = dados.chave();
    }
}
