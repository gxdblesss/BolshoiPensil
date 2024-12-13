package prac2;


// Класс Book, представляющий книгу
class Book {
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    // Методы для получения и изменения свойств
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

// Класс BookShelf, представляющий книжную полку
class BookShelf {
    private Book[] books;
    private int bookCount;

    public BookShelf(int size) {
        books = new Book[size];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("Полка заполнена, невозможно добавить книгу.");
        }
    }

    public Book getLatestBook() {
        if (bookCount == 0) return null;
        Book latest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getYear() > latest.getYear()) {
                latest = books[i];
            }
        }
        return latest;
    }

    public Book getEarliestBook() {
        if (bookCount == 0) return null;
        Book earliest = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getYear() < earliest.getYear()) {
                earliest = books[i];
            }
        }
        return earliest;
    }

    public void sortBooksByYear() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
}

// Класс для тестирования Book и BookShelf
public class BookTest {
    public static void main(String[] args) {
        // Создаем несколько книг
        Book book1 = new Book("Леха", "Мой сосед", 2000);
        Book book2 = new Book("Миша circle", "Купола", 1995);
        Book book3 = new Book("YA3", "прям ща прям тут", 2010);

        // Создаем книжную полку и добавляем книги
        BookShelf shelf = new BookShelf(5);
        shelf.addBook(book1);
        shelf.addBook(book2);
        shelf.addBook(book3);

        // Отображаем книги на полке
        System.out.println("Книги на полке:");
        shelf.displayBooks();

        // Находим и выводим самую позднюю и самую раннюю книги
        System.out.println("Самая поздняя книга: " + shelf.getLatestBook());
        System.out.println("Самая ранняя книга: " + shelf.getEarliestBook());

        // Сортируем книги по году и отображаем их снова
        shelf.sortBooksByYear();
        System.out.println("Книги после сортировки по году издания:");
        shelf.displayBooks();
    }
}
