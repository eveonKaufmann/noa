package ch.nyp.noa.webContext.domain.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.nyp.noa.webContext.domain.role.Role;
import ch.nyp.noa.webContext.domain.role.RoleRepository;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * 
	 */
	public UserServiceImpl() {
		super();
	}

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	//Could implement own AuthenticationManager to return customErrors and implement stuff like MaximumLoginAttempts etc. 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		//Principal principal = new Principal(user);
		//System.out.println(principal.isAccountNonExpired()+" "+principal.isCredentialsNonExpired()+" "+principal.isAccountNonLocked()+" "+principal.isEnabled());
		if(user == null) {
			throw new UsernameNotFoundException("User could not be found");
		}
		return new UserDetailsImpl(user);
	}

	@Override
	public User findById(long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	@Override
	public User findByUsername(String userName) {
		User foundUser = userRepository.findByUsername(userName);
		return foundUser;
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setLocked(false);
		userRepository.save(user);
		
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void deleteByUsername(String username) {
		userRepository.deleteByUsername(username);
		
	}

}

