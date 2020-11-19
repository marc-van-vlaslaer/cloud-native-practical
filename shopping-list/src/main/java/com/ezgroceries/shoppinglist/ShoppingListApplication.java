package com.ezgroceries.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  //best to do this in separate Config class
@EnableFeignClients
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}

	//used for defining which type of documentation to exclude all the documentation of
	//Spring components for example
	@Bean
	public Docket api() {
		//return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()  //first you have to call select method = ApiSelectorBuilder
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build(); // to build the document
	}

}
