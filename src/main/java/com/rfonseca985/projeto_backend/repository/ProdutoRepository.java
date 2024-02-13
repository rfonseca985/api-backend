package com.rfonseca985.projeto_backend.repository;

import com.rfonseca985.projeto_backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de Repositório para a entidade Produto, utilizando o Spring Data JPA.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    /**
     * Este é um repositório específico para a entidade Produto.
     * Ele estende JpaRepository, fornecendo operações CRUD padrão para a entidade.
     * A chave primária da entidade Produto é do tipo Integer.
     */
}
