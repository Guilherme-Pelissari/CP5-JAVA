package com.example.flywaydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flywaydemo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}


