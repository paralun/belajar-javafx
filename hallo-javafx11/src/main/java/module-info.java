module com.paralun {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.paralun.controller to javafx.fxml;
    exports com.paralun;
}