package prac3;

/*Пользователь должен ввести с клавиатуры размер массива -
        натуральное число больше, так чтобы введенное пользователем число
        сохранялось в переменную n. Если пользователь ввел не подходящее число, то
        программа должна просить пользователя повторить ввод. Создать массив из n
        случайных целых чисел из отрезка [0; n] и вывести его на экран. Создать второй
        массив только из четных элементов первого массива, если они там есть, и
        вывести его на экран*/


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class p33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Запрашиваем у пользователя размер массива
        while (true) {
            System.out.print("Введите размер массива (натуральное число больше 0): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break; // Если введено корректное число, выходим из цикла
                } else {
                    System.out.println("Пожалуйста, введите натуральное число больше 0.");
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите натуральное число.");
                scanner.next(); // Очищаем некорректный ввод
            }
        }

        // Создаем массив из n случайных целых чисел из [0; n]
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(n + 1); // Генерация случайного числа от 0 до n
        }

        // Выводим сгенерированный массив
        System.out.print("Сгенерированный массив: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Создаем второй массив для четных элементов
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number); // Добавляем четное число в список
            }
        }

        // Преобразуем ArrayList в массив
        int[] evenArray = new int[evenNumbers.size()];
        for (int i = 0; i < evenNumbers.size(); i++) {
            evenArray[i] = evenNumbers.get(i);
        }

        // Выводим массив четных элементов
        if (evenArray.length > 0) {
            System.out.print("Массив четных элементов: ");
            for (int evenNumber : evenArray) {
                System.out.print(evenNumber + " ");
            }
        } else {
            System.out.println("В массиве нет четных элементов.");
        }
    }
}