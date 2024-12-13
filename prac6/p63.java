package prac6;

import java.util.Scanner;

// Интерфейс Convertable
interface Convertable {
    double convert(double celsius);
}

// Класс для работы с температурой
class Temperature implements Convertable {

    @Override
    public double convert(double celsius) {
        return celsius; // Возвращает саму температуру в Цельсиях (для дальнейших конвертаций)
    }

    // Метод для конвертации в Кельвины
    public double toKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Метод для конвертации в Фаренгейты
    public double toFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}

// Основной класс для тестирования
public class p63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос температуры в Цельсиях
        System.out.print("Введите температуру в Цельсиях: ");
        double celsius = scanner.nextDouble();

        // Создание объекта Temperature
        Temperature temperature = new Temperature();

        // Конвертация температуры
        double kelvin = temperature.toKelvin(celsius);
        double fahrenheit = temperature.toFahrenheit(celsius);

        // Вывод результатов
        System.out.printf("Температура в Кельвинах: %.2f K%n", kelvin);
        System.out.printf("Температура в Фаренгейтах: %.2f °F%n", fahrenheit);

        scanner.close();
    }
}