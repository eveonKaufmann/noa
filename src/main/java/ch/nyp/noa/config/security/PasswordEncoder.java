package ch.nyp.noa.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Holds all password encoder beans
 *
 * @author Yves Kaufmann
 */
@Configuration
public class PasswordEncoder {
	
	@Bean
	public BCryptPasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
