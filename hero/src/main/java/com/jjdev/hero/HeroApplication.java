package com.jjdev.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HeroApplication {

	@Bean
	public WebClient webClient(WebClient.Builder builder){
		return builder // builds a new instance of the WebClient with default values
				.baseUrl("http://localhost:3000")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}

}
