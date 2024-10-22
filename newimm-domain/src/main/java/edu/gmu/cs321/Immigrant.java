package edu.gmu.cs321;

public class Immigrant extends Person {
    //private fields
    private int Anum;

    public Immigrant(String first, String last, String dob, int Anum){
        super(first, last, dob);
        this.Anum = Anum;
    }

    // Non-static method
    public int getAnum() {
        return this.Anum;
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