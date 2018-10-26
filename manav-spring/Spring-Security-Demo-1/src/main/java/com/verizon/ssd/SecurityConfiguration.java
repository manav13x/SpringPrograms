package com.verizon.ssd;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//ExpressionInterceptUrlregistry

		http.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("CLERK","ADMIN");
		
		//http.authorizeRequests()
		//.antMatchers("/cave/**").hasRole("CLERK");
		//helps us define access control
		//authenticated means any logged user
		
		//http.authorizeRequests().anyRequest();
		//http.csrf().disable();
		
		
		http.authorizeRequests().antMatchers("/cave/**").authenticated();
		
		http.formLogin()//FormLoginConfigurer
		.loginPage("/login")//FormLoginConfigurer
		.defaultSuccessUrl("/")
		.failureUrl("/login?err=true")
		.usernameParameter("unm")
		.passwordParameter("pwd");
	

		http.logout()//LogoutConfigurer
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
		//IgnoreRequestConfigurer
	}

}
