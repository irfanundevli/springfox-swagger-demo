package com.kodstrukt.demo.swagger.springfox.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.kodstrukt.demo.swagger.springfox.configuration.WebSecurityConfig.PUBLIC_APIS_URL_MAIN_PART;

@Import(BeanValidatorPluginsConfiguration.class)
@EnableSwagger2
@Configuration
public class Swagger2Config {

    protected Predicate<RequestHandler>  restApis(){
        return RequestHandlerSelectors.withClassAnnotation(RestController.class);
    }

    protected Predicate<String> queryEndpoints() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains(PUBLIC_APIS_URL_MAIN_PART);
            }
        };
    }

}
