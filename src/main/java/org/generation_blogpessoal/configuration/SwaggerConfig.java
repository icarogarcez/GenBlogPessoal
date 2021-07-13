package org.generation_blogpessoal.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.generation_blogpessoal.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessageForGET());

	}

	public static ApiInfo metadata() {

		return new ApiInfoBuilder().title("Gossip Icarus").description("Projeto Blog Pessoal - Bloco II, Generation Brasil.")
				.version("1.0.0").license("Apache License Version 2.0").licenseUrl("http://localhost:8080/swagger-ui/")
				.contact(contact()).build();
	}

	private static Contact contact() {

		return new Contact("Ícaro Garcez", "https://github.com/icarogarcez", "garcezicaro@gmail.com");

	}

	private static List<Response> responseMessageForGET() {

		return new ArrayList<Response>() {

			private static final long serialVersionUID = 1L;

			{
				add(new ResponseBuilder().code("200").description("Tudo ok!").build());
				add(new ResponseBuilder().code("201").description("Prontinho, tá na mão.").build());
				add(new ResponseBuilder().code("401").description("Opa, não autorizado.").build());
				add(new ResponseBuilder().code("403").description("Ish, proibido.").build());
				add(new ResponseBuilder().code("404").description("Não encontrado, tente novamente!").build());
				add(new ResponseBuilder().code("500").description("Erro, mas nada que não possa ser consertado, né?").build());
			}
		};

	}

}