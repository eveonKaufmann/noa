package ch.nyp.noa.config.security;

import io.jsonwebtoken.Jwts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.nyp.noa.config.PropertyReader;
import ch.nyp.noa.webContext.domain.user.UserDetailsImpl;
import ch.nyp.noa.webContext.domain.user.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter that handles the authorization and JWT parsing process 
 * process
 *
 * @author Yves Kaufmann
 */
class JWTAuthorizationFilter extends OncePerRequestFilter {

	private UserServiceImpl userServiceImpl;
	private AuthenticationManager authenticationManager;
	private PropertyReader propertyReader;
	
	/**
	 * @param authenticationManager
	 * @param userServiceImpl
	 * @param propertyReader
	 */
	JWTAuthorizationFilter(AuthenticationManager authenticationManager,UserServiceImpl userServiceImpl, PropertyReader propertyReader) {
		this.authenticationManager = authenticationManager;
		this.userServiceImpl = userServiceImpl;
		this.propertyReader = propertyReader;
	}
	
	/**
	 * Aligns and compares header with internal properties
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(propertyReader.getStringProperty("jwt.header-string"));
		if (header == null || !header.startsWith(propertyReader.getStringProperty("jwt.token-prefix"))) {
			chain.doFilter(req, res);
		}

		SecurityContextHolder.getContext().setAuthentication(getAuthentication(req,header));
		chain.doFilter(req, res);	
	}

	/**
	 * Parses JWT and puts content into an authenticationToken
	 *
	 * @param req   Client request
	 * @param header Header string
	 * 
	 * @return UsernamePasswordAuthenticationToken
	 */
	private Authentication getAuthentication(HttpServletRequest req, String header) {
			String subject = Jwts.parser().setSigningKey(propertyReader.getStringProperty("jwt.secret").getBytes())
					.parseClaimsJws(header.replace(propertyReader.getStringProperty("jwt.token-prefix"), "")).getBody().getSubject();
			if (subject != null) {
				UserDetailsImpl userDetails = new UserDetailsImpl(userServiceImpl.findById(Long.parseLong(subject)));
				return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			}
			return null;
	}
	
}