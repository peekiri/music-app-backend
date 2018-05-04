package com.music.MusicLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com.music.entities")
@ComponentScan(basePackages="com.music")
@EnableJpaRepositories(basePackages="com.music.repositories")
public class MusicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryApplication.class, args);
	}

}
