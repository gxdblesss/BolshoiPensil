package prac2;

public class ReverseArray {
    public static void main(String[] args) {
        String[] array = {"Первый", "Второй", "Третий", "Четвертый", "Пятый"};


        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }


        for (String element : array) {
            System.out.println(element);
        }
    }
}

