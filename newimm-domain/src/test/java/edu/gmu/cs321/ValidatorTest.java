package edu.gmu.cs321;
public class ValidatorTest {

    private ValidatorTest validator;

    public void setUp() {
        validator = new ValidatorTest();
    }

    // Test for validating a correct form
    public void testValidateFormSuccess() {
        boolean result = validator.validateForm("correctForm");
        if (!result) {
            System.out.println("Test failed: validateForm() should return true for a valid form");
        }
    }

    // Test for validating an incorrect form
    public void testValidateFormFailure() {
        boolean result = validator.validateForm("incorrectForm");
        if (result) {
            System.out.println("Test failed: validateForm() should return false for an invalid form");
        }
    }
}
