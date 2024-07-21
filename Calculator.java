import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String input;
        String output;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        output = clac(input);
        System.out.println(output);
    }

    private static String clac(String input) {
        String[] parts;
        int a;
        int b;
        int result;
        String operator;

        parts = input.split("");

       if (parts.length == 1) {
           throw new IllegalArgumentException("Строка не является математической операцией");
       }

       if (parts.length != 3) {
           throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - " + "Два операнда и один оператор (+,-,/,*)") ;
       }

       try {
           a = Integer.parseInt(parts[0]);
           b = Integer.parseInt(parts[2]);
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("В выражении можно использовать " + "только целые числа от 1 до 10 включительно") ;
       }

       if (a < 1 || a > 10 || b < 1 || b > 10)
           throw new IllegalArgumentException("В выражении можно использовать " + "только целые числа от 1 до 10 включительно");
       operator = parts[1];

       switch (operator) {
           case "+":
               result = a + b;
               break;
           case "-":
               result = a - b;
               break;
           case "*":
               result = a * b;
               break;
           case "/":
               result = a / b;
               break;
           default:
               throw new IllegalArgumentException("Допустимые арифметические операции: +,-,*,/");
       }
       return String.valueOf(result);
    }
}
