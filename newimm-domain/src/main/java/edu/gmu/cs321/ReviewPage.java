package edu.gmu.cs321;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class ReviewPage extends Application {

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
        Button selectFormBtn = new Button("Select Form to Review");
        grid.add(selectFormBtn, 0, 1, 2, 1);

        // Text area to display form details
        Label formDetailsLabel = new Label("Form Details:");
        grid.add(formDetailsLabel, 0, 2);
        TextArea formDetails = new TextArea();
        formDetails.setPrefRowCount(5);
        formDetails.setEditable(false); // Make it read-only
        grid.add(formDetails, 1, 2);

        // Checkbox to verify all required fields are complete
        Label completionLabel = new Label("Complete:");
        grid.add(completionLabel, 0, 3);
        CheckBox completionCheckBox = new CheckBox("All required fields completed");
        grid.add(completionCheckBox, 1, 3);

        // Checkbox to verify data accuracy
        Label accuracyLabel = new Label("Accurate:");
        grid.add(accuracyLabel, 0, 4);
        CheckBox accuracyCheckBox = new CheckBox("All data accurate");
        grid.add(accuracyCheckBox, 1, 4);

        // Text area to report any issues found during the review
        Label issueReportLabel = new Label("Report Issues:");
        grid.add(issueReportLabel, 0, 5);
        TextArea issueReport = new TextArea();
        grid.add(issueReport, 1, 5);

        // Buttons for submitting issues and approving the form
        Button submitReportBtn = new Button("Submit Issues");
        Button approveBtn = new Button("Approve");
        HBox actionBtns = new HBox(10);
        actionBtns.setAlignment(Pos.BOTTOM_RIGHT);
        actionBtns.getChildren().addAll(submitReportBtn, approveBtn);
        grid.add(actionBtns, 1, 6);

        // Action for the "Select Form" button to load form details
        selectFormBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                formDetails.setText(
                        "Form ID: 56789\nApplicant Name: Nyle Nasir\nSubmission Date: 2024-11-04\nDetails: Request for Review...");
            }
        });

        // Action for "Submit Issues" button to print reported issues
        submitReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Issues Submitted for Review: " + issueReport.getText());
            }
        });

        // Action for "Approve" button to confirm approval
        approveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Application Approved");
            }
        });

        // Set up and display the scene
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}