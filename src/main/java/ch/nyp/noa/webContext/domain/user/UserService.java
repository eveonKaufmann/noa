package ch.nyp.noa.webContext.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

	User findById(long id);
    
    User findByUsername(String username);
     
    void save(User user);
     
    void update(User user);
     
    void deleteById(long id);
    
    void deleteByUsername(String username);
	
}
