module com.paralun.springjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    opens com.paralun.springjavafx;
    exports com.paralun.springjavafx;
}