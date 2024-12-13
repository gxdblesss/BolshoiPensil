package prac13;

/*Задание 5. (25%) Разработайте класс, который получает строковое
        представление телефонного номера в одном из двух возможных строковых
        форматов:
        +<Код страны><Номер 10 цифр>, например “+79175655655” или
        “+104289652211” или
        8<Номер 10 цифр> для России, например “89175655655”
        и преобразует полученную строку в формат:
        +<Код страны><Три цифры>–<Три цифры>–<Четыре цифры>*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumberFormatter {

    // Метод для преобразования телефонного номера
    public static String formatPhoneNumber(String phoneNumber) {
        // Регулярные выражения для проверки форматов
        String internationalFormat = "^\\+(\\d{1,3})(\\d{10})$"; // +Код страны +10 цифр
        String domesticFormat = "^8(\\d{10})$"; // 8 + 10 цифр

        // Проверка формата международного номера
        Pattern patternInternational = Pattern.compile(internationalFormat);
        Matcher matcherInternational = patternInternational.matcher(phoneNumber);

        // Проверка формата внутреннего номера
        Pattern patternDomestic = Pattern.compile(domesticFormat);
        Matcher matcherDomestic = patternDomestic.matcher(phoneNumber);

        if (matcherInternational.matches()) {
            // Преобразование международного формата
            String countryCode = matcherInternational.group(1); // Код страны
            String number = matcherInternational.group(2); // Номер
            return String.format("+%s-%s-%s-%s", countryCode, number.substring(0, 3), number.substring(3, 6), number.substring(6));
        } else if (matcherDomestic.matches()) {
            // Преобразование внутреннего формата
            String number = matcherDomestic.group(1); // Номер
            return String.format("+7-%s-%s-%s", number.substring(0, 3), number.substring(3, 6), number.substring(6));
        } else {
            // Если номер не соответствует ни одному из форматов
            throw new IllegalArgumentException("Неверный формат телефонного номера: " + phoneNumber);
        }
    }

    // Метод main для тестирования
    public static void main(String[] args) {
        // Примеры телефонных номеров для тестирования
        String[] phoneNumbers = {
                "+79175655655",
                "+104289652211",
                "89175655655"
        };

        // Тестируем форматирование
        for (String number : phoneNumbers) {
            try {
                String formattedNumber = formatPhoneNumber(number);
                System.out.println("Исходный номер: " + number);
                System.out.println("Отформатированный номер: " + formattedNumber);
                System.out.println("----------------------------------");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}


