package com.otto.testapp.robo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@EnableSwagger2
@SpringBootApplication
public class RoboApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(RoboApplication.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                                                      .select()
                                                      .apis(RequestHandlerSelectors.basePackage(getClass().getPackage()
                                                                                                          .getName()))
                                                      .paths(PathSelectors.any())
                                                      .build()
                                                      .apiInfo(generateApiInfo());
    }

	private ApiInfo generateApiInfo() {
        return new ApiInfo("The Cleaning Robo", "This is a fun web application for finding the shortest and correct path for a robo in a square grid matrix :) ", "Version 1.0",
                "prashant.rajan@19gmail.com", "Prashant rajan", "", "");
    }
}
