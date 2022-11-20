package org.example.validation.rule;

import org.example.annotations.NotNull;
import org.example.validation.ValidationResult;

import java.lang.reflect.Field;

public interface ICheckValidationRule {

    <T> void validate(ValidationResult<T> validationResult) throws IllegalAccessException;

}
