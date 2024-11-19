import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AuditPage extends Application {
	
	private List<String> sampleForms = new ArrayList<>();
	
    private void forms() {
        sampleForms.add("Form ID: 10001\nApplicant Name: Alice alice\nSubmission Date: 2024-11-01\nDetails: Reasons");
        sampleForms.add("Form ID: 10002\nApplicant Name: Bob cob\nSubmission Date: 2024-10-15\nDetails: Reasons.");
        sampleForms.add("Form ID: 10003\nApplicant Name: Carol carol\nSubmission Date: 2024-09-25\nDetails: Reasons.");
        sampleForms.add("Form ID: 10004\nApplicant Name: David david\nSubmission Date: 2024-08-30\nDetails: Reasons.");
        sampleForms.add("Form ID: 10005\nApplicant Name: Eva eva\nSubmission Date: 2024-07-20\nDetails: Reasons.");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Audit Screen");

        forms();
        // Grid layout setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Audit Form Verification title
        Text title = new Text("Audit Form Verification");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        // Random Form Selection
        Button selectFormBtn = new Button("Select Random Approved Form");
        grid.add(selectFormBtn, 0, 1, 2, 1);

        // Form Details Display
        Label formDetailsLabel = new Label("Form Details:");
        grid.add(formDetailsLabel, 0, 2);
        TextArea formDetails = new TextArea();
        formDetails.setPrefRowCount(5);
        formDetails.setEditable(false);
        grid.add(formDetails, 1, 2);

        // Completeness Verification
        Label completionLabel = new Label("Complete:");
        grid.add(completionLabel, 0, 3);
        CheckBox completionCheckBox = new CheckBox("All required fields completed");
        grid.add(completionCheckBox, 1, 3);

        // Accuracy Verification
        Label accuracyLabel = new Label("Accurate:");
        grid.add(accuracyLabel, 0, 4);
        CheckBox accuracyCheckBox = new CheckBox("All data accurate");
        grid.add(accuracyCheckBox, 1, 4);

        // Reporting Issues
        Label issueReportLabel = new Label("Report Issues:");
        grid.add(issueReportLabel, 0, 5);

        TextArea issueReport = new TextArea();
        grid.add(issueReport, 1, 5);

        // Submit Issue and Approve button
        Button submitReportBtn = new Button("Submit Issues");
        Button approveBtn = new Button("Approve");
        HBox actionBtns = new HBox(10);
        actionBtns.setAlignment(Pos.BOTTOM_RIGHT);
        actionBtns.getChildren().addAll(submitReportBtn, approveBtn);
        grid.add(actionBtns, 1, 6);

        // Action on Select Form Button
        selectFormBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	//Example DB.
            	String randomForm = getRandomForm();
                formDetails.setText(randomForm);
            }
        });

        submitReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
            	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Issues submitted successfully!");
                alert.showAndWait();
            }
        });

        approveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
            	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Form approved successfully!");
                alert.showAndWait();
            }
        });

        // Scene and stage setup
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    private String getRandomForm() {
        Random random = new Random();
        return sampleForms.get(random.nextInt(sampleForms.size())); // Random form.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
