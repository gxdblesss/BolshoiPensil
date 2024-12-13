package prac22;

import java.util.Scanner;  // Импортируем класс для получения ввода от пользователя
import java.util.Stack;    // Импортируем класс Stack, который реализует структуру данных "стек"

public class RPNCalculator {
    public static void main(String[] args) {
        // Запрашиваем у пользователя ввод выражения в обратной польской нотации (Reverse Polish Notation)
        System.out.print("Enter the expression in Reverse Polish Notation: ");  // Пример: 2 3 4 5 6 * + - /
        Scanner scanner = new Scanner(System.in);  // Используем Scanner для считывания строки с консоли
        String[] expr = scanner.nextLine().split(" ");  // Разбиваем введенное выражение на массив строк (разделитель - пробел)

        // Создаем стек для чисел
        Stack<Double> number = new Stack<>();  // Это конкретная реализация стека на основе класса Stack

        try {
            // Проходим по каждому элементу выражения
            for (String s : expr) {
                // Если элемент — это число (совпадает с регулярным выражением для целых чисел)
                if (s.matches("^\\d+$")) {
                    number.add(Double.parseDouble(s));  // Преобразуем строку в число и добавляем его в стек
                } else {
                    // Если элемент — это оператор, выполняем соответствующее действие
                    switch (s) {
                        case "+" ->
                            // Складываем два верхних элемента стека и результат помещаем обратно в стек
                                number.add(number.pop() + number.pop());

                        case "*" ->
                            // Умножаем два верхних элемента стека и результат помещаем обратно в стек
                                number.add(number.pop() * number.pop());

                        case "-" -> {
                            double a = number.pop();  // Извлекаем верхний элемент (вычитаемое)
                            double b = number.pop();  // Извлекаем следующий элемент (уменьшаемое)
                            number.add(b - a);  // Вычисляем b - a и результат помещаем обратно в стек
                        }

                        case "/" -> {
                            double a = number.pop();  // Извлекаем верхний элемент (делитель)
                            double b = number.pop();  // Извлекаем следующий элемент (делимое)
                            if (a == 0) {  // Если делитель равен нулю, добавляем 0 как результат
                                number.add(.0);
                            } else {
                                number.add(b / a);  // Вычисляем b / a и результат помещаем обратно в стек
                            }
                        }
                    }
                }
            }
            // После завершения обработки выражения, в стеке должен остаться только один элемент — результат
            if (number.size() > 1) {
                // Если в стеке больше одного элемента, это ошибка: лишнее число
                throw new Exception("Extra number: " + number.pop());
            }

            // Выводим результат выражения, который является последним элементом стека
            System.out.printf("Expression result: %.4f", number.pop());
        } catch (Exception e) {  // Обрабатываем исключения, если были ошибки во время вычислений
            System.out.println("Invalid reverse polish notation record. Broken at:");
            System.err.println(e.toString());  // Выводим сообщение об ошибке
        }
    }
}