package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI VendorsAPI() {
        return new OpenAPI()
                .info(new Info().title("Vendors Manager API")
                        .description("API para administrar proveedores, sucursales, domicilios y colaboradores")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                        .contact(new Contact()
                                .name("Developer: Sebastián Matías Hidalgo")
                                .url("https://github.com/sebasshidalgo")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}