package com.sergey.prykhodko.homework6.showSystemParams;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Sergey on 18.07.2017.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button versionButton = new Button();
        versionButton.setText("Show OS version");

        Label showLabel = new Label();

        showLabel.setMinSize(200, 40);
        showLabel.setAlignment(Pos.CENTER);

        versionButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showLabel.setText(InfoGetter.getOSVersion());
            }
        });

        Button userNameButton = new Button();
        userNameButton.setText("Show OS user name");
        userNameButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showLabel.setText(InfoGetter.getUserAccountName());
            }
        });

        Button osArchButton = new Button();
        osArchButton.setText("Show OS arhitecture");
        osArchButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showLabel.setText(InfoGetter.getOsArchitecture());
            }
        });


        FlowPane root = new FlowPane();

        root.getChildren().add(showLabel);
        root.getChildren().add(osArchButton);
        root.getChildren().add(versionButton);
        root.getChildren().add(userNameButton);



        Scene scene = new Scene(root, 300, 250);


        primaryStage.setTitle("System Information");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
