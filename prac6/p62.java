package prac6;

// Интерфейс Printable
interface Printable {
    void print();
}

// Класс для книги
class Book implements Printable {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год издания: " + year);
    }
}

// Основной класс для тестирования
public class p62 {
    public static void main(String[] args) {
        // Создание объекта книги
        Book book = new Book("1984", "Джордж Оруэлл", 1949);

        // Вызов метода print для отображения информации о книге
        book.print();
    }
}