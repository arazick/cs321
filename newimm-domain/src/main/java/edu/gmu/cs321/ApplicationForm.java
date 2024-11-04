package edu.gmu.cs321;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class ApplicationForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 50, 50, 50));
        Scene scene = new Scene(grid, 400, 700);
        Label welcome = new Label("Welcome to the Immigrant Database.");
        welcome.setFont(Font.font("", FontWeight.BOLD, 15));
        grid.add(welcome, 0, 0);

        Label requestorFirstName = new Label("First Name of Requestor:");
        TextField firstNameField = new TextField();
        grid.add(requestorFirstName, 0, 1);
        grid.add(firstNameField, 0, 2);

        Label requestorLastName = new Label("Last Name of Requestor:");
        TextField lastNameField = new TextField();
        grid.add(requestorLastName, 0, 3);
        grid.add(lastNameField, 0, 4);

        Label requestorDOB = new Label("DOB of Requestor");
        DatePicker requestDatePicker = new DatePicker();
        grid.add(requestorDOB, 0, 5);
        grid.add(requestDatePicker, 0, 6);

        Label requestorSSN = new Label("SSN of Requestor (AAA-GG-SSSS)");
        TextField requestSSN = new TextField();
        grid.add(requestorSSN, 0, 7);
        grid.add(requestSSN, 0, 8);

        Label immFirstName = new Label("First Name of Deceased Immigrant:");
        TextField immFirstNameField = new TextField();
        grid.add(immFirstName, 0, 9);
        grid.add(immFirstNameField, 0, 10);

        Label immLastName = new Label("Last Name of Deceased Immigrant:");
        TextField immLastNameField = new TextField();
        grid.add(immLastName, 0, 11);
        grid.add(immLastNameField, 0, 12);

        Label immDOB = new Label("DOB of Deceased Immigrant");
        DatePicker immDatePicker = new DatePicker();
        grid.add(immDOB, 0, 13);
        grid.add(immDatePicker, 0, 14);

        Label immAnum = new Label("A-Number of Deceased Immigrant:");
        TextField anum = new TextField();
        grid.add(immAnum, 0, 15);
        grid.add(anum, 0, 16);

        Button submit = new Button("Submit Form");
        grid.add(submit, 0, 19);
        primaryStage.setScene(scene);
        primaryStage.show();
        submit.setOnMouseClicked(event -> {
            grid.getChildren().clear();
            Label submission = new Label("Thank you for your submission!");
            welcome.setFont(Font.font("", FontWeight.BOLD, 30));
            grid.setAlignment(Pos.CENTER);
            grid.add(submission, 0, 0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
