module org.paralun.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.paralun.app.controller to javafx.fxml;
    exports org.paralun.app;
}