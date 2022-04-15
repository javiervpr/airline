package rules;

import core.BusinessRule;

public record NotNullRule(Object object) implements BusinessRule {

    @Override
    public boolean isValid() {
        return this.object != null;
    }

    @Override
    public String getMessage() {
        return "Object can not be null";
    }
}
