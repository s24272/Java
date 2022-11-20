package org.example.validation;


import org.example.validation.rule.ICheckValidationRule;


import java.util.ArrayList;
import java.util.List;


public class Validator {
    private List<ICheckValidationRule> validationRuleList = new ArrayList<>();
    public <T> ValidationResult<T> validate(T sampleObject) {
        var validationResult = new ValidationResult<T>();
        validationResult.setValidatedObject(sampleObject);
        validationResult.setValid(true);
        for(ICheckValidationRule rule : validationRuleList) {
            try {
                rule.validate(validationResult);
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return validationResult;
    }

    public Validator addRule(ICheckValidationRule notNullValidationRule) {
        this.validationRuleList.add(notNullValidationRule);
        return this;
    }
}
