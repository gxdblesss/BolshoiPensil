package prac8;

/*Задание от 1 до n
Дано натуральное число n. Выведите все числа от 1 до n.*/
    class PrintNumbers {

    // Рекурсивный метод для печати чисел от 1 до n
    public static void printNumbers(int n, int current) {
        if (current > n) {
            return; // Базовый случай: если текущее число больше n, прекращаем
        }

        System.out.print(current + " "); // Печатаем текущее число
        printNumbers(n, current + 1); // Рекурсивный вызов с увеличенным текущим числом
    }

    public static void main(String[] args) {
        int n = 10; // Задайте значение n
        System.out.println("Числа от 1 до " + n + ":");
        printNumbers(n, 1); // Начинаем с 1
    }
}
