package prac11;



import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class p1114 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год, месяц и число (ГГГГ ММ ДД): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt() - 1; // Месяцы начинаются с 0
        int day = scanner.nextInt();

        // Проверка корректности введенной даты
        if (!isValidDateAlternative(year, month, day)) {
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

    // Альтернативный метод для проверки корректности даты
    private static boolean isValidDateAlternative(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false); // Отключаем поддержку автоматической коррекции

        try {
            calendar.set(year, month, day);
            calendar.getTime(); // Попытка преобразовать введенную дату
            return true;
        } catch (Exception e) {
            return false; // Исключение означает невалидную дату
        }
    }
}
