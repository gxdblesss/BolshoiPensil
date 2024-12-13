package prac23;

//задание 1:
public class QueueTest {

    // Реализация ArrayQueueModule (статическая очередь)
    public static class ArrayQueueModule {
        private static final int DEFAULT_CAPACITY = 10;
        private static Object[] elements = new Object[DEFAULT_CAPACITY];
        private static int head = 0;
        private static int tail = 0;
        private static int size = 0;

        // Инвариант: (tail - head + elements.length) % elements.length == size

        // Добавить элемент в конец очереди
        public static void enqueue(Object element) {
            assert element != null;
            ensureCapacity(size + 1);
            elements[tail] = element;
            tail = (tail + 1) % elements.length;
            size++;
        }

        // Вернуть первый элемент очереди
        public static Object element() {
            assert size > 0;
            return elements[head];
        }

        // Удалить и вернуть первый элемент очереди
        public static Object dequeue() {
            assert size > 0;
            Object result = elements[head];
            elements[head] = null;
            head = (head + 1) % elements.length;
            size--;
            return result;
        }

        // Текущий размер очереди
        public static int size() {
            return size;
        }

        // Проверка, пуста ли очередь
        public static boolean isEmpty() {
            return size == 0;
        }

        // Очистить очередь
        public static void clear() {
            elements = new Object[DEFAULT_CAPACITY];
            head = 0;
            tail = 0;
            size = 0;
        }

        // Увеличение размера массива при необходимости
        private static void ensureCapacity(int capacity) {
            if (capacity > elements.length) {
                int newCapacity = 2 * elements.length;
                Object[] newElements = new Object[newCapacity];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[(head + i) % elements.length];
                }
                elements = newElements;
                head = 0;
                tail = size;
            }
        }
    }

    // Реализация ArrayQueueADT (ADT с явной передачей экземпляра)
    public static class ArrayQueueADT {
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] elements;
        private int head;
        private int tail;
        private int size;

        public ArrayQueueADT() {
            elements = new Object[DEFAULT_CAPACITY];
            head = 0;
            tail = 0;
            size = 0;
        }

        // Добавить элемент в очередь
        public static void enqueue(ArrayQueueADT queue, Object element) {
            assert queue != null && element != null;
            ensureCapacity(queue, queue.size + 1);
            queue.elements[queue.tail] = element;
            queue.tail = (queue.tail + 1) % queue.elements.length;
            queue.size++;
        }

        // Вернуть первый элемент очереди
        public static Object element(ArrayQueueADT queue) {
            assert queue != null && queue.size > 0;
            return queue.elements[queue.head];
        }

        // Удалить и вернуть первый элемент очереди
        public static Object dequeue(ArrayQueueADT queue) {
            assert queue != null && queue.size > 0;
            Object result = queue.elements[queue.head];
            queue.elements[queue.head] = null;
            queue.head = (queue.head + 1) % queue.elements.length;
            queue.size--;
            return result;
        }

        // Текущий размер очереди
        public static int size(ArrayQueueADT queue) {
            assert queue != null;
            return queue.size;
        }

        // Проверка, пуста ли очередь
        public static boolean isEmpty(ArrayQueueADT queue) {
            assert queue != null;
            return queue.size == 0;
        }

        // Очистить очередь
        public static void clear(ArrayQueueADT queue) {
            assert queue != null;
            queue.elements = new Object[DEFAULT_CAPACITY];
            queue.head = 0;
            queue.tail = 0;
            queue.size = 0;
        }

        // Увеличение размера массива при необходимости
        private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
            if (capacity > queue.elements.length) {
                int newCapacity = 2 * queue.elements.length;
                Object[] newElements = new Object[newCapacity];
                for (int i = 0; i < queue.size; i++) {
                    newElements[i] = queue.elements[(queue.head + i) % queue.elements.length];
                }
                queue.elements = newElements;
                queue.head = 0;
                queue.tail = queue.size;
            }
        }
    }

    // Реализация ArrayQueue (неявная передача экземпляра)
    public static class ArrayQueue {
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] elements;
        private int head;
        private int tail;
        private int size;

        public ArrayQueue() {
            elements = new Object[DEFAULT_CAPACITY];
            head = 0;
            tail = 0;
            size = 0;
        }

        // Добавить элемент в очередь
        public void enqueue(Object element) {
            assert element != null;
            ensureCapacity(size + 1);
            elements[tail] = element;
            tail = (tail + 1) % elements.length;
            size++;
        }

        // Вернуть первый элемент очереди
        public Object element() {
            assert size > 0;
            return elements[head];
        }

        // Удалить и вернуть первый элемент очереди
        public Object dequeue() {
            assert size > 0;
            Object result = elements[head];
            elements[head] = null;
            head = (head + 1) % elements.length;
            size--;
            return result;
        }

        // Текущий размер очереди
        public int size() {
            return size;
        }

        // Проверка, пуста ли очередь
        public boolean isEmpty() {
            return size == 0;
        }

        // Очистить очередь
        public void clear() {
            elements = new Object[DEFAULT_CAPACITY];
            head = 0;
            tail = 0;
            size = 0;
        }

        // Увеличение размера массива при необходимости
        private void ensureCapacity(int capacity) {
            if (capacity > elements.length) {
                int newCapacity = 2 * elements.length;
                Object[] newElements = new Object[newCapacity];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[(head + i) % elements.length];
                }
                elements = newElements;
                head = 0;
                tail = size;
            }
        }
    }

    // Тестирование всех трех реализаций очереди
    public static void main(String[] args) {
        // Тест для ArrayQueueModule
        System.out.println("Testing ArrayQueueModule...");
        ArrayQueueModule.enqueue("A");
        ArrayQueueModule.enqueue("B");
        ArrayQueueModule.enqueue("C");
        System.out.println(ArrayQueueModule.dequeue()); // A
        System.out.println(ArrayQueueModule.element()); // B
        System.out.println(ArrayQueueModule.dequeue()); // B
        System.out.println(ArrayQueueModule.size()); // 1
        System.out.println(ArrayQueueModule.isEmpty()); // false
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty()); // true

        // Тест для ArrayQueueADT
        System.out.println("\nTesting ArrayQueueADT...");
        ArrayQueueADT queueADT = new ArrayQueueADT();
        ArrayQueueADT.enqueue(queueADT, "X");
        ArrayQueueADT.enqueue(queueADT, "Y");
        ArrayQueueADT.enqueue(queueADT, "Z");
        System.out.println(ArrayQueueADT.dequeue(queueADT)); // X
        System.out.println(ArrayQueueADT.element(queueADT)); // Y
        System.out.println(ArrayQueueADT.dequeue(queueADT)); // Y
        System.out.println(ArrayQueueADT.size(queueADT)); // 1
        System.out.println(ArrayQueueADT.isEmpty(queueADT)); // false
        ArrayQueueADT.clear(queueADT);
        System.out.println(ArrayQueueADT.isEmpty(queueADT)); // true

        // Тест для ArrayQueue
        System.out.println("\nTesting ArrayQueue...");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.element()); // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.size()); // 1
        System.out.println(queue.isEmpty()); // false
        queue.clear();
        System.out.println(queue.isEmpty()); // true
    }
}
