package prac14;

//Дан текст, необходимо проверить есть ли в тексте цифры, за
//        которыми не стоит знак «+».
//        a) пример правильных выражений:(1 + 8) – 9 / 4
//        b) пример неправильных выражений: 6 / 5 – 2 * 9

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p141 {
    public static void main(String[] args) {
        String text = "6 / 5 – 2 * 9"; // Пример неправильного выражения
        checkNumbersWithoutPlus(text);
    }

    public static void checkNumbersWithoutPlus(String input) {
        // Регулярное выражение для поиска чисел, за которыми НЕ стоит знак +
        String regex = "\\b\\d+\\b(?!\\s*\\+)";

        // Компилируем регулярное выражение
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Проверяем совпадения
        boolean hasMatches = false;
        while (matcher.find()) {
            hasMatches = true;
            System.out.println("Найдено число без знака '+': " + matcher.group());
        }

        if (!hasMatches) {
            System.out.println("Все числа имеют знак '+' после себя.");
        }
    }
}