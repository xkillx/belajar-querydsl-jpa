package com.ucok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.ucok.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>, QueryDslPredicateExecutor<Category> {

}
