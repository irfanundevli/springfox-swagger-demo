package com.kodstrukt.demo.swagger.springfox.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Lists.newArrayList;

@Configuration
public class SecuredApisSwagger2Config extends Swagger2Config {

    private static final String BASIC_AUTH = "basicAuth";


    @Bean
    public Docket privateApisDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Secured APIs")
                .select()
                .apis(restApis())
                .paths(not(queryEndpoints()))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder()
                                .code(HttpStatus.BAD_REQUEST.value())
                                .message("Input is invalid")
                                .build()
                        ))
                .globalResponseMessage(RequestMethod.PUT, newArrayList(
                        new ResponseMessageBuilder()
                                .code(HttpStatus.NOT_FOUND.value())
                                .message("Entity not found")
                                .build()))
                .securitySchemes(Arrays.asList(basicAuth()))
                .securityContexts(Arrays.asList(securityContext()))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Secured REST APIs",
                "Secured REST APIs documentation",
                "1",
                null,
                null,
                null, null, Collections.emptyList());
    }


    private BasicAuth basicAuth() {
        return new BasicAuth(BASIC_AUTH);
    }


    private SecurityContext securityContext() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder()
                .scope("write")
                .description("write access")
                .build();

        SecurityReference securityReference = SecurityReference.builder()
                .reference(BASIC_AUTH)
                .scopes(authScopes)
                .build();

        return SecurityContext.builder().securityReferences
                (newArrayList(securityReference)).build();

    }



}
