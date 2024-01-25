

import java.util.Scanner;

import app.ComplexNumber;
import app.Logger;
import app.calculator.CalculatorFacade;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);

        while (true) {
            try {
                ComplexNumber num1 = inputHandler.getComplexNumberInput("Enter the first complex number (e.g., 3+4i): ");
                String operation = inputHandler.getOperationInput();
                ComplexNumber num2 = inputHandler.getComplexNumberInput("Enter the second complex number (e.g., 1-2i): ");

                CalculatorFacade calculator = new CalculatorFacade();
                ComplexNumber result = calculator.executeOperation(num1, num2, operation);

                Logger.log("Result: " + result.toString());

                if (!inputHandler.getContinueOption()) {
                    break;
                }
            } catch (ArithmeticException e) {
                Logger.log("Error: " + e.getMessage());
            }
        }
    }
}
