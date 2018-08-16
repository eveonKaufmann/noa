package ch.nyp.noa.webContext.domain.authority;

import ch.nyp.noa.config.generic.ExtendedJpaRepository;

/**
 * Specific AuthorityRepository interface
 *
 * @author Yves Kaufmann
 */
interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

	/**
	 * Finds an Authority with a given name
	 *
	 * @param name Descriptive name of Authority
	 * @return Returns requested Authority with given descriptive name of Authority
	 */
	Authority findByName(String name);

	/**
	 * Deletes the requested authority with a given name
	 *
	 * @param name Descriptive name of Authority
	 */
	Authority deleteByName(String name);

}
