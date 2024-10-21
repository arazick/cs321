public class Immigrant {
    // Main method - entry point of the program
    public static void main(String[] args) {
        Immigrant immigrant = new Immigrant();
        
        // Call the methods to test
        System.out.println("Method: " + immigrant.method());
        System.out.println("Tester: " + tester());
    }

    // Non-static method
    public Boolean method() {
        return true;
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