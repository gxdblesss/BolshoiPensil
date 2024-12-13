package prac3;

/*Создайте массив из 4 случайных целых чисел из отрезка [10;99],
        выведите его на экран в строку, далее определите и выведите на экран сообщение
        о том, является ли массив строго возрастающей последовательностью.*/

import java.util.Random;

public class p32 {
    public static void main(String[] args) {
        // Создаем массив из 4 случайных целых чисел
        int[] numbers = new int[4];
        Random random = new Random();

        // Заполняем массив случайными числами в диапазоне [10; 99]
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(90) + 10; // Генерация числа от 10 до 99
        }

        // Выводим массив на экран
        System.out.print("Сгенерированный массив: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Проверяем, является ли массив строго возрастающей последовательностью
        boolean isStrictlyIncreasing = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] <= numbers[i - 1]) {
                isStrictlyIncreasing = false;
                break;
            }
        }

        // Выводим результат
        if (isStrictlyIncreasing) {
            System.out.println("Массив является строго возрастающей последовательностью.");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью.");
        }
    }
}