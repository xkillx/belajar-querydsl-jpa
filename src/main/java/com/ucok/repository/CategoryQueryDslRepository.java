package com.ucok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.ucok.model.Category;
import com.ucok.model.QCategory;
import com.ucok.model.QProduct;

@Repository
public class CategoryQueryDslRepository extends QueryDslRepositorySupport {

	public CategoryQueryDslRepository() {
		super(Category.class);
	}
	
	public List<Category> findAll() {
		QCategory category = QCategory.category;
		QProduct product = new QProduct("product");
		return from(category).innerJoin(category.products, product).distinct().fetchJoin().fetch();
	}

}
