package prac20;

//1. Создать обобщенный класс с тремя параметрами (T, V, K).
// Обобщенный класс с тремя параметрами типа T, V и K
public class Triple<T, V, K> {
    // Поля класса
    private T first;
    private V second;
    private K third;

    // Конструктор для инициализации полей
    public Triple(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Геттеры для каждого поля
    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    // Сеттеры для каждого поля
    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public void setThird(K third) {
        this.third = third;
    }

    // Метод для представления объекта в виде строки
    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    // Главный метод для тестирования класса
    public static void main(String[] args) {
        // Создание объекта Triple с типами String, Integer и Boolean
        Triple<String, Integer, Boolean> triple = new Triple<>("Hello", 42, true);

        // Вывод объекта
        System.out.println(triple);

        // Изменение значений полей
        triple.setFirst("Goodbye");
        triple.setSecond(100);
        triple.setThird(false);

        // Вывод обновленного объекта
        System.out.println(triple);
    }
}