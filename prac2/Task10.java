package prac2;
//Напишите программу HowMany.java, которая определит, сколько
//слов Вы ввели с консоли

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();


        int wordCount = countWords(input);

        System.out.println("Количество слов: " + wordCount);

        scanner.close();
    }

    public static int countWords(String input) {

        input = input.trim();

        if (input.isEmpty()) {
            return 0;
        }

        // Разделение строки на слова по пробелам
        String[] words = input.split("\\s+");

        return words.length;
    }
}
