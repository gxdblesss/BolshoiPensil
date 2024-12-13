//package prac20;
//
////Класс содержит три переменные типа (T, V, K), конструктор,
////принимающий на вход параметры типа (T, V, K), методы возвращающие
////значения трех переменных. Создать метод, выводящий на консоль имена
////классов для трех переменных класса.
//
// class Triple<T, V, K> {
//    // Поля класса
//    private T first;
//    private V second;
//    private K third;
//
//    // Конструктор, принимающий параметры типа T, V и K
//    public Triple(T first, V second, K third) {
//        this.first = first;
//        this.second = second;
//        this.third = third;
//    }
//
//    // Методы для получения значений переменных
//    public T getFirst() {
//        return first;
//    }
//
//    public V getSecond() {
//        return second;
//    }
//
//    public K getThird() {
//        return third;
//    }
//
//    // Метод для вывода имен классов переменных на консоль
//    public void printClassNames() {
//        System.out.println("Class of T: " + first.getClass().getName());
//        System.out.println("Class of V: " + second.getClass().getName());
//        System.out.println("Class of K: " + third.getClass().getName());
//    }
//
//    // Главный метод для тестирования класса
//    public static void main(String[] args) {
//        // Создание объекта Triple с типами String, Integer и Boolean
//        Triple<String, Integer, Boolean> triple = new Triple<>("Hello", 42, true);
//
//        // Вывод значений переменных
//        System.out.println("First: " + triple.getFirst());
//        System.out.println("Second: " + triple.getSecond());
//        System.out.println("Third: " + triple.getThird());
//
//        // Вывод имен классов переменных
//        triple.printClassNames();
//    }
//}