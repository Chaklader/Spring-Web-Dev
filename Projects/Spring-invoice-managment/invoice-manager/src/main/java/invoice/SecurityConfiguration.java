package invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
		.and()
		.logout()
		.and()
		.authorizeRequests()
				.antMatchers("/partials/*.html",
						"/partials/templates/*.html",
						"/partials/templates/*/*.html",
						"/").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository());
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

	
}
