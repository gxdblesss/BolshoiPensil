package prac21;
//
//4. Написать функцию, которая сохранит содержимое каталога в
//        список и выведет первые 5 элементов на экран.

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p214 {

    // Метод для получения содержимого каталога и вывода первых 5 элементов
    public static List<String> listDirectoryContents(String directoryPath) {
        File directory = new File(directoryPath);

        // Проверяем, что путь существует и является каталогом
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Указанный путь не существует или не является каталогом: " + directoryPath);
        }

        // Получаем содержимое каталога
        String[] contents = directory.list();
        if (contents == null || contents.length == 0) {
            System.out.println("Каталог пуст!");
            return new ArrayList<>();
        }

        // Преобразуем массив в список
        List<String> contentList = new ArrayList<>(Arrays.asList(contents));

        // Вывод первых 5 элементов
        System.out.println("Первые 5 элементов содержимого каталога:");
        contentList.stream().limit(5).forEach(System.out::println);

        return contentList;
    }

    public static void main(String[] args) {
        // Укажите путь к вашему каталогу
        String directoryPath = "."; // "." означает текущую директорию

        // Вызов метода
        try {
            List<String> contents = listDirectoryContents(directoryPath);
            System.out.println("Всего элементов: " + contents.size());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}