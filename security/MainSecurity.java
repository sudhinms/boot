package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MainSecurity
{
	private static final String[] WHITE_LIST= {
		"/customer/login","/customer/register","/customer/register/save"	
	} ;
	
	private static String[] RESOURCE_FILES= {
	  "/admin/**","/css/**","/fonts/**","/img/**","/js/**","/sass/**","/Source/**"};
	
	
	  @Bean
	  public PasswordEncoder encoder()
	  {
		  return new BCryptPasswordEncoder();
	  }
 
	  @Bean
	  SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		  
		  http	
		  .cors()
		  .and()
		  .csrf().disable()
		  .authorizeHttpRequests()
		  .requestMatchers(RESOURCE_FILES).permitAll()
          .requestMatchers(WHITE_LIST).permitAll()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/customer/login")
          .loginProcessingUrl("/customer/login?success=true")
          .defaultSuccessUrl("/customer/home/index")
          .permitAll()
          .and()
      .logout()
          .permitAll();
		  
		  return http.build();
	  }
	  
}
