package edu.deakin.sit218.vulnweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin").roles("ADMIN"));
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.defaultSuccessUrl("/post-login", true)
			.permitAll()
		.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		http.sessionManagement().maximumSessions(2);
	}
}
