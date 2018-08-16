package ch.nyp.noa.webContext.domain.user.dto;


public class UserDTO {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	
	/**
	 * 
	 */
	public UserDTO() {
		super();
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 */
	public UserDTO(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
}

/**
 * @Test public void shouldMapCarToDto() { //given Car car = new Car( "Morris",
 *       5, CarType.SEDAN );
 * 
 *       //when CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );
 * 
 *       //then assertThat( carDto ).isNotNull(); assertThat( carDto.getMake()
 *       ).isEqualTo( "Morris" ); assertThat( carDto.getSeatCount() ).isEqualTo(
 *       5 ); assertThat( carDto.getType() ).isEqualTo( "SEDAN" ); }
 */