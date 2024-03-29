package org.example.validation;

import org.example.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult<T> {


    private T validatedObject;
    private boolean isValid;
    private Map<String, List<String>> notValidFields = new HashMap<String, List<String>>();

    public T getValidatedObject() {
        return validatedObject;
    }

    public void setValidatedObject(T validatedObject) {
        this.validatedObject = validatedObject;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }
}