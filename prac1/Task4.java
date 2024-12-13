package prac1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества элементов массива
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Ввод элементов массива
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Сумма элементов массива с помощью do-while
        int sum = 0;
        int index = 0;
        do {
            sum += array[index];
            index++;
        } while (index < n);

        // Поиск минимального и максимального элементов с помощью while
        int min = array[0];
        int max = array[0];
        index = 1; // начинаем с второго элемента, так как первый уже учтен
        while (index < n) {
            if (array[index] < min) {
                min = array[index];
            }
            if (array[index] > max) {
                max = array[index];
            }
            index++;
        }

        // Вывод результатов
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);

        scanner.close();
    }
}
//тернарный оператор