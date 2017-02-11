package com.ucok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ucok.model.Category;
import com.ucok.model.Product;
import com.ucok.repository.CategoryQueryDslRepository;
import com.ucok.repository.CategoryRepository;
import com.ucok.repository.ProductQueryDslRepository;
import com.ucok.repository.ProductRepository;

@SpringBootApplication
public class QuerydslApplication {

	private static final Logger log = LoggerFactory.getLogger(QuerydslApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuerydslApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, CategoryRepository categoryRepository,
			CategoryQueryDslRepository categoryQueryDslRepository,
			ProductQueryDslRepository productQueryDslRepository) {
		return (args) -> {
			Category category = new Category();
			category.setName("Makanan");

			Product product = new Product();
			product.setCategory(category);
			product.setName("Permen");
			product.setPrice(1000);
			category.getProducts().add(product);

			product = new Product();
			product.setCategory(category);
			product.setName("Chiki");
			product.setPrice(1000);
			category.getProducts().add(product);

			product = new Product();
			product.setCategory(category);
			product.setName("Indomie");
			product.setPrice(2000);
			category.getProducts().add(product);

			product = new Product();
			product.setCategory(category);
			product.setName("Gado-Gado");
			product.setPrice(10000);
			category.getProducts().add(product);

			categoryRepository.save(category);

			/*
			 * log.info("Products with price 2000:");
			 * log.info("-------------------------------"); for (Product p :
			 * productRepository.findAll(predicate)) { log.info(p.toString()); }
			 * log.info("");
			 */

			log.info("Products found with findAll():");
			log.info("-------------------------------");
			for (Category c : categoryQueryDslRepository.findAll()) {
				log.info(String.format("%d, %s", c.getId(), c.getName()));

				c.getProducts().stream()
						.forEach(p -> log.info(String.format("%d, %s, %d", p.getId(), p.getName(), p.getPrice())));
			}
			log.info("");

		};
	}
}
