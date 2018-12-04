package ru.makhnutin.webapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.role-query}")
	private String roleQuery;

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/api/**", "/css/**").permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll()
				.and().csrf().disable();
		http.logout().logoutSuccessUrl("/login");
		http.exceptionHandling().accessDeniedPage("/accessDenied");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(roleQuery)
		.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
