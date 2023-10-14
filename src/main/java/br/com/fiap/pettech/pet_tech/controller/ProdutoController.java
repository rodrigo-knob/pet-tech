package br.com.fiap.pettech.pet_tech.controller;

import java.util.Collection;
import java.util.UUID;

import br.com.fiap.pettech.pet_tech.dto.ProdutoDTO;
import br.com.fiap.pettech.pet_tech.entities.Produto;
import br.com.fiap.pettech.pet_tech.service.ProdutoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoSerivce produtoService;

    @GetMapping
    public ResponseEntity<Collection<ProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produtoService.save(produtoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable UUID id, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok().body(produtoService.update(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
