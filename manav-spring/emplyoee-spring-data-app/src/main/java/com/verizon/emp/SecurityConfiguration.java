package com.verizon.emp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER").and().withUser("admin")
				.password("{noop}admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

		http.authorizeRequests().antMatchers("/searchEmplyoee/**").hasAnyRole("USER","ADMIN");
		//http.authorizeRequests().antMatchers("/addEmplyoee/**").authenticated();
		http.authorizeRequests().antMatchers("/addEmplyoee/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/deleteEmp/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/editEmp/**").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/addEmplyoee/**").access("ADMIN");
		http.formLogin()// FormLoginConfigurer
				.loginPage("/login")// FormLoginConfigurer
				.defaultSuccessUrl("/").failureUrl("/login?err=true").usernameParameter("unm").passwordParameter("pwd");

		http.logout()// LogoutConfigurer
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
		// IgnoreRequestConfigurer
	}

}
