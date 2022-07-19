package com.iitr.gl.employeemanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class EmployeeManagerWebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired 
	private UserDetailsService  userMaanagementService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.anonymous()
		 .and()
		 .authorizeRequests()
		 .antMatchers("/", "/api/employees","/api/employees/accessdenied","/api/users/accessdenied").hasAnyRole("USER", "ADMIN")
		 .antMatchers("/api/employees/add", 
					"/api/employees/update", 
					"/api/employees/remove",
					"/api/users", "/api/users/**")
			.hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginProcessingUrl("/login")
			.successForwardUrl("/api/employees").permitAll()
			.and()
			.httpBasic()
			.and().logout().logoutSuccessUrl("/login").permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/api/employees/accessdenied")
			.and()
			.exceptionHandling().accessDeniedPage("/api/users/accessdenied")
			.and().cors().and().csrf().disable();
	}
	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2-console/**");
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userMaanagementService)
                .passwordEncoder(passwordEncoder());
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
	        .and()
	        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}
	*/   

}
