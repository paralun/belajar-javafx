package com.paralun.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button();
        button.setText("Button FX");
        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 350, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
