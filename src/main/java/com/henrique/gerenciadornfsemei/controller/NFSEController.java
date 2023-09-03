package com.henrique.gerenciadornfsemei.controller;


import com.henrique.gerenciadornfsemei.entities.NotaServico;
import com.henrique.gerenciadornfsemei.entities.dto.AtualizarNFSE;
import com.henrique.gerenciadornfsemei.entities.dto.CadastroNFSE;
import com.henrique.gerenciadornfsemei.entities.dto.DetalharNFSE;
import com.henrique.gerenciadornfsemei.repository.NFSERepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/nfse")
public class NFSEController {
    private final NFSERepository repository;

    public NFSEController(NFSERepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<NotaServico> cadastrarNFSE(@RequestBody @Valid CadastroNFSE dados, UriComponentsBuilder uriBuilder) {
        var nota = new NotaServico(dados);
        repository.save(nota);
        var uri = uriBuilder.path("/cadastroNfse/{id}").buildAndExpand(nota.getId()).toUri();
        return ResponseEntity.created(uri).body(nota);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<DetalharNFSE> buscarNFSE(@PathVariable int numero) {
        var nota = repository.getReferenceByNumeroNFSE(numero);
        return ResponseEntity.ok(new DetalharNFSE(nota));
    }

    @GetMapping
    public ResponseEntity<Page<DetalharNFSE>> buscarTodasNfse(@PageableDefault(sort = "numeroNFSE") Pageable paginas) {
        var notas = repository.findAll(paginas).map(DetalharNFSE::new);
        return ResponseEntity.ok(notas);
    }

    @Transactional
    @DeleteMapping("/{numero}")
    public ResponseEntity<NotaServico> deletarNFSE(@PathVariable int numero) {
        repository.deleteByNumeroNFSE(numero);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DetalharNFSE> atualizarNFSE(@RequestBody @Valid AtualizarNFSE dados) {
        var nota = repository.getReferenceByNumeroNFSE(dados.numeroNFSE());
        nota.atualizarNFSE(dados);
        return ResponseEntity.ok(new DetalharNFSE(nota));
    }
}
