package prac1;
import java.util.Scanner;

public class Task7 {

        public static long factorial(int n) {
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число для вычисления факториала: ");
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Ошибка: Факториал отрицательного числа не определен.");
            } else {
                long fact = factorial(number);
                System.out.println("Факториал " + number + " равен " + fact);
            }

            scanner.close();
        }
    }

