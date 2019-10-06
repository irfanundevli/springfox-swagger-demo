package com.kodstrukt.demo.swagger.springfox.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
public class PublicApisSwagger2Config extends Swagger2Config {

    @Bean
    public Docket publicApisDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Public APIs")
                .select()
                .apis(restApis())
                .paths(queryEndpoints())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(
                        new ResponseMessageBuilder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Entity not found")
                        .build()))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Public REST APIs",
                "Public REST APIs documentation",
                "1",
                null,
                null,
                null, null, Collections.emptyList());
    }

}
