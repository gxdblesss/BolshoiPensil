package prac7;

// Интерфейс Printable
interface Printable {
    void print();
}

// Класс Book реализует интерфейс Printable
class Book implements Printable {
    private String title;

    // Конструктор
    public Book(String title) {
        this.title = title;
    }

    // Реализация метода print из интерфейса Printable
    @Override
    public void print() {
        System.out.println("Book title: " + title);
    }

    // Статический метод для вывода только книг
    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            // Проверяем, является ли объект экземпляром класса Book
            if (p instanceof Book) {
                // Приводим объект к типу Book и выводим его название
                System.out.println(((Book) p).title);
            }
        }
    }
}

// Класс Magazine также реализует интерфейс Printable
class Magazine implements Printable {
    private String title;

    // Конструктор
    public Magazine(String title) {
        this.title = title;
    }

    // Реализация метода print из интерфейса Printable
    @Override
    public void print() {
        System.out.println("Magazine title: " + title);
    }
}

// Основной класс для тестирования кода
public class p71 {
    public static void main(String[] args) {
        // Создаем массив объектов Printable
        Printable[] items = {
                new Book("The Great Gatsby"),
                new Magazine("Forbes"),
                new Book("To Kill a Mockingbird"),
                new Magazine("Time")
        };

        // Вызываем метод printBooks для вывода только книг
        Book.printBooks(items);
    }
}
