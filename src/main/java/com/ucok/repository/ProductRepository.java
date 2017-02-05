package com.ucok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.ucok.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, QueryDslPredicateExecutor<Product> {

}
