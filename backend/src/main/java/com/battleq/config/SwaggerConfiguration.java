package com.battleq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    /**
     * 스웨거 API 문서 생성
     */
    @Bean
    public Docket swaggerAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.host("localhost")
                .apiInfo(this.swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true); // 기본으로 세팅되는 200, 401, 403, 404 메시지 표시
    }

    /**
     * 스웨거 정보
     */
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API Documentation")
                .description("Battle Q 프로젝트의 REST API 개발 단계 문서화입니다.")
                .version("1.0.0")
                .build();
    }
}
