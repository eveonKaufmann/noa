package ch.nyp.noa.webContext.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.nyp.noa.webContext.domain.user.User;
import ch.nyp.noa.webContext.domain.user.UserServiceImpl;
import ch.nyp.noa.webContext.domain.user.dto.UserDTO;
import ch.nyp.noa.webContext.exceptionHandling.EntityNotFoundException;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired 
	private EmailValidator emailValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		if (userServiceImpl.findById(userDTO.getId()) == null) {
			throw new EntityNotFoundException("ID is missing");
		}
		
		try {
			ValidationUtils.invokeValidator(this.emailValidator, userDTO.getEmail(), errors);
		} catch (Exception e) {
			throw new EntityNotFoundException("ID is missing");
		}
	}
}
