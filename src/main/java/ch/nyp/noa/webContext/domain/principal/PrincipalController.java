package ch.nyp.noa.webContext.domain.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.nyp.noa.webContext.domain.role.RoleServiceImpl;
import ch.nyp.noa.webContext.domain.user.User;
import ch.nyp.noa.webContext.domain.user.UserDetailsImpl;
import ch.nyp.noa.webContext.domain.user.UserMapper;
import ch.nyp.noa.webContext.domain.user.UserServiceImpl;
import ch.nyp.noa.webContext.domain.user.dto.UserDTO;
import ch.nyp.noa.webContext.exceptionHandling.EntityNotFoundException;
import ch.nyp.noa.webContext.validation.validator.UserValidator;


//Principal is the currently logged in user. A traditional user should only be able to change its own details 
// and not other users details, meaning he should only be able to access the PrincipalController Endpoints.
// If youre an admin with the right authorities youre able to access the user interface.  

@RestController
public class PrincipalController {

	private UserServiceImpl userServiceImpl;
	private UserValidator userValidator;
	
	/**
	 * 
	 */
	public PrincipalController() {
		super();
	}

	/**
	 * @param userServiceImpl
	 * @param userValidator
	 */
	@Autowired
	public PrincipalController(UserServiceImpl userServiceImpl, UserValidator userValidator) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.userValidator = userValidator;
	}

	@InitBinder("userDTO")
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(userValidator);
	}

	@GetMapping("/getPrincipal")
	public User getPrincipal() {
		//UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		//return userDetails.getUser();
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDetails.getUser();
		return user;
		//return new ResponseEntity<UserDTO>(UserMapper.INSTANCE.userToUserDTO(userDetails.getUser()), HttpStatus.OK);
	}
	
	/**
	 * @PostMapping("/createPrincipal/{id}") public User createPrincipal(@RequestBody
	 * UserDTO userDTO) {return null;}
	 */

	@PutMapping("/updatePrincipal")
	public UserDTO updatePrincipal(@RequestBody UserDTO userDTO, @PathVariable long id) {
		User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
		userServiceImpl.save(user);
		userDTO = UserMapper.INSTANCE.userToUserDTO(user);
		return userDTO;
	}

	@DeleteMapping("/deletePrincipal/{id}")
	public void deletePrincipal(@PathVariable long id) {
		userServiceImpl.deleteById(id);
	}
}
