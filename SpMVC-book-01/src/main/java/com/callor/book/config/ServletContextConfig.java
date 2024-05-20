package com.callor.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.callor.book.controller" })
public class ServletContextConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	 * REST API 를 통해서 다른 Server 의 데이터를 수신하기 위한 도구
	 * 이 도구를 Bean 으로 설정하여 Single Tone 으로 동작하도록 한다.
	 * 이 도구는 필요한 곳에서 객체를 생성하여 사용할수 있으나,
	 * 자원의 효율적 관리를 위하여 Bean 으로 생성해 두고, 사용한다
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	


}
