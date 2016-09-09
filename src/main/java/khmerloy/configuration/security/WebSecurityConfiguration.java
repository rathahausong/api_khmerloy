package khmerloy.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import khmerloy.services.implement.CustomUserDetailService;

@Configuration
@EnableWebSecurity

public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customuser")
	private CustomUserDetailService user;
	
	@Autowired
	private AjaxAuthenticationSucessHandler sucessHandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(sucessHandler)
			.permitAll();
		http
			.authorizeRequests()
			.antMatchers("/**").hasRole("ADMIN");
		
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
		http.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
