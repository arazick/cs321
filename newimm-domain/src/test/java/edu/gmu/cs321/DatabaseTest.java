package edu.gmu.cs321;
public class DatabaseTest {

    private DatabaseTest db;

    // Setup method to initialize database object before each test
    public void setUp() {
        db = new DatabaseTest();
    }

    // Test method for searching an immigrant by valid A-number
    public void testSearchImmigrant() {
        String validAnumber = "A12345";
        Object immigrant = db.searchImmigrant(validAnumber);
        if (immigrant == null) {
            System.out.println("Test failed: searchImmigrant() should return immigrant data for valid A-number");
        }
    }

    // Test method for adding a new request to the database
    public void testAddNewRequest() {
        boolean result = db.addNewRequest();
        if (!result) {
            System.out.println("Test failed: addNewRequest() should return true");
        }
    }
}
