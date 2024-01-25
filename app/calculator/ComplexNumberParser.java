package app.calculator;

import app.ComplexNumber;

public class ComplexNumberParser {
    public static ComplexNumber parseComplexNumber(String input) {
        String[] parts = input.split("[+i-]");

        if (parts.length == 1) {
            try {
                double realPart = Double.parseDouble(parts[0]);
                return new ComplexNumber(realPart, 0);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid complex number format");
            }
        } else if (parts.length == 2) {
            try {
                double realPart = Double.parseDouble(parts[0]);
                double imaginaryPart = input.contains("+") ? Double.parseDouble(parts[1]) : -Double.parseDouble(parts[1]);
                return new ComplexNumber(realPart, imaginaryPart);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid complex number format");
            }
        } else {
            throw new IllegalArgumentException("Invalid complex number format");
        }
    }
}
