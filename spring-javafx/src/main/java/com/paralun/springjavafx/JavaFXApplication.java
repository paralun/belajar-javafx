package com.paralun.springjavafx;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext> initializer = ac -> {
          ac.registerBean(Application.class, () -> JavaFXApplication.this);
          ac.registerBean(Parameters.class, this::getParameters);
          ac.registerBean(HostServices.class, this::getHostServices);
        };

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpringJavafxApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/Scene.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Spring Boot");
        stage.setScene(scene);
        stage.show();
    }
}
