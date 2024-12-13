package prac14;

//Написать регулярное выражение, определяющее является ли данная
//        строка строкой "abcdefghijklmnopqrstuv18340" или нет.
//        a) пример правильных выражений: abcdefghijklmnopqrstuv18340
//        b) пример неправильных выражений:
//        abcdefghijklmnoasdfasdpqrstuv18340.

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class p143 {
    public static void main(String[] args) {
        String correctString = "abcdefghijklmnopqrstuv18340";
        String incorrectString = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.println(isValidString(correctString));  // true
        System.out.println(isValidString(incorrectString)); // false
    }

    public static boolean isValidString(String input) {
        // Регулярное выражение для точного совпадения строки
        String regex = "^abcdefghijklmnopqrstuv18340$";

        // Компилируем регулярное выражение
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Возвращаем результат проверки
        return matcher.matches();
    }
}