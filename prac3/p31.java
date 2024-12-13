package prac3;

/*1. Создать массив вещественных чисел случайным образом, вывести его
        на экран, отсортировать его, и снова вывести на экран (использовать два подхода
        к генерации случайных чисел – метод random() класса Math и класс Random)*/
import java.util.Arrays;
import java.util.Random;

public class p31 {

    public static void main(String[] args) {
        int size = 10; // Размер массива

        // 1. Генерация массива с помощью Math.random()
        double[] array1 = new double[size];
        System.out.println("Массив, сгенерированный с помощью Math.random():");
        for (int i = 0; i < size; i++) {
            array1[i] = Math.random() * 100; // Генерация случайных чисел в диапазоне от 0 до 100
        }
        System.out.println(Arrays.toString(array1));

        // Сортировка массива
        Arrays.sort(array1);
        System.out.println("Отсортированный массив (Math.random()):");
        System.out.println(Arrays.toString(array1));

        // 2. Генерация массива с помощью класса Random
        double[] array2 = new double[size];
        Random random = new Random();
        System.out.println("\nМассив, сгенерированный с помощью Random:");
        for (int i = 0; i < size; i++) {
            array2[i] = random.nextDouble() * 100; // Генерация случайных чисел в диапазоне от 0 до 100
        }
        System.out.println(Arrays.toString(array2));

        // Сортировка массива
        Arrays.sort(array2);
        System.out.println("Отсортированный массив (Random):");
        System.out.println(Arrays.toString(array2));
    }
}
