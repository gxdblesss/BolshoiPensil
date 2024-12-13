package prac17;

import java.util.Scanner;

// Класс, описывающий узел двусвязного списка (например, студента)
class PersonNode {
    private String name;
    private int age;
    public PersonNode prev; // Ссылка на предыдущий элемент
    public PersonNode next; // Ссылка на следующий элемент

    // Конструктор для создания нового узла
    public PersonNode(String name, int age) {
        this.name = name;
        this.age = age;
        this.prev = null;
        this.next = null;
    }

    // Вывод атрибутов элемента на экран
    public void displayAttributes() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

// Класс для работы с двухсвязным списком
class DoublyLinkedList {
    private PersonNode head; // Ссылка на первый элемент списка
    private PersonNode tail; // Ссылка на последний элемент списка

    // Конструктор для создания пустого списка
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Функция, проверяющая, пуст ли список
    public boolean isEmpty() {
        return head == null;
    }

    // Функция добавления нового элемента в конец списка
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        PersonNode newNode = new PersonNode(name, age);

        if (isEmpty()) {
            // Если список пуст, новый узел становится и головой, и хвостом
            head = newNode;
            tail = newNode;
        } else {
            // Добавляем новый элемент в конец списка
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Пользователь добавлен.");
    }

    // Функция удаления элемента по индексу
    public void removePerson(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = head;
        int count = 0;

        // Поиск элемента по индексу
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Индекс за пределами списка.");
            return;
        }

        // Удаление элемента
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // Если список стал пустым
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Элемент удален.");
    }

    // Функция вывода элемента списка по индексу
    public void displayPerson(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = head;
        int count = 0;

        // Поиск элемента по индексу
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Индекс за пределами списка.");
        } else {
            current.displayAttributes();
        }
    }

    // Функция вывода всех элементов списка
    public void displayAllPersons() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = head;
        int index = 0;

        while (current != null) {
            System.out.print(index + ". ");
            current.displayAttributes();
            current = current.next;
            index++;
        }
    }

    // Функция очистки списка
    public void clearAll() {
        head = null;
        tail = null;
        System.out.println("Список очищен.");
    }
}

// Тестовый класс с главным меню
public class p172 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList group = new DoublyLinkedList();  // Создаем пустой список

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Показать элемент");
            System.out.println("4. Показать всех");
            System.out.println("5. Очистить список");
            System.out.println("6. Проверить, пуст ли список");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Добавление элемента
                    group.addPerson();
                    break;
                case 2:
                    // Удаление элемента
                    System.out.print("Введите индекс для удаления: ");
                    int indexToRemove = scanner.nextInt();
                    group.removePerson(indexToRemove);
                    break;
                case 3:
                    // Показать элемент
                    System.out.print("Введите индекс для отображения: ");
                    int indexToDisplay = scanner.nextInt();
                    group.displayPerson(indexToDisplay);
                    break;
                case 4:
                    // Показать всех
                    group.displayAllPersons();
                    break;
                case 5:
                    // Очистить список
                    group.clearAll();
                    break;
                case 6:
                    // Проверить, пуст ли список
                    if (group.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("Список не пуст.");
                    }
                    break;
                case 0:
                    // Выход из программы
                    System.out.println("Выход из программы.");
                    return;  // Завершаем выполнение программы
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}