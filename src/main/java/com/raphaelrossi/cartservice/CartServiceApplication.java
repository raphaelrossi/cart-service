package com.raphaelrossi.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class CartServiceApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("cartservice").select()
				.apis(RequestHandlerSelectors.basePackage("com.raphaelrossi.cartservice.controller"))
				.paths(any()).build().apiInfo(new ApiInfo("Cart Services",
						"A set of services to provide data access to carts", "1.0.0", null,
						new Contact("Raphael Rossi", null, "raphael.rossi@wipro.com"),null,null));
	}
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

}

