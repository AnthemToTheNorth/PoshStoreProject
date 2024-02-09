package com.project.headbridgeproject.poshStore.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Сервис каршеринга")
                        .description("Бронируй машину и катайся где хочешь")
                        .version("1.0")
                        .contact(new Contact().name("Andrei Gavrilov")
                                .email("my@email.com"))
                );
    }
}
