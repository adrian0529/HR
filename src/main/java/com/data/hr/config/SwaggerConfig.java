package com.data.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.data.hr"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Human resource",
                "Test services",
                "1.0 ",
                "https//abc.com",
                new Contact("Adrian Aleman", "https://abc.com", "aaleman@abc.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList());
    }
}
