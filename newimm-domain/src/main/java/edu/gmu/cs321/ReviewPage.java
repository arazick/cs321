package edu.gmu.cs321;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class ReviewPage extends Application {
    private ReviewerDatabase database = new ReviewerDatabase();
    private NotificationSystem notificationSystem = new NotificationSystem();
    private Form currentForm;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Review Screen");

        // Set up the grid layout with padding and alignment
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add the title for the review screen
        Text title = new Text("Review Form Verification");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        // Button to select a form for review
        TextArea formDetails = new TextArea();
        formDetails.setPrefRowCount(5);
        formDetails.setEditable(false); // Make it read-only
        grid.add(new Label("Form Details:"), 0, 1);
        grid.add(formDetails, 1, 1);

        // Checkboxes for completeness and accuracy
        CheckBox completionCheckBox = new CheckBox("All required fields completed");
        CheckBox accuracyCheckBox = new CheckBox("All data accurate");
        grid.add(new Label("Complete:"), 0, 2);
        grid.add(completionCheckBox, 1, 2);
        grid.add(new Label("Accurate:"), 0, 3);
        grid.add(accuracyCheckBox, 1, 3);

        // Issue report area
        TextArea issueReport = new TextArea();
        grid.add(new Label("Report Issues:"), 0, 4);
        grid.add(issueReport, 1, 4);

        // Buttons for actions
        Button nextFormBtn = new Button("Next Form");
        Button submitReportBtn = new Button("Submit Issues");
        Button approveBtn = new Button("Approve");
        HBox actionBtns = new HBox(10);
        actionBtns.setAlignment(Pos.BOTTOM_RIGHT);
        actionBtns.getChildren().addAll(nextFormBtn, submitReportBtn, approveBtn);
        grid.add(actionBtns, 1, 5);

        // Load the first form from the database
        List<Form> formsQueue = database.fetchForms();
        if (!formsQueue.isEmpty()) {
            currentForm = formsQueue.get(0);
            formDetails.setText(getFormDetails(currentForm));
        }

        // Action for "Next Form" button
        nextFormBtn.setOnAction(e -> {
            int currentIndex = formsQueue.indexOf(currentForm);
            if (currentIndex + 1 < formsQueue.size()) {
                currentForm = formsQueue.get(currentIndex + 1);
                formDetails.setText(getFormDetails(currentForm));
                completionCheckBox.setSelected(false);
                accuracyCheckBox.setSelected(false);
                issueReport.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No more forms to review.");
                alert.show();
            }
        });

        // Action for "Submit Issues" button
        submitReportBtn.setOnAction(e -> {
            if (currentForm != null) {
                boolean isComplete = completionCheckBox.isSelected();
                boolean isAccurate = accuracyCheckBox.isSelected();
                String issues = issueReport.getText();

                if (!isComplete || !isAccurate) {
                    issues += "\n- Form flagged as incomplete or inaccurate.";
                }

                database.saveReviewStatus(currentForm.getId(), isComplete, isAccurate, issues);
                notificationSystem.notifyUser(currentForm.getApplicantName(), "Issues found in your application.");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Issues reported successfully.");
                alert.show();
            }
        });

        // Action for "Approve" button
        approveBtn.setOnAction(e -> {
            if (currentForm != null) {
                if (!completionCheckBox.isSelected() || !accuracyCheckBox.isSelected()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Cannot approve: Incomplete or inaccurate data.");
                    alert.show();
                    return;
                }
                database.saveReviewStatus(currentForm.getId(), true, true, "");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Form approved successfully.");
                alert.show();
            }
        });

        // Set up the scene and display it
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getFormDetails(Form form) {
        return "Form ID: " + form.getId() + "\nApplicant: " + form.getApplicantName() + "\nDetails: " + form.getDetails() +
                "\nStatus: " + form.getStatus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}