package ch.nyp.noa.webContext.domain.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.nyp.noa.webContext.domain.role.Role;
import ch.nyp.noa.webContext.domain.role.RoleRepository;
import ch.nyp.noa.webContext.domain.role.RoleServiceImpl;
import ch.nyp.noa.webContext.domain.user.dto.UserDTO;
import ch.nyp.noa.webContext.validation.validator.EmailValidator;
import ch.nyp.noa.webContext.validation.validator.UserValidator;

@RestController
public class UserController {

	// Services
	private UserServiceImpl userServiceImpl;
	private RoleServiceImpl roleServiceImpl;

	// Validators
	private UserValidator userValidator;
	private EmailValidator emailValidator;
	
	/**
	 * 
	 */
	public UserController() {
		super();
	}

	/**
	 * @param userServiceImpl
	 * @param roleServiceImpl
	 * @param userValidator
	 * @param emailValidator
	 */
	@Autowired
	public UserController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl, UserValidator userValidator,
			EmailValidator emailValidator) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.roleServiceImpl = roleServiceImpl;
		this.userValidator = userValidator;
		this.emailValidator = emailValidator;
	}

	// Subroutine that executes prior to the actual invocation of a restEndpoint
	// (Can have multiple)
	@InitBinder("userDTO")
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(userValidator);
	}

	@PostMapping("/registerUser")
	public User createUser(@Valid @RequestBody UserDTO userDTO) {
		return null;
	}

	
	// FOR TESTING PURPOSE
	
	@GetMapping("/welcome")
	public String receiveWelcomeMessage() {

		User user = new User();
		user.setUsername("heinz");
		user.setPassword("heinz");
		userServiceImpl.save(user);
		return "Welcome to Noa";
	}

	@GetMapping("/adminRole")
	public Integer receiveAdminRole() {

		Role userRole = roleServiceImpl.findByRole("ADMIN");
		return userRole.getId();
	}

	@GetMapping("/welcomeSecured")
	public String receiveWelcomeMessageSecured() {

		User user = new User();
		user.setUsername("Yves");
		user.setPassword("Password");

		Set<Role> roles = new HashSet<>();
		Role userRole = roleServiceImpl.findByRole("ADMIN");
		roles.add(userRole);
		user.setRoles(roles);
		userServiceImpl.save(user);
		return "Welcome to Noa Secured";
	}

	@GetMapping("/returnCurrentUser")
	public String getCurrentUser() {

		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDetails.getUser();
		return user.getUsername();

	}
}
