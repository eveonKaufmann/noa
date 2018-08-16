package ch.nyp.noa.codeCemetery;

public class CodeSnippets {

// Main Security Context - Class SecurityConfiguration
	/**
	 http.authorizeRequests()
    .antMatchers("/welcome").permitAll()
   // .antMatchers("/welcomeSecured").hasAuthority("ROLE_ADMIN")
    .anyRequest().fullyAuthenticated()
    .and().httpBasic()
    .and().csrf().disable();
		*/
	
}
