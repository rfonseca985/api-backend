package com.rfonseca985.projeto_backend.repository;

import com.rfonseca985.projeto_backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

}
