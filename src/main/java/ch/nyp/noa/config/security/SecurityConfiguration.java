package ch.nyp.noa.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ch.nyp.noa.config.PropertyReader;
import ch.nyp.noa.webContext.domain.user.UserServiceImpl;

/**
 * Main security context
 *
 * @author Yves Kaufmann
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserServiceImpl userServiceImpl;
	private BCryptPasswordEncoder pwEncoder;
	private PropertyReader propertyReader;

	/**
	 * @param userServiceImpl
	 * @param pwEncoder
	 */
	@Autowired
	public SecurityConfiguration(UserServiceImpl userServiceImpl, BCryptPasswordEncoder pwEncoder) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.pwEncoder = pwEncoder;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userServiceImpl).passwordEncoder(this.pwEncoder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		propertyReader = new PropertyReader("jwt.properties");
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/welcome", "/login").permitAll()
				.anyRequest().authenticated().and()
				.addFilterAfter(new JWTAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"),this.authenticationManagerBean(),propertyReader), UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(new JWTAuthorizationFilter(this.authenticationManagerBean(),this.userServiceImpl,propertyReader), UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
