package prac2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запросить количество игроков
        System.out.print("Введите количество игроков: ");
        int n = scanner.nextInt();

        // Проверка на допустимое количество игроков
        if (n <= 0 || n > 10) {
            System.out.println("Количество игроков должно быть от 1 до 10.");
            return;
        }

        // Создание колоды карт
        List<String> deck = createDeck();

        // Перемешивание колоды
        Collections.shuffle(deck);

        // Раздача карт
        dealCards(deck, n);

        scanner.close();
    }

    // Метод для создания колоды карт
    public static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Черви", "Бубны", "Трефы", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " " + suit);
            }
        }
        return deck;
    }

    // Метод для раздачи карт игрокам
    public static void dealCards(List<String> deck, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Игрок " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.println(deck.get(i * 5 + j));
            }
            System.out.println(); // Пустая строка между игроками
        }
    }
}
