package com.fiap.techChallenge3.apiFase3.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Estacionamento CRUD")
                        .description("API de controle de estacionamento - CRUDs"));
    }
}
