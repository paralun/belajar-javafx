package org.paralun.app.model;

import java.math.BigDecimal;

public class StringCalcProcessor {

    public String hitung(String num1, String num2, String operator) {
        BigDecimal result;
        BigDecimal number1 = new BigDecimal(num1);
        BigDecimal number2 = new BigDecimal(num2);
        switch (operator) {
            case "+" :
                result = number1.add(number2);
                break;
            case "-" :
                result = number1.subtract(number2);
                break;
            case "÷" :
                result = number1.divide(number2);
                break;
            case "x" :
                result = number1.multiply(number2);
                break;
            default:
                return "Error";
        }
        return result.toString();
    }
}
