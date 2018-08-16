package ch.nyp.noa.webContext.domain.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.mapping.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ch.nyp.noa.webContext.domain.role.Role;

@Entity
@Table(name = "users")
public class User {
	//IDENTITY vs SEQUENCE https://www.thoughts-on-java.org/hibernate-postgresql-5-things-need-know/
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	//@SequenceGenerator(name="user_generator", sequenceName = "user_seq_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	//Interface UserDetails related attributes

	@Column(name = "account_expiration_date")
	@Type(type="date")
	private Date accountExpirationDate;
	
	@Column(name = "credentials_expiration_date")
	@Type(type="date")
	private Date credentialsExpirationDate;
	
	@Column(name = "locked")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean locked;

	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param roles
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 */
	public User(int id, String username, String password, String firstname, String lastname, String email,
			Set<Role> roles, Date accountExpirationDate, Date credentialsExpirationDate, boolean locked,
			boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roles = roles;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the accountExpirationDate
	 */
	public Date getAccountExpirationDate() {
		return accountExpirationDate;
	}

	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the credentialsExpirationDate
	 */
	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}