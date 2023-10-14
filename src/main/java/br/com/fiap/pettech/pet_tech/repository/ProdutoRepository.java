package br.com.fiap.pettech.pet_tech.repository;

import java.util.UUID;

import br.com.fiap.pettech.pet_tech.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
