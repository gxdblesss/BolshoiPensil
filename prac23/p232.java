package prac23;

// Интерфейс очереди
interface Queue<T> {
    void enqueue(T item); // Добавляет элемент в очередь
    T dequeue();          // Удаляет и возвращает элемент из очереди
    T peek();            // Возвращает элемент из очереди, не удаляя его
    boolean isEmpty();    // Проверяет, пуста ли очередь
    int size();           // Возвращает количество элементов в очереди
}

// Абстрактный класс для общей функциональности очереди
abstract class AbstractQueue<T> implements Queue<T> {
    protected int size;

    public AbstractQueue() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}

// Класс, представляющий узел связного списка
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Реализация очереди на связном списке
class LinkedQueue<T> extends AbstractQueue<T> {
    private Node<T> head; // Голова очереди
    private Node<T> tail; // Хвост очереди

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail != null) {
            tail.next = newNode; // Присоединяем новый узел к хвосту
        }
        tail = newNode; // Обновляем хвост
        if (head == null) {
            head = newNode; // Если очередь была пустой, обновляем голову
        }
        size++; // Увеличиваем размер очереди
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        T data = head.data; // Сохраняем данные из головы
        head = head.next; // Перемещаем голову на следующий узел
        if (head == null) {
            tail = null; // Если очередь опустела, обнуляем хвост
        }
        size--; // Уменьшаем размер очереди
        return data; // Возвращаем данные
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return head.data; // Возвращаем данные из головы, не удаляя
    }
}

// Пример использования
public class p232 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Первый элемент очереди: " + queue.peek()); // Должно напечатать 1
        System.out.println("Размер очереди: " + queue.size()); // Должно напечатать 3

        System.out.println("Удаляем элемент: " + queue.dequeue()); // Должно напечатать 1
        System.out.println("Размер очереди: " + queue.size()); // Должно напечатать 2
    }
}