package com.paralun.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HalloFX extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hallo, JavaFX");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setTitle("Hallo JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
