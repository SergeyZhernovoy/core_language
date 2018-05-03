package webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("john")
				.password("123")
				.roles("USER");
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("123")
				.roles("USER","ADMIN");
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/")
				.permitAll()
				.antMatchers("/**/add")
				.access("hasRole('ADMIN')")
				.antMatchers("/**/products/**")
				.access("hasRole('USER')");
		httpSecurity.csrf().disable();
		httpSecurity.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.usernameParameter("password");
		httpSecurity.formLogin()
				.defaultSuccessUrl("/products/add")
				.failureUrl("/login?error");
		httpSecurity.logout()
				.logoutSuccessUrl("/login?logout");
		httpSecurity.exceptionHandling()
				.accessDeniedPage("/login?accessDenied");
		
	}
}