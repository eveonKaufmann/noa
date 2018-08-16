package ch.nyp.noa.webContext.domain.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.nyp.noa.webContext.domain.authority.Authority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "role")
	private String role;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> authorities;

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param id
	 * @param role
	 * @param authorities
	 */
	public Role(int id, String role, Set authorities) {
		super();
		this.id = id;
		this.role = role;
		this.authorities = authorities;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the authorities
	 */
	public Set getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set authorities) {
		this.authorities = authorities;
	}

}
