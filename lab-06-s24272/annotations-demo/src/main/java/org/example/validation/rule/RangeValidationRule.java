package org.example.validation.rule;


import org.example.annotations.Range;
import org.example.validation.ValidationResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RangeValidationRule implements ICheckValidationRule {
    @Override
    public <T> void validate(ValidationResult<T> validationResult) {
        Class<?> clazz = validationResult.getValidatedObject().getClass();
        List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));

        fields.forEach(f->{
            if(f.isAnnotationPresent(Range.class)) {
                var range = f.getAnnotation(Range.class);
                f.setAccessible(true);
                try {
                    if(f.getInt(validationResult.getValidatedObject()) > range.max() ||  f.getInt(validationResult.getValidatedObject()) < range.min()){
                        validationResult.setValid(false);
                        validationResult.getNotValidFields().putIfAbsent(f.getName(), new ArrayList<>());
                        validationResult.getNotValidFields().get(f.getName()).add(range.message().formatted(range.min(),range.max()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
