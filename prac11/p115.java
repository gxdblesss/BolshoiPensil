package prac11;

/*Задание 5 (30%)
        Сравнить время выполнения кода в реализации кода в виде различных
        структур данных из предыдущих заданий (сравнить ArrayList и LinkedList по
        производительности – операции вставки, удаления, добавления и поиска по
        образцу)*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

 class Assignment5 {
    public static void main(String[] args) {
        final int SIZE = 100000; // Количество элементов
        Random random = new Random();

        // Сравнение производительности ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        // Вставка элементов
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt(1000000));
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList: Время вставки " + SIZE + " элементов: " + (endTime - startTime) + " наносекунд");

        // Поиск элемента
        startTime = System.nanoTime();
        arrayList.contains(SIZE / 2); // Поиск элемента (половина от размера)
        endTime = System.nanoTime();
        System.out.println("ArrayList: Время поиска элемента: " + (endTime - startTime) + " наносекунд");

        // Удаление элементов
        startTime = System.nanoTime();
        arrayList.remove(0); // Удаление первого элемента
        endTime = System.nanoTime();
        System.out.println("ArrayList: Время удаления первого элемента: " + (endTime - startTime) + " наносекунд");

        // Сравнение производительности LinkedList
        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        // Вставка элементов
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(random.nextInt(1000000));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList: Время вставки " + SIZE + " элементов: " + (endTime - startTime) + " наносекунд");

        // Поиск элемента
        startTime = System.nanoTime();
        linkedList.contains(SIZE / 2); // Поиск элемента (половина от размера)
        endTime = System.nanoTime();
        System.out.println("LinkedList: Время поиска элемента: " + (endTime - startTime) + " наносекунд");

        // Удаление элементов
        startTime = System.nanoTime();
        linkedList.remove(0); // Удаление первого элемента
        endTime = System.nanoTime();
        System.out.println("LinkedList: Время удаления первого элемента: " + (endTime - startTime) + " наносекунд");
    }
}


