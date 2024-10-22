import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTest {

    private FormTest form;

    // Setup method to initialize form object before each test
    public void setUp() {
        form = new FormTest();
    }

    // Test method for adding a new request form
    public void testAddNewRequestForm() {
        boolean result = form.addNewRequestForm();
        if (!result) {
            System.out.println("Test failed: addNewRequestForm() should return true");
        }
    }

    // Test method for review acceptance
    public void testReviewAccepted() {
        boolean result = form.reviewAccepted();
        if (!result) {
            System.out.println("Test failed: reviewAccepted() should return true");
        }
    }

    // Test method for review declination
    public void testReviewDeclined() {
        boolean result = form.reviewDeclined();
        if (result) {
            System.out.println("Test failed: reviewDeclined() should return false");
        }
    }
}
