package prac11;

/*Задание 2. (20%)
        Приложение, сравнивающее текущую дату и дату, введенную
        пользователем c текущим системным временем*/

import java.util.Date;
import java.util.Scanner;
 class Assignment2 {
    public static void main(String[] args) {
        Date currentDate = new Date(); // Текущая дата

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ГГГГ-ММ-ДД: ");
        String inputDate = scanner.nextLine();

        // Парсинг введенной даты
        String[] dateParts = inputDate.split("-");
        if (dateParts.length != 3) {
            System.out.println("Ошибка: Неверный формат даты. Используйте ГГГГ-ММ-ДД.");
            return;
        }

        int year, month, day;

        try {
            year = Integer.parseInt(dateParts[0]);
            month = Integer.parseInt(dateParts[1]) - 1; // Месяцы начинаются с 0
            day = Integer.parseInt(dateParts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите корректные числовые значения для даты.");
            return;
        }

        // Проверка корректности введенной даты
        if (!isValidDate(year, month, day)) {
            System.out.println("Ошибка: Введенная дата недействительна.");
            return;
        }

        // Создание даты из введенных данных
        Date userDate = new Date(year - 1900, month, day);

        // Сравнение дат
        if (userDate.after(currentDate)) {
            System.out.println("Введенная дата позже текущей.");
        } else if (userDate.before(currentDate)) {
            System.out.println("Введенная дата раньше текущей.");
        } else {
            System.out.println("Введенная дата совпадает с текущей.");
        }
    }

    // Метод для проверки корректности даты
    private static boolean isValidDate(int year, int month, int day) {
        if (month < 0 || month > 11) {
            return false; // Месяц вне диапазона
        }

        // Проверка количества дней в месяце
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Проверка на високосный год для февраля
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // Февраль в високосный год
        }

        return day > 0 && day <= daysInMonth[month]; // Проверка корректности дня
    }

    // Метод для проверки високосного года
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}


