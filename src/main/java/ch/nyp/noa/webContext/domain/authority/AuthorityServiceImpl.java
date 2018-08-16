package ch.nyp.noa.webContext.domain.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.nyp.noa.config.generic.CrudServiceImpl;

/**
 * Specific AuthorityService implementation
 *
 * @author Yves Kaufmann
 */
@Service
class AuthorityServiceImpl extends CrudServiceImpl<Authority> implements
AuthorityService {

	@Autowired
	AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}

	@Override
	public void deleteByName(String name) {
		
	}

}
