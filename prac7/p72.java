package prac7;

// Интерфейс для работы со строками
interface StringProcessor {
    // Подсчет количества символов в строке
    int countCharacters(String s);

    // Получение строки, состоящей из символов на нечетных позициях
    String getOddPositionChars(String s);

    // Инвертирование строки
    String reverseString(String s);
}

// Класс, реализующий интерфейс StringProcessor
class StringProcessorImpl implements StringProcessor {

    // Реализация метода подсчета символов
    @Override
    public int countCharacters(String s) {
        if (s == null) {//""
            return 0; // Если строка null, возвращаем 0
        }
        return s.length();
    }

    // Реализация метода для получения символов на нечетных позициях
    @Override
    public String getOddPositionChars(String s) {
        if (s == null || s.isEmpty()) {
            return ""; // Если строка null или пустая, возвращаем пустую строку
        }

        StringBuilder oddChars = new StringBuilder();
        // Цикл по нечетным позициям (индексация с 0, поэтому нечетные позиции это 1, 3, 5...)
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                oddChars.append(s.charAt(i));
            }
        }
        return oddChars.toString();
    }

    // Реализация метода для инвертирования строки
    @Override
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return ""; // Если строка null или пустая, возвращаем пустую строку
        }

        return new StringBuilder(s).reverse().toString(); // Используем StringBuilder для инвертирования
    }
}

// Основной класс для тестирования
public class p72 {
    public static void main(String[] args) {
        // Создаем объект класса, реализующего StringProcessor
        StringProcessor processor = new StringProcessorImpl();

        String testString = "Hello, World!";

        // Подсчет символов
        System.out.println("Количество символов: " + processor.countCharacters(testString));

        // Получение символов на нечетных позициях
        System.out.println("Символы на нечетных позициях: " + processor.getOddPositionChars(testString));

        // Инвертирование строки
        System.out.println("Инвертированная строка: " + processor.reverseString(testString));
    }
}
