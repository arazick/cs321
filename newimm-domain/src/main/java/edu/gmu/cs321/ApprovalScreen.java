package edu.gmu.cs321;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class ApprovalScreen extends Application {

    private ArrayList<Form> approvalqueue;
    private Form currForm;
    private ArrayList<Form> finishedqueue;

    @Override
    public void start(Stage stage) {
        
        approvalqueue = new ArrayList<>();
        finishedqueue = new ArrayList<>();
        approvalqueue.add(new Form("1", "John Doe", "Jane Doe", "Approve"));
        approvalqueue.add(new Form("2", "Brad Pit", "Angel Jol", "Approve"));


        //initial scene
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setMinSize(640, 480);

        var title = new Label("Approval System");
        grid.getChildren().add(title);

        //Defining the getNext button
        Button getNext = new Button("Get Next Form");
        getNext.setAlignment(Pos.CENTER);
        GridPane.setConstraints(getNext, 34, 75);
        grid.getChildren().add(getNext);

        var scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();

        //define scene2 for after getNext buttton is pressed
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(5);
        grid2.setHgap(5);
        grid2.setMinSize(640, 480);
        grid2.getChildren().add(title);

        //Defining the approve button
        Button approve = new Button("Approve Form");
        approve.setAlignment(Pos.CENTER);
        GridPane.setConstraints(approve, 43, 75);
        grid2.getChildren().add(approve);
        

        //Defining the reject button
        Button reject = new Button("Reject Form");
        reject.setAlignment(Pos.CENTER);
        GridPane.setConstraints(reject, 47, 75);
        grid2.getChildren().add(reject);

        Label applicant = new Label("Applicant: ");
        GridPane.setConstraints(applicant, 45, 30);
        grid2.getChildren().add(applicant);

        Label immigrant = new Label("Immigrant: ");
        GridPane.setConstraints(immigrant, 45, 35);
        grid2.getChildren().add(immigrant);

        var scene2 = new Scene(grid2);

        //define Scene 3 after approve button press
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(5);
        grid3.setHgap(5);
        grid3.setMinSize(640, 480);
        grid3.getChildren().add(title);

        var AppSucc = new Label("Approval Success!");
        GridPane.setConstraints(AppSucc, 45, 50);
        grid3.getChildren().add(AppSucc);

        Button getNextApp = new Button("Get Next Form");
        getNextApp.setAlignment(Pos.CENTER);
        GridPane.setConstraints(getNextApp, 34, 75);
        grid3.getChildren().add(getNextApp);


        //define Scene 4 after reject button press
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10, 10, 10, 10));
        grid4.setVgap(5);
        grid4.setHgap(5);
        grid4.setMinSize(640, 480);
        grid4.getChildren().add(title);

        var AppRej = new Label("Approval Rejected");
        GridPane.setConstraints(AppRej, 45, 50);
        grid4.getChildren().add(AppRej);

        Button getNextRej = new Button("Get Next Form");
        getNextRej.setAlignment(Pos.CENTER);
        GridPane.setConstraints(getNextRej, 34, 75);
        grid4.getChildren().add(getNextRej);
        
        
        getNext.setOnAction((ActionEvent e) ->{
            //get next form from workflow
            //make method to display form on new screen
            
            if(!approvalqueue.isEmpty()){
                currForm = approvalqueue.remove(0);
            
            applicant.setText("Applicant: "+ currForm.getApplicantName());

            immigrant.setText("Immigrant: " + currForm.getDetails());

            }

            
            stage.setScene(scene2);
            stage.show();
        });

        approve.setOnAction((ActionEvent e) ->{
            //generate email
            //put Form back into workflow with updated nextStep
            //show new scene with successfully approved and getNext button
            currForm.setStatus("Approved");
            finishedqueue.add(currForm);
            var scene3 = new Scene(grid3);
            stage.setScene(scene3);
            stage.show();
        });

        reject.setOnAction((ActionEvent e) ->{
            //put Form back into workflow with updated nextStep
            //show new scene with successfully rejected and getNext button
            currForm.setStatus("Rejected");
            finishedqueue.add(currForm);
            var scene4 = new Scene(grid4);
            stage.setScene(scene4);
            stage.show();
        });

        getNextApp.setOnAction((ActionEvent e) ->{
            //get next form from workflow
            //make method to display form on new screen
            if(!approvalqueue.isEmpty()){
                currForm = approvalqueue.remove(0);

                applicant.setText("Applicant: "+ currForm.getApplicantName());

                immigrant.setText("Immigrant: " + currForm.getDetails());
            }

            stage.setScene(scene2);
            stage.show();
        });

        getNextRej.setOnAction((ActionEvent e) ->{
            //get next form from workflow
            //make method to display form on new screen
            if(!approvalqueue.isEmpty()){
                currForm = approvalqueue.remove(0);

                applicant.setText("Applicant: "+ currForm.getApplicantName());

                immigrant.setText("Immigrant: " + currForm.getDetails());
            }
            stage.setScene(scene2);
            stage.show();
        });
    }

    public static void main(String[] args) {
        launch();
    }

}