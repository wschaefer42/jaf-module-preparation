package com.example.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreetingFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();
        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue");
        Button sayHellOBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");
        sayHellOBtn.setOnAction(e -> {
            String name = nameFld.getText();
            var msgText = name.isBlank() ? "Hello There" : "Hello " + name;
            msg.setText(msgText);
        });
        exitBtn.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.setSpacing(5);
        root.getChildren().addAll(nameLbl, nameFld, msg, sayHellOBtn, exitBtn);
        Scene scene = new Scene(root, 350, 150);
        stage.setScene(scene);
        stage.setTitle("Greeting FX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
