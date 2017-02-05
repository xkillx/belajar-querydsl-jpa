package com.ucok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.ucok.model.Product;
import com.ucok.model.QProduct;
import com.ucok.repository.ProductRepository;

@SpringBootApplication
public class QuerydslApplication {

	private static final Logger log = LoggerFactory.getLogger(QuerydslApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuerydslApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			repository.save(Product.builder().name("Aqua").price(15000).build());
			repository.save(Product.builder().name("Indomie").price(2000).build());
			repository.save(Product.builder().name("Kopi").price(2000).build());
			repository.save(Product.builder().name("Aqua").price(15000).build());
			
			QProduct product = QProduct.product;
			Predicate predicate = product.price.eq(2000);
			
			log.info("Products with price 2000:");
			log.info("-------------------------------");
			for (Product p : repository.findAll(predicate)) {
				log.info(p.toString());
			}
			log.info("");
			

			log.info("Products found with findAll():");
			log.info("-------------------------------");
			for (Product p : repository.findAll()) {
				log.info(p.toString());
			}
			log.info("");
		};
	}
}
