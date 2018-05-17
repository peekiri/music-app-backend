package com.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * Adding spring-security to the project, will add an inmemoryauthentication.
	 * To provide the username and password before sending any request.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		// Including bcrypt bean , the password will be encoded; So, encode() the password.
		String password = bCryptPasswordEncoder().encode("user");
		auth.inMemoryAuthentication()
			.withUser("user")
			.password(password).roles("user");
	}
	
	/**
	 * Specify , which REST api needs to be allowed without authentication.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.cors().and().authorizeRequests()
			// permit "/user/register" without any authorization.
			.antMatchers(HttpMethod.POST,SecurityConstants.REGISTERURL).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}
	
	/**
	 * Password encoder for encoding the password before saving the password in db.
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
