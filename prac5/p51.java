package prac5;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс Shape
abstract class Shape {
    protected Color color; // Цвет фигуры
    protected Point position; // Позиция фигуры (левый верхний угол)

    // Конструктор класса Shape
    public Shape(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    // Абстрактный метод для рисования фигуры
    public abstract void draw(Graphics g);
}

// Класс Circle, наследующий от Shape
class Circle extends Shape {
    private int radius; // Радиус круга

    // Конструктор класса Circle
    public Circle(Color color, Point position, int radius) {
        super(color, position); // Вызов конструктора базового класса
        this.radius = radius; // Установка радиуса
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Установка цвета фигуры
        g.fillOval(position.x, position.y, radius * 2, radius * 2); // Рисование круга
    }
}

// Класс Rectangle, наследующий от Shape
class Rectangle extends Shape {
    private int width; // Ширина прямоугольника
    private int height; // Высота прямоугольника

    // Конструктор класса Rectangle
    public Rectangle(Color color, Point position, int width, int height) {
        super(color, position); // Вызов конструктора базового класса
        this.width = width; // Установка ширины
        this.height = height; // Установка высоты
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Установка цвета фигуры
        g.fillRect(position.x, position.y, width, height); // Рисование прямоугольника
    }
}

// Класс Triangle, наследующий от Shape
class Triangle extends Shape {
    private int base; // Основание треугольника
    private int height; // Высота треугольника

    // Конструктор класса Triangle
    public Triangle(Color color, Point position, int base, int height) {
        super(color, position); // Вызов конструктора базового класса
        this.base = base; // Установка основания
        this.height = height; // Установка высоты
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color); // Установка цвета фигуры
        int[] xPoints = {position.x, position.x + base / 2, position.x - base / 2}; // Координаты X
        int[] yPoints = {position.y, position.y + height, position.y + height}; // Координаты Y
        g.fillPolygon(xPoints, yPoints, 3); // Рисование треугольника
    }
}

// Главный класс для рисования случайных фигур
public class p51 extends JPanel {
    private Shape[] shapes; // Массив фигур

    // Конструктор класса RandomShapes
    public p51() {
        shapes = new Shape[20]; // Инициализация массива на 20 фигур
        Random random = new Random(); // Генератор случайных чисел

        // Генерация 20 случайных фигур
        for (int i = 0; i < shapes.length; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Случайный цвет
            Point position = new Point(random.nextInt(400), random.nextInt(400)); // Случайная позиция
            int size = random.nextInt(50) + 20; // Случайный размер (от 20 до 70)

            // Случайный выбор типа фигуры
            int shapeType = random.nextInt(3); // Генерируем случайное число от 0 до 2
            switch (shapeType) {
                case 0:
                    shapes[i] = new Circle(color, position, size); // Создание круга
                    break;
                case 1:
                    shapes[i] = new Rectangle(color, position, size, size); // Создание квадрата
                    break;
                case 2:
                    shapes[i] = new Triangle(color, position, size, size); // Создание треугольника
                    break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Вызов метода родительского класса для очистки области рисования

        // Рисование всех фигур
        for (Shape shape : shapes) {
            shape.draw(g); // Вызов метода draw для каждой фигуры
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Случайные фигуры"); // Создание окна с заголовком
        p51 panel = new p51(); // Создание экземпляра нашего JPanel

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Завершение программы при закрытии окна
        frame.setSize(500, 500); // Установка размера окна
        frame.add(panel); // Добавление панели для рисования в окно
        frame.setVisible(true); // Отображение окна
    }
}

