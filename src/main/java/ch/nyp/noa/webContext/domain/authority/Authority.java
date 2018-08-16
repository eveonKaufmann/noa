package ch.nyp.noa.webContext.domain.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.nyp.noa.config.generic.ExtendedEntity;

/**
 * Entity authority. A role can have multiple authorities. E.g "READ_PRIVILEDGE"
 *
 * @author Yves Kaufmann
 */
@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity{

	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	public Authority(Long id) {
		super(id);
	}

	/**
	 * @param id
	 * @param authority
	 */
	public Authority(int id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * @return the authority
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
