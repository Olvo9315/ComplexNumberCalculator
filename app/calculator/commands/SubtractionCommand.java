package app.calculator.commands;

import app.Command;
import app.ComplexNumber;

public class SubtractionCommand implements Command {
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getReal() - num2.getReal();
        double imaginaryPart = num1.getImaginary() - num2.getImaginary();
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
