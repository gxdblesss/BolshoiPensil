package prac7;

interface MathCalculable {
    // Константа PI
    double PI = 3.141592653589793;

    // Метод для возведения числа в степень
    double power(double base, double exponent);

    // Метод для вычисления модуля комплексного числа
    double modulus(double real, double imaginary);
}
class MathFunc implements MathCalculable {
    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent); // Используем метод Math.pow для возведения в степень
    }

    @Override
    public double modulus(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary); // Вычисляем модуль комплексного числа
    }

    // Метод для вычисления длины окружности
    public double circumference(double radius) {
        return 2 * PI * radius; // Используем PI из интерфейса
    }
}
class Main {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc(); // Создаем экземпляр MathFunc через интерфейс

        // Тестируем метод power
        double base = 2;
        double exponent = 3;
        double resultPower = mc1.power(base, exponent);
        System.out.println(base + " в степени " + exponent + " = " + resultPower);

        // Тестируем метод modulus
        double real = 3;
        double imaginary = 4;
        double resultModulus = mc1.modulus(real, imaginary);
        System.out.println("Модуль комплексного числа (" + real + ", " + imaginary + ") = " + resultModulus);

        // Тестируем метод circumference
        double radius = 5;
        double resultCircumference = ((MathFunc) mc1).circumference(radius);
        System.out.println("Длина окружности с радиусом " + radius + " = " + resultCircumference);
    }
}



