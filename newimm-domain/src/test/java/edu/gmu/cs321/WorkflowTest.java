package edu.gmu.cs321;
public class WorkflowTest {

    private WorkflowTest workflow;

    public void setUp() {
        workflow = new WorkflowTest();
    }

    // Test adding a workflow item
    public void testAddNewWFItem() {
        boolean result = workflow.addNewWFItem("request123", "nextStep");
        if (!result) {
            System.out.println("Test failed: addNewWFItem() should return true");
        }
    }

    // Test getting the next item in the workflow
    public void testGetNextItem() {
        String nextItem = workflow.getNextItem("nextStep");
        if (nextItem == null) {
            System.out.println("Test failed: getNextItem() should return a valid item");
        }
    }
}
