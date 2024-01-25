import java.util.Scanner;

import app.ComplexNumber;
import app.Logger;
import app.calculator.ComplexNumberParser;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public ComplexNumber getComplexNumberInput(String prompt) {
        while (true) {
            Logger.log(prompt);
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                Logger.log("You haven't entered anything. Please try again.");
                continue;
            }

            try {
                return ComplexNumberParser.parseComplexNumber(input);
            } catch (IllegalArgumentException e) {
                Logger.log("Invalid input for complex number. Please try again.");
            }
        }
    }

    public String getOperationInput() {
        while (true) {
            Logger.log("Enter the operation (+, -, *, /): ");
            String operation = scanner.nextLine().trim();

            try {
                if (operation.isEmpty() || !"+-*/".contains(operation)) {
                    throw new IllegalArgumentException("Invalid operation. Please enter a valid operation (+, -, *, /).");
                }
                return operation;
            } catch (IllegalArgumentException e) {
                Logger.log(e.getMessage());
            }
        }
    }

    public boolean getContinueOption() {
        Logger.log("Do you want to perform another operation? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }
}
