package org.paralun.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.paralun.app.model.StringCalcProcessor;

import java.math.BigDecimal;

public class CalculatorController {

    @FXML
    private Text textSmall;
    @FXML
    private Text textOutput;

    private boolean isFirst = true;
    private boolean isFirstOpr = true;
    private StringCalcProcessor calcProcessor;
    private String hasil;
    private String opr;
    private String strOut = "0";

    @FXML
    public void initialize() {
        textSmall.setText("");
        calcProcessor = new StringCalcProcessor();
    }

    @FXML
    public void actionNumber(ActionEvent event) {
        var value = ((Button)event.getSource()).getText();
        if(isFirst) {
            strOut = value;
            isFirst = false;
        }else {
            strOut = textOutput.getText() + value;
        }
        textOutput.setText(strOut);
    }

    @FXML
    public void actionOperator(ActionEvent event) {
        var value = ((Button)event.getSource()).getText();
        if(value.equals("=")) {
            textSmall.setText(textSmall.getText() + textOutput.getText() + value);
            hasil = calcProcessor.hitung(hasil, strOut, opr);
            textOutput.setText(hasil);
            strOut = hasil;
            opr = "";
            isFirst = true;
            isFirstOpr = true;
            hasil = "";
        } else {
            if(isFirstOpr) {
                isFirstOpr = false;
                hasil = strOut;
                textSmall.setText(strOut + value);
            }else {
                textSmall.setText(textSmall.getText() + strOut + value);
                hasil = calcProcessor.hitung(hasil, strOut, opr);
                textOutput.setText(hasil);
            }

            isFirst = true;
            strOut = "0";
            opr = value;
        }
    }

    @FXML
    public void actionClear(ActionEvent event) {
        textOutput.setText("0");
        textSmall.setText("");
        strOut = "0";
        opr = "";
        isFirst = true;
        isFirstOpr = true;
        hasil = "";
    }

    @FXML
    public void actionNegatifPositif(ActionEvent event) {
        var hString = textOutput.getText();
        Long hLong = Long.parseLong(hString);
        if(hLong < 0) {
            hLong = Math.abs(hLong);
        }else {
            hLong = 0 - hLong;
        }
        textOutput.setText(String.valueOf(hLong));
    }
}
