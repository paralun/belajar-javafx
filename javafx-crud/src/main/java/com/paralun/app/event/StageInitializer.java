package com.paralun.app.event;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private ApplicationContext context;

    public StageInitializer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage stage = event.getStage();
            FXMLLoader loader = new FXMLLoader(new ClassPathResource("/template/fxml/barang.fxml").getURL());
            loader.setControllerFactory(this.context::getBean);
            Parent root = loader.load();

            stage.setScene(new Scene(root));
            stage.setTitle("JavaFX CRUD");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
