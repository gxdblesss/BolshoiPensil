package prac21;

//...Реализовать метод, который возвращает любой элемент
//массива по индексу.


public class p213 {

    // Универсальный метод для возврата элемента массива по индексу
    public static <T> T getElementByIndex(T[] array, int index) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона!");
        }
        return array[index];
    }

    public static void main(String[] args) {
        // Пример с массивом строк
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        System.out.println("Элемент с индексом 1: " + getElementByIndex(stringArray, 1)); // Banana

        // Пример с массивом чисел
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Элемент с индексом 3: " + getElementByIndex(intArray, 3)); // 4

        // Пример с массивом объектов
        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Элемент с индексом 0: " + getElementByIndex(doubleArray, 0)); // 1.1

        // Пример с некорректным индексом
        try {
            System.out.println(getElementByIndex(intArray, 10)); // Ошибка!
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


