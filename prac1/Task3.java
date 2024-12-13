package prac1;
public class Task3 {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }
}




