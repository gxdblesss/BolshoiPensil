package prac21;

//. Написать метод для конвертации массива строк/чисел в
//        список.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p211 {

    // Универсальный метод для конвертации массива в список
    public static <T> List<T> convertArrayToList(T[] array) {
        // Используем Arrays.asList() для конвертации
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        // Пример с массивом строк
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        List<String> stringList = convertArrayToList(stringArray);
        System.out.println("Список строк: " + stringList);

        // Пример с массивом чисел
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = convertArrayToList(intArray);
        System.out.println("Список чисел: " + intList);
    }
}