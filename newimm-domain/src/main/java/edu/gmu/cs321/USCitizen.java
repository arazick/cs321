package edu.gmu.cs321;

public class USCitizen extends Person{
    //private fields
    private int SSN;

    public USCitizen(String first, String last, String dob, int ssn){
        super(first, last, dob);
        this.SSN = ssn;
    }

    // Non-static method
    public int getSSN() {
        return this.SSN;
    }

    // Static method
    public static Boolean tester() {
        return false;
    }

    // Other class methods
    public Boolean isAvailable() {
        return true;
    }

    public Boolean addForm() {
        return true;
    }

    public Boolean updateForm() {
        return true;
    }
}
