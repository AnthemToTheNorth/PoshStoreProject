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
                        .title("PoshStore")
                        .description("Allow yourself the best")
                        .version("1.0")
                );
    }
}
