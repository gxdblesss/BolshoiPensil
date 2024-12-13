package prac8;

/*16 Задание Количество элементов, равных максимуму
        Дана последовательность натуральных чисел (одно число в строке),
        завершающаяся числом ноль. Определите, какое количество элементов этой
        последовательности, равны ее наибольшему элементу.
        В этой задаче нельзя использовать глобальные переменные. Функция
        получает данные, считывая их с клавиатуры, а не получая их в виде параметра.
        В программе на языке Python функция возвращает результат в виде кортежа из
        72
        нескольких чисел, и функция вообще не получает никаких параметров. В
        программе на языке C++ результат записывается в переменные, которые
        передаются в функцию по ссылке. Других параметров, кроме как используемых
        для возврата значения, функция не получает. Гарантируется, что
        последовательность содержит хотя бы одно число(кроме нуля)*/

import java.util.Scanner;

public class p82 {

    // Рекурсивная функция для поиска максимума и подсчета количества максимальных элементов
    public static int[] findMaxAndCount() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();  // Считываем текущее число

        // Базовый случай: если введён 0, возвращаем массив [максимум = 0, количество = 0]
        if (num == 0) {
            return new int[]{0, 0};  // [максимум, количество]
        }

        // Рекурсивно вызываем для следующего числа
        int[] result = findMaxAndCount();
        int currentMax = result[0];  // Текущий максимум
        int countMax = result[1];    // Количество элементов, равных текущему максимуму

        // Если текущее число больше текущего максимума
        if (num > currentMax) {
            return new int[]{num, 1};  // Обновляем максимум и сбрасываем количество
        } else if (num == currentMax) {
            return new int[]{currentMax, countMax + 1};  // Если равно максимуму, увеличиваем счётчик
        } else {
            return result;  // Максимум остаётся прежним
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность чисел, заканчивающуюся нулём:");
        int[] result = findMaxAndCount();
        System.out.println("Максимальный элемент: " + result[0]);
        System.out.println("Количество элементов, равных максимальному: " + result[1]);
    }
}