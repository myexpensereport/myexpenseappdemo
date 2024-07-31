package com.sp.myexpense.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	/*
	 * @Bean public Docket SwaggerApi() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build(); }
	 */
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {

	        registry
	                .addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");

	        registry
	                .addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }

	    @Bean
	    public Docket apiDocket() {

	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.sp.myexpense.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo getApiInfo() {

	        return new ApiInfoBuilder()
	                .title("Swagger API Doc")
	                .description("More description about the API")
	                .version("1.0.0")
	                .build();
	    }
}
