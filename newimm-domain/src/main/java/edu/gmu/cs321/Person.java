package edu.gmu.cs321;

public class Person {
    private String firstName;
    private String lastName;
    private String DOB;

    public Person(String first, String last, String dob){
        firstName = first;
        lastName = last;
        DOB = dob;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getDOB(){
        return DOB;
    }
}
