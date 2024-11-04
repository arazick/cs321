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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLogUI extends Application {

    private List<String> logs = new ArrayList<>();
    private TextArea logArea;
    private ListView<String> logListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Audit Log");

        // Main layout setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Title
        Text title = new Text("Audit Log Viewer");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        // Text area for displaying log entries
        logArea = new TextArea();
        logArea.setPrefRowCount(10);
        logArea.setEditable(false);
        grid.add(logArea, 0, 1, 2, 1);

        // List view to display and select specific logs
        logListView = new ListView<>();
        logListView.setPrefHeight(100);
        grid.add(logListView, 0, 2, 2, 1);

        // Text field for adding a custom log entry
        TextField customLogField = new TextField();
        customLogField.setPromptText("Enter a custom log message...");
        grid.add(customLogField, 0, 3);

        // Buttons for different actions
        Button addReviewLogBtn = new Button("Add Review Log");
        Button addApprovalLogBtn = new Button("Add Approval Log");
        Button addCustomLogBtn = new Button("Add Custom Log");
        Button clearLogsBtn = new Button("Clear Logs");

        // Button layout
        HBox actionBtns = new HBox(10);
        actionBtns.setAlignment(Pos.BOTTOM_RIGHT);
        actionBtns.getChildren().addAll(addReviewLogBtn, addApprovalLogBtn, addCustomLogBtn, clearLogsBtn);
        grid.add(actionBtns, 1, 4);

        // Button functionality
        addReviewLogBtn.setOnAction(e -> addLog("Reviewed Application ID: 101"));
        addApprovalLogBtn.setOnAction(e -> addLog("Approved Application ID: 102"));
        addCustomLogBtn.setOnAction(e -> {
            if (!customLogField.getText().isEmpty()) {
                addLog(customLogField.getText());
                customLogField.clear();
            }
        });
        clearLogsBtn.setOnAction(e -> clearLogs());

        // Action to update log display when a log is selected
        logListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                logArea.setText(newValue);
            }
        });

        // Scene and stage setup
        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to add a log entry with a timestamp
    private void addLog(String action) {
        String logEntry = LocalDateTime.now() + " - " + action;
        logs.add(logEntry);
        updateLogDisplay();
    }

    // Clears all log entries
    private void clearLogs() {
        logs.clear();
        updateLogDisplay();
    }

    // Updates the log display in both text area and list view
    private void updateLogDisplay() {
        logArea.clear();
        logListView.getItems().clear();

        for (String log : logs) {
            logArea.appendText(log + "\n");
            logListView.getItems().add(log);
        }
    }
}
