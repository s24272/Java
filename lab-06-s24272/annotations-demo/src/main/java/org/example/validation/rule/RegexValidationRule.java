package org.example.validation.rule;

import org.example.annotations.NotNull;
import org.example.annotations.Regex;
import org.example.validation.ValidationResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidationRule implements ICheckValidationRule {

    @Override
    public <T> void validate(ValidationResult<T> result) {
        Class<?> clazz = result.getValidatedObject().getClass();
        List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));
        fields.forEach(f -> {
            if(f.isAnnotationPresent(Regex.class)) {
                var regex = f.getAnnotation(Regex.class);
                f.setAccessible(true);
                try {
                    Pattern pattern = Pattern.compile(regex.pattern());
                    if (!pattern.matcher((CharSequence) f.get(result.getValidatedObject())).find()) {
                        result.setValid(false);
                        result.getNotValidFields().putIfAbsent(f.getName(), new ArrayList<>());
                        result.getNotValidFields().get(f.getName()).add(regex.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        });

    }
}
