package com.ucok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.ucok.model.Product;
import com.ucok.model.QCategory;
import com.ucok.model.QProduct;

@Repository
public class ProductQueryDslRepository extends QueryDslRepositorySupport {
	
	public ProductQueryDslRepository() {
		super(Product.class);
	}
	
	public List<Product> findAll() {
		QProduct product = QProduct.product;
		QCategory category = new QCategory("category");
		return from(product).leftJoin(product.category, category).fetchJoin().fetch();
	}
}
