package prac14;

//Дан текст со списками цен. Извлечь из него цены в USD, RUВ, EU.
//        a) пример правильных выражений: 25.98 USD.
//        b) пример неправильных выражений: 44 ERR, 0.004 EU.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p142 {
    public static void main(String[] args) {
        String text = "Цены: 25.98 USD, 44.00 RUB, 0.99 EUR, 0.004 EU, 50 ERR, 100 USD.";
        extractPrices(text);
    }

    public static void extractPrices(String input) {
        // Регулярное выражение для поиска цен в USD, RUB, EUR
        String regex = "\\b(\\d{1,3}(?:\\.\\d{1,2})?)\\s*(USD|RUB|EUR)\\b";

        // Компилируем регулярное выражение
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Проверяем совпадения
        boolean hasMatches = false;
        while (matcher.find()) {
            String price = matcher.group(1); // сумма
            String currency = matcher.group(2); // валюта
            System.out.println("Найдена цена: " + price + " " + currency);
            hasMatches = true;
        }

        if (!hasMatches) {
            System.out.println("Цены в USD, RUB, или EUR не найдены.");
        }
    }
}