package prac11;

/*Задание 4. (10%)
        Напишите пользовательский код, который формирует объекты Date и
        Calendar по следующим данным, вводимым пользователем:
        <Год><Месяц><Число>
        <Часы1><минуты>*/

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

 class Assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год, месяц и число (ГГГГ ММ ДД): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt() - 1; // Месяцы начинаются с 0
        int day = scanner.nextInt();

        // Проверка корректности введенной даты
        if (!isValidDate(year, month, day)) {
            System.out.println("Ошибка: Введенная дата недействительна.");
            return;
        }

        System.out.print("Введите часы и минуты (ЧЧ ММ): ");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        // Создание объекта Date
        Date date = new Date(year - 1900, month, day, hour, minute);
        System.out.println("Созданный объект Date: " + date);

        // Создание объекта Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);
        System.out.println("Созданный объект Calendar: " + calendar.getTime());
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


//другой способ проверки