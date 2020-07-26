package com.mosesjebish.oneservice.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage( "com.mosesjebish.oneservice.controller" ))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    @Bean
    public LinkDiscoverers discoverers(){
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "One Service API",
                "1.0",
                "Free to use",
                "Service API as a part of Microservices",
                new Contact("Jebish Moses", "https://github.com/mosesjebish", "mosesjebish@gmail.com"),
                "API License",
                null,
                Collections.emptyList());

    }
}