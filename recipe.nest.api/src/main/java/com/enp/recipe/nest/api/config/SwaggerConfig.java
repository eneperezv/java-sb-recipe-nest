package com.enp.recipe.nest.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.yourproject")) // Reemplaza con el paquete base de tus controladores
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("RECIPENEST.API")
	            .description("API para compartir recetas")
	            .version("1.0")
	            .termsOfServiceUrl("Términos de servicio")
	            .contact(new Contact("Eliezer Navarro", "http://www.example.com", "tu.correo@example.com"))
	            .license("Licencia")
	            .licenseUrl("URL de la licencia")
	            .build();
	}

}
