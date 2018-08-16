package ch.nyp.noa.config.generic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Class that covers the common attributes of all entities
 *
 * @author Yves Kaufmann
 */
@MappedSuperclass
public abstract class ExtendedEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	/**
	 * 
	 */
	public ExtendedEntity() {
		super();
	}

	/**
	 * @param id
	 */
	public ExtendedEntity(long id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}