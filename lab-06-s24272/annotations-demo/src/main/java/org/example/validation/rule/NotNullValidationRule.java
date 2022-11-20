package org.example.validation.rule;

import org.example.annotations.NotNull;
import org.example.validation.ValidationResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotNullValidationRule implements ICheckValidationRule {

    @Override
    public <T> void validate(ValidationResult<T> result) {
        Class<?> clazz = result.getValidatedObject().getClass();
            List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));
            fields.stream()
                    .filter(field -> field.isAnnotationPresent(NotNull.class))
                    .forEach(f -> {

                    var notNull = f.getAnnotation(NotNull.class);
                    f.setAccessible(true);
                    try {
                        if (f.get(result.getValidatedObject()) == null) {
                            result.setValid(false);
                            result.getNotValidFields().putIfAbsent(f.getName(), new ArrayList<>());
                            result.getNotValidFields().get(f.getName()).add(notNull.message());
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }


            });
        

    }
}

