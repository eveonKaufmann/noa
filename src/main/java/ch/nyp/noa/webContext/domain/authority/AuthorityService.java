package ch.nyp.noa.webContext.domain.authority;

import ch.nyp.noa.config.generic.CrudService;

/**
 * Specific AuthorityService interface
 *
 * @author Yves Kaufmann
 */
interface AuthorityService extends CrudService<Authority>{

	/**
	 * Deletes the requested authority with a given name
	 *
	 * @param name Descriptive name of Authority
	 */
	void deleteByName(String name);

}
