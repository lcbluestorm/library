package com.digithn.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.digithn.library.control"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(Collections.singletonList(
                        new RequestParameterBuilder()
                                .name("token") // Header参数的名称
                                .description("user token")
                                .in(ParameterType.HEADER)
                                .required(false)
                                .build()));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("【数字海南】图书管理系统API")
                .description("主要包括系统对外的http接口、接口请求参数以及返回数据。")
                .version("1.0")
                .build();
    }

}
