package com.taskapp;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.taskapp"})
public class TaskappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskappApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class);
	}
	
	/* private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring REST Sample with Swagger")
	                .description("Spring REST Sample with Swagger")
	                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
	                .contact("Niklas Heidloff")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
	                .version("2.0")
	                .build();
	    }*/
}
