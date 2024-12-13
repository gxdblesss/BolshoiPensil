package prac2;



import java.util.Scanner;

// Класс для представления точки на плоскости
class Point {
    private double x; // Координата x
    private double y; // Координата y

    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод для вывода информации о точке
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

// Класс для представления окружности
class Circle {
    private Point center; // Центр окружности
    private double radius; // Радиус окружности

    // Конструктор
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // Геттеры
    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    // Метод для вывода информации об окружности
    @Override
    public String toString() {
        return "Circle[Center: " + center + ", Radius: " + radius + "]";
    }
}

// Класс для тестирования и взаимодействия с пользователем
public class Task3 {
    private Circle[] circles; // Массив окружностей
    private int count; // Количество окружностей

    // Конструктор
    public Task3 (int size) {
        circles = new Circle[size];
        count = 0;
    }

    // Метод для добавления окружности
    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        } else {
            System.out.println("Массив окружностей полон!");
        }
    }

    // Метод для отображения всех окружностей
    public void displayCircles() {
        for (int i = 0; i < count; i++) {
            System.out.println(circles[i]);
        }
    }

    // Метод для взаимодействия с пользователем
    public void run() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Введите координаты центра окружности " + (i + 1) + " (x и y):");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            System.out.println("Введите радиус окружности:");
            double radius = scanner.nextDouble();

            Point center = new Point(x, y);
            Circle circle = new Circle(center, radius);
            addCircle(circle);
        }

        System.out.println("Все окружности:");
        displayCircles();
        scanner.close();
    }

    public static void main(String[] args) {
        // Создание тестера с размером массива (например, 3)
        Task3 tester = new Task3(3);
        tester.run();
    }
}
