package com.music.MusicLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EntityScan(basePackages="com.music.entities")
@ComponentScan(basePackages="com.music")
@EnableJpaRepositories(basePackages="com.music.repositories")
public class MusicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryApplication.class, args);
	}
	
	/**
	 * Bean for creation of resourceBundle.
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource messageSource(){
		
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("messages/message");
		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
		
		return resourceBundleMessageSource;
	}
	
	/**
	 * This configuration is for Cross Origin requests,
	 * It allows the communication between different origins of request.
	 * eg- Angular is running on port 4200 and backend on 8008.
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer webMvcAutoConfiguration () {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
	

}
