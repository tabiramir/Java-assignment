import java.util.Scanner;

public class CommandLineCalc {
    public static double evaluate(String expression) {
        expression = expression.replaceAll("\\s+", "");
        return calculate(expression);
    }
    private static double calculate(String expression) {
        char[] tokens = expression.toCharArray();
        double result = 0;
        double currentValue = 0;
        double tempResult = 0;
        char lastOperator = '+';
        char lastHighPrecedenceOperator = '+'; 
        for (int i = 0; i < tokens.length; i++) {
            char currentChar = tokens[i];
            if (Character.isDigit(currentChar)) {
                currentValue = currentValue * 10 + (currentChar - '0');
            }
            if (currentChar == '(') {
                int j = i, bracketCount = 0;
                while (i < tokens.length) {
                    if (tokens[i] == '(') bracketCount++;
                    if (tokens[i] == ')') bracketCount--;
                    if (bracketCount == 0) break;
                    i++;
                }
                currentValue = calculate(expression.substring(j + 1, i));
            }
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == tokens.length - 1) {
                if (lastOperator == '*' || lastOperator == '/') {
                    tempResult = lastOperator == '*' ? tempResult * currentValue : tempResult / currentValue;
                } else {
                    tempResult = currentValue;
                }
                if (currentChar == '+' || currentChar == '-' || i == tokens.length - 1) {
                    result = lastHighPrecedenceOperator == '+' ? result + tempResult : result - tempResult;
                    tempResult = 0;
                    lastHighPrecedenceOperator = currentChar;
                }
                lastOperator = currentChar;
                currentValue = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter a mathematical expression (" + i + "/3): ");
            String expression = scanner.nextLine();
            try {
                double result = evaluate(expression);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression. Please try again.");
            }
        }
        scanner.close();
    }
}
