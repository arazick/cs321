package edu.gmu.cs321;
public class RequestHandlerTest {

    private RequestHandlerTest handler;

    public void setUp() {
        handler = new RequestHandlerTest();
    }

    // Test for processing a valid request
    public void testProcessRequestValid() {
        boolean result = handler.processRequest("validRequest");
        if (!result) {
            System.out.println("Test failed: processRequest() should return true for valid request");
        }
    }

    // Test for processing an invalid request
    public void testProcessRequestInvalid() {
        boolean result = handler.processRequest("invalidRequest");
        if (result) {
            System.out.println("Test failed: processRequest() should return false for invalid request");
        }
    }
}
