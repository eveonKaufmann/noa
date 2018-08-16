package ch.nyp.noa.config.generic;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Generic interface that extends JPARepository and implements all methods which are common among the domain repositories 
 *
 * @author Yves Kaufmann
 */
public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository <T, Long> {
	
	// e.g E findByName (String name);
	
}

