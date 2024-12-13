package prac1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Введите количество элементов массива: ");
        int count = scanner.nextInt();

        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Используем тернарный оператор для вычисления среднего
        double average = numbers.size() > 0 ? (double) sum / numbers.size() : 0;

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);

        scanner.close();
    }
}


//int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);