package br.com.fiap.pettech.pettech;

import jakarta.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoSerivce {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(UUID id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(UUID id, Produto produto) {
        Optional<Produto> produtoAtual = produtoRepository.findById(id);

        if (produtoAtual.isPresent()) {
            Produto produtoSalvo = produtoAtual.get();
            produtoSalvo.setNome(produto.getNome());
            produtoSalvo.setDescricao(produto.getDescricao());
            produtoSalvo.setPreco(produto.getPreco());
            produtoSalvo.setUrlDaImagem(produto.getUrlDaImagem());
            return produtoRepository.save(produtoSalvo);
        }
        return produto;
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }
}
