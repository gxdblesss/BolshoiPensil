package prac21;

//...Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).


import java.util.Arrays;

public class p212 {

    public static class GenericArray<T> {

        private T[] array; // Массив для хранения элементов

        // Конструктор для инициализации массива
        public GenericArray(T[] array) {
            this.array = array;
        }

        // Метод для получения элемента по индексу
        public T get(int index) {
            if (index < 0 || index >= array.length) {
                throw new IndexOutOfBoundsException("Индекс вне диапазона!");
            }
            return array[index];
        }

        // Метод для установки элемента по индексу
        public void set(int index, T value) {
            if (index < 0 || index >= array.length) {
                throw new IndexOutOfBoundsException("Индекс вне диапазона!");
            }
            array[index] = value;
        }

        // Метод для получения всего массива
        public T[] getArray() {
            return array;
        }

        // Метод для вывода массива в виде строки
        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }

    public static void main(String[] args) {
        // Пример с массивом строк
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        GenericArray<String> stringGenericArray = new GenericArray<>(stringArray);
        System.out.println("Массив строк: " + stringGenericArray);
        System.out.println("Элемент с индексом 1: " + stringGenericArray.get(1));
        stringGenericArray.set(1, "Blueberry");
        System.out.println("Массив строк после изменения: " + stringGenericArray);

        // Пример с массивом чисел
        Integer[] intArray = {1, 2, 3, 4, 5};
        GenericArray<Integer> intGenericArray = new GenericArray<>(intArray);
        System.out.println("Массив чисел: " + intGenericArray);
        System.out.println("Элемент с индексом 3: " + intGenericArray.get(3));
        intGenericArray.set(3, 42);
        System.out.println("Массив чисел после изменения: " + intGenericArray);
    }
}


