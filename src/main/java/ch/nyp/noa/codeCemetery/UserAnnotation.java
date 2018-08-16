package ch.nyp.noa.codeCemetery;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserAnnotationConstraintValidator.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {

	public String value() default "defaultValue";
	
	public String message() default "defaultErrorMessage";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
}
