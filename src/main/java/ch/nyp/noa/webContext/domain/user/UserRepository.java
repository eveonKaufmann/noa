package ch.nyp.noa.webContext.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

	User findByUsername(String username);
	
	void deleteByUsername(String username);
	
}
