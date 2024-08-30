import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter equation");
            String userInput = scanner.nextLine();
            String[] input = userInput.trim().split("\\s+");
            if (Integer.parseInt(input[0]) == 0) {
                break;
            }
            double result = 0;
            if (input.length == 3) {
                double firstNum = Double.parseDouble(input[0]);
                double secondNum = Double.parseDouble(input[2]);
                
                String operation = input[1];
                switch (operation) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        result = firstNum / secondNum;
                        break;
                
                    default:
                        System.out.println("Invalid operation");
                        break;
                }
            }
            else {
                System.out.println("Invalid input");
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}