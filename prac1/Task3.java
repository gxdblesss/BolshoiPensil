package prac1;
public class Task3 {
    public static void main(String[] args) {
        // Инициализация массива (как в Си)
        int[] numbers = {1, 2, 3, 4, 5};

        int sum = 0;

        // Вычисляем сумму элементов массива
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Вычисляем среднее арифметическое
        double average = (double) sum / numbers.length;

        // Вывод результатов
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }
}




