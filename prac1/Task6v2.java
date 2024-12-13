package prac1;

public class Task6v2 {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");

        for (Integer i = 1; i <= 10; i++) {
            Double harmonicNumber = Double.valueOf(1.0 / i);
            System.out.printf("H%d = %.2f%n", i, harmonicNumber);
        }
    }
}
