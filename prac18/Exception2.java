package prac18;
import java.util.Scanner;
//Шаг 1.Измените код в листинге 18.3 на следующий:
//Листинг 18.4 Пример программы
//public class Exception2 {
//    public void exceptionDemo() {
//        Scanner myScanner = new Scanner( System.in);
//        System.out.print( "Enter an integer ");
//        String intString = myScanner.next();
//        int i = Integer.parseInt(intString);
//        System.out.println( 2/i );
//    }
//}


//
//Шаг 2. Запустите эту программу со следующими выводами: Qwerty
//0 1.2 1. Посмотрите на вывод.
//Объясните какие исключения выбрасываются?
//
//






//
//Шаг 3. Измените код, добавив блоки try – catch, чтобы иметь дело с
//определяемыми исключениями.
//Объясните поведение программы



class Exception21 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString); // Может выбросить NumberFormatException
            System.out.println(2 / i); // Может выбросить ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            myScanner.close(); // Закрываем сканер для освобождения ресурсов
        }
    }
}









public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString); // Может выбросить NumberFormatException
            System.out.println(2 / i); // Может выбросить ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            myScanner.close(); // Закрываем сканер для освобождения ресурсов
        }
    }

    public static void main(String[] args) {
        Exception2 example = new Exception2();
        example.exceptionDemo(); // Вызов метода
    }
}
