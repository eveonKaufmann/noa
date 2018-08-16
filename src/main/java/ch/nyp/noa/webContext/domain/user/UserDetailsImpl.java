package ch.nyp.noa.webContext.domain.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private User user;
	
	/**
	 * 
	 */
	public UserDetailsImpl() {
		super();
	}

	/**
	 * @param user
	 */
	@Autowired
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	/**
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
			}
		}
		return grantedAuthorities;
	}
*/
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
