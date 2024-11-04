package edu.gmu.cs321;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ImmigrantTest {

    @Test
    public void checkANum(){
        Immigrant test = new Immigrant("John", "Doe", "10/21/2024", 1);
        assertTrue(test.getAnum() == 1);
    }

    @Test
    public void checkExists(){
        //need database object to check. not sure how to do that yet
    }

    @Test
    public void checkGetName(){
        Immigrant test = new Immigrant("John", "Doe", "10/21/2024", 1);
        assertTrue(test.getLastName().equals("Doe"));
        assertTrue(test.getFirstName().equals("Doe"));
    }

    @Test
    public void checkGetDOB(){
        Immigrant test = new Immigrant("John", "Doe", "10/21/2024", 1);
        assertTrue(test.getDOB().equals("10/21/2024"));
    }
}




