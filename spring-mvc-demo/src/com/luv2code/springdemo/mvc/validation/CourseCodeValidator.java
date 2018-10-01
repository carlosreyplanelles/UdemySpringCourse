package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCode, String>{
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = true;
		if(coursePrefix != null) {
			result = code.startsWith(coursePrefix);
		}
		return result;
	}
	
}
