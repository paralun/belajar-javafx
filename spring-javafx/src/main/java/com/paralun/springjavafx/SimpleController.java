package com.paralun.springjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

@Component
public class SimpleController {

    @FXML
    private Text textId;

    @FXML
    public void actionButton(ActionEvent event) {
        textId.setText("Hallllooooo....");
    }
}
