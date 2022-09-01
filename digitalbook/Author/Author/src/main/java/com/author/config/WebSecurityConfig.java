package com.author.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.author.filter.JwtRequestFilter;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import io.jsonwebtoken.lang.Collections;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// updated-> new
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		    return authenticationConfiguration.getAuthenticationManager();
		}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.jdbcAuthentication()
//		auth.ldapAuthentication()
//		auth.inMemoryAuthentication()
		
 auth.userDetailsService(jwtUserDetailsService);
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// updated-> new
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
// We don't need CSRF for this example
		httpSecurity.cors().and()
		.csrf().disable()
// dont authenticate this particular request
				.authorizeRequests()
				
				.antMatchers("/api/v1/author/authenticate","/api/v1/author/fetch-all-author","/api/v1/author/signup","/v3/api-docs**","/swagger-ui/index.html").permitAll()
				.antMatchers("/api/v1/author/**").access("hasRole('ADMIN')")
				
				
// all other requests need to be authenticated
				.anyRequest().authenticated().and()
// make sure we use stateless session; session won't be
// used to store user's state.
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
		
	
}
