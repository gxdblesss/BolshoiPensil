//package prac20;
//
//Наложить ограничения на параметры типа: T должен
//        реализовать интерфейс Comparable (классы оболочки, String), V должен
//        реализовать интерфейс Serializable и расширять класс Animal, K

//import java.io.Serializable;
//
//// Базовый класс Animal
//class Animal {
//    // Здесь могут быть определены свойства и методы для класса Animal
//}
//
//// Класс Dog наследуется от Animal и реализует интерфейс Serializable
//class Dog extends Animal implements Serializable {
//    private String name; // Имя собаки
//
//    // Конструктор класса Dog
//    public Dog(String name) {
//        this.name = name;
//    }
//
//    // Метод для получения имени собаки
//    public String getName() {
//        return name;
//    }
//
//    // Переопределение метода toString для класса Dog
//    @Override
//    public String toString() {
//        return "Dog{name='" + name + "'}";
//    }
//}
//
//// Класс Triple с параметрами типа T, V и K
//// T должен реализовывать интерфейс Comparable
//// V должен быть подклассом Animal и реализовывать интерфейс Serializable
//// K не имеет дополнительных ограничений
//class Triple<T extends Comparable<T>, V extends Animal & Serializable, K> {
//    private T first;  // Первый элемент типа T
//    private V second; // Второй элемент типа V
//    private K third;  // Третий элемент типа K
//
//    // Конструктор класса Triple
//    public Triple(T first, V second, K third) {
//        this.first = first;
//        this.second = second;
//        this.third = third;
//    }
//
//    // Геттер для первого элемента
//    public T getFirst() {
//        return first;
//    }
//
//    // Сеттер для первого элемента
//    public void setFirst(T first) {
//        this.first = first;
//    }
//
//    // Геттер для второго элемента
//    public V getSecond() {
//        return second;
//    }
//
//    // Сеттер для второго элемента
//    public void setSecond(V second) {
//        this.second = second;
//    }
//
//    // Геттер для третьего элемента
//    public K getThird() {
//        return third;
//    }
//
//    // Сеттер для третьего элемента
//    public void setThird(K third) {
//        this.third = third;
//    }
//
//    // Переопределение метода toString для класса Triple
//    @Override
//    public String toString() {
//        return "Triple{" +
//                "first=" + first +
//                ", second=" + second +
//                ", third=" + third +
//                '}';
//    }
//
//    // Главный метод для тестирования класса Triple
//    public static void main(String[] args) {
//        // Создание объекта Dog с именем "Buddy"
//        Dog dog = new Dog("Buddy");
//
//        // Создание объекта Triple с типами String, Dog и Integer
//        Triple<String, Dog, Integer> triple = new Triple<>("Hello", dog, 42);
//
//        // Вывод объекта Triple на экран
//        System.out.println(triple);
//
//        // Создание другого объекта Triple с типами Integer, Dog и String
//        Triple<Integer, Dog, String> anotherTriple = new Triple<>(1, new Dog("Max"), "World");
//
//        // Вывод другого объекта Triple на экран
//        System.out.println(anotherTriple);
//    }
//}
