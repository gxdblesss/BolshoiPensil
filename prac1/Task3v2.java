package prac1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3v2 {
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

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        double average = (double) sum / numbers.size();

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);

        scanner.close();
    }
}
