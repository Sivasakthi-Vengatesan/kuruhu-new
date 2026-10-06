package com.kuruhu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI kuruhuOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KURUHU (ಪ್ರಮಾಣ) Police Intelligence & Investigation API")
                        .description("Karnataka State Police SCRB Investigation Platform REST API Architecture Scaffold")
                        .version("3.0.0")
                        .contact(new Contact().name("Karnataka State Police SCRB").email("scrb@ksp.gov.in"))
                        .license(new License().name("Government of Karnataka - Internal Security Use Only")));
    }
}
