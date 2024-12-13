package prac8;

/*Задание Треугольная последовательность
Дана монотонная последовательность, в которой каждое натуральное
число k встречается ровно k раз: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4,…
По данному натуральному n выведите первые n членов этой
последовательности. Попробуйте обойтись только одним циклом for.*/

    class TriangularSequence {

    // Рекурсивный метод для вывода треугольной последовательности
    public static void printTriangularSequence(int n, int currentNumber, int count) {
        if (n <= 0) {
            return; // Базовый случай: если n меньше или равно 0, прекращаем
        }

        // Печатаем текущее число
        System.out.print(currentNumber + " ");

        // Уменьшаем n на 1
        n--;

        // Если текущее число еще не закончило свою серию
        if (count < currentNumber) {
            // Продолжаем печатать текущее число
            printTriangularSequence(n, currentNumber, count + 1);
        } else {
            // Переходим к следующему числу
            printTriangularSequence(n, currentNumber + 1, 1);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Задайте количество членов последовательности, которые нужно вывести
        System.out.println("Первые " + n + " членов треугольной последовательности:");
        printTriangularSequence(n, 1, 1); // Начинаем с числа 1 и счетчика 1
    }
}