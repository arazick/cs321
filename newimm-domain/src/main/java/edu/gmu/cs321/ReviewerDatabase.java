package edu.gmu.cs321;

import java.util.ArrayList;
import java.util.List;

public class ReviewerDatabase {
    private List<Form> forms = new ArrayList<>();

    public ReviewerDatabase() {
        // Mock data for testing
        forms.add(new Form("1", "John Doe", "Details about the form", "Pending"));
        forms.add(new Form("2", "Jane Smith", "Another form's details", "Pending"));
    }

    public List<Form> fetchForms() {
        return forms;
    }

    public void saveReviewStatus(String formId, boolean isComplete, boolean isAccurate, String issues) {
        for (Form form : forms) {
            if (form.getId().equals(formId)) {
                form.setStatus(isComplete && isAccurate ? "Approved" : "Needs Correction");
                form.setIssues(issues);
                break;
            }
        }
    }
}
