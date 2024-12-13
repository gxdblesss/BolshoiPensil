package prac17;

import java.util.Scanner;

// Класс, описывающий узел односвязного кольцевого списка
class PersonNode1 {
    private String name;
    private int age;
    public PersonNode1 next; // Ссылка на следующий элемент

    // Конструктор для создания нового узла
    public PersonNode1(String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
    }

    // Вывод атрибутов элемента на экран
    public void displayAttributes() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

// Класс для работы с односвязным кольцевым списком
class CircularLinkedList {
    private PersonNode tail; // Ссылка на последний элемент (tail)

    // Конструктор для создания пустого списка
    public CircularLinkedList() {
        this.tail = null;
    }

    // Функция, проверяющая, пуст ли список
    public boolean isEmpty() {
        return tail == null;
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
            // Если список пуст, новый узел указывает сам на себя
            tail = newNode;
            tail.next = tail;
        } else {
            // Вставляем новый элемент в конец списка
            newNode.next = tail.next; // Новый элемент указывает на первый элемент
            tail.next = newNode;      // Текущий "хвост" указывает на новый элемент
            tail = newNode;           // Новый элемент становится хвостом
        }

        System.out.println("Пользователь добавлен.");
    }

    // Функция удаления элемента по индексу
    public void removePerson(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = tail.next; // Начинаем с первого элемента (следующего за tail)
        PersonNode previous = tail;
        int count = 0;

        // Поиск элемента по индексу
        do {
            if (count == index) {
                if (current == tail) { // Если удаляем последний элемент
                    if (tail == tail.next) { // Это единственный элемент
                        tail = null;
                    } else {
                        previous.next = current.next;
                        tail = previous;
                    }
                } else if (current == tail.next) { // Если удаляем первый элемент
                    previous.next = current.next;
                    tail.next = current.next;
                } else { // Если удаляем элемент в середине
                    previous.next = current.next;
                }
                System.out.println("Элемент удален.");
                return;
            }

            previous = current;
            current = current.next;
            count++;
        } while (current != tail.next); // Проходим по всему кольцевому списку

        System.out.println("Индекс за пределами списка.");
    }

    // Функция вывода элемента списка по индексу
    public void displayPerson(int index) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = tail.next; // Начинаем с первого элемента
        int count = 0;

        do {
            if (count == index) {
                current.displayAttributes();
                return;
            }
            current = current.next;
            count++;
        } while (current != tail.next); // Проходим по всему кольцевому списку

        System.out.println("Индекс за пределами списка.");
    }

    // Функция вывода всех элементов списка
    public void displayAllPersons() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }

        PersonNode current = tail.next; // Начинаем с первого элемента
        int index = 0;

        do {
            System.out.print(index + ". ");
            current.displayAttributes();
            current = current.next;
            index++;
        } while (current != tail.next); // Проходим по всему кольцевому списку
    }

    // Функция очистки списка
    public void clearAll() {
        tail = null;
        System.out.println("Список очищен.");
    }
}

// Тестовый класс с главным меню
public class p173 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList group = new CircularLinkedList();  // Создаем пустой список

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