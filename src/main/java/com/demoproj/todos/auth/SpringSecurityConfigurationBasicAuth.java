package com.demoproj.todos.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth{

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector)
	{
		return new MvcRequestMatcher.Builder(introspector);
	}
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpsecurity, HandlerMappingIntrospector introspector, MvcRequestMatcher.Builder mvc) throws Exception {
        //1: Response to preflight request doesn't pass access control check
        //2: basic auth

    	httpsecurity.csrf(csrf -> csrf.disable());
        httpsecurity.authorizeHttpRequests((authorize) -> {
            authorize
            .requestMatchers(mvc.pattern(HttpMethod.OPTIONS,  "/**")).permitAll()
            .anyRequest().authenticated();
        });
        httpsecurity.httpBasic(Customizer.withDefaults());
        httpsecurity.cors(Customizer.withDefaults());
        
        return httpsecurity.build();
             
    }
}
