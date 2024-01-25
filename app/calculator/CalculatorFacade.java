package app.calculator;

import app.Command;
import app.ComplexNumber;
import app.calculator.commands.AdditionCommand;
import app.calculator.commands.DivisionCommand;
import app.calculator.commands.MultiplicationCommand;
import app.calculator.commands.SubtractionCommand;

public class CalculatorFacade {
    private Command addition;
    private Command subtraction;
    private Command multiplication;
    private Command division;

    public CalculatorFacade() {
        this.addition = new AdditionCommand();
        this.subtraction = new SubtractionCommand();
        this.multiplication = new MultiplicationCommand();
        this.division = new DivisionCommand();
    }

    public ComplexNumber executeOperation(ComplexNumber num1, ComplexNumber num2, String operation) {
        switch (operation) {
            case "+":
                return addition.execute(num1, num2);
            case "-":
                return subtraction.execute(num1, num2);
            case "*":
                return multiplication.execute(num1, num2);
            case "/":
                if (num2.getReal() == 0 && num2.getImaginary() == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return division.execute(num1, num2);
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
