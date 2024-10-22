package edu.gmu.cs321;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class USCitizenTest {

    @Test
    public void checkSSN(){
        USCitizen test = new USCitizen("John", "Doe", "10/21/2024", 111111111);
        assertTrue(test.getSSN() == 111111111);
        assertTrue(String.valueOf(test.getSSN()).length() == 9, "length of ssn check");
    }

    @Test
    public void checkGetName(){
        USCitizen test = new USCitizen("John", "Doe", "10/21/2024", 111111111);
        assertTrue(test.getLastName().equals("Doe"));
        assertTrue(test.getFirstName().equals("Doe"));
    }

    @Test
    public void checkGetDOB(){
        USCitizen test = new USCitizen("John", "Doe", "10/21/2024", 111111111);
        assertTrue(test.getDOB().equals("10/21/2024"));
    }
}
