package com.example.supermercado.supermarket_api.repository;

import com.example.supermercado.supermarket_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
