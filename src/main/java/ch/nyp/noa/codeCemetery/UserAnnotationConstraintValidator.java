package ch.nyp.noa.codeCemetery;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserAnnotationConstraintValidator implements ConstraintValidator<UserAnnotation, String> {

	private String prefix;

	@Override
	public void initialize(UserAnnotation userAnnotation) {
		prefix = userAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result = value.startsWith(prefix);
		return result;
	}

}
