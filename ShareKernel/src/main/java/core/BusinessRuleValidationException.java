package core;

public class BusinessRuleValidationException extends Exception {

    private BusinessRule brokenRule;

    public BusinessRuleValidationException(BusinessRule brokenRule) {
        this.brokenRule = brokenRule;
    }

    @Override
    public String toString() {
        return "BusinessRule " + brokenRule.getMessage() ;
    }
}
