package prac9;

/*Напишите класс SortingStudentsByGPA который реализует
        интерфейс Comparator таким образом, чтобы сортировать список студентов по их
        итоговым баллам в порядке убывания с использованием алгоритма быстрой
        сортировки.
        package Practic_works.Prac1;*/

import java.util.Arrays;
import java.util.Comparator;

// Класс, представляющий студента
class student {
    private String name;
    private double gpa;

    public student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
}

// Класс, реализующий Comparator для сортировки студентов по GPA
class SortingStudentsByGPA implements Comparator<student> {
    @Override
    public int compare(student s1, student s2) {
        // Сравниваем GPA студентов в порядке убывания
        return Double.compare(s2.getGpa(), s1.getGpa()); // s2 перед s1 для убывания
    }
}

// Класс для реализации быстрой сортировки
class QuickSort {
    public static void quickSort(student[] students, Comparator<student> comparator) {
        quickSort(students, 0, students.length - 1, comparator);
    }

    private static void quickSort(student[] students, int low, int high, Comparator<student> comparator) {
        if (low < high) {
            // Индекс разделителя
            int pivotIndex = partition(students, low, high, comparator);
            // Рекурсивная сортировка по обеим частям
            quickSort(students, low, pivotIndex - 1, comparator);
            quickSort(students, pivotIndex + 1, high, comparator);
        }
    }

    private static int partition(student[] students, int low, int high, Comparator<student> comparator) {
        student pivot = students[high]; // Берем последний элемент в качестве опорного
        int i = (low - 1); // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (comparator.compare(students[j], pivot) <= 0) {
                i++;
                // Меняем местами
                student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        // Меняем местами опорный элемент с элементом после последнего меньшего
        student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1; // Возвращаем индекс опорного элемента
    }
}

// Основной класс для тестирования
public class p93 {
    public static void main(String[] args) {
        student[] students = {
                new student("Alice", 3.5),
                new student("Bob", 3.8),
                new student("Charlie", 2.9),
                new student("David", 3.2)
        };

        // Сортируем студентов
        QuickSort.quickSort(students, new SortingStudentsByGPA());

        // Выводим отсортированный список студентов
        System.out.println("Students sorted by GPA (descending):");
        System.out.println(Arrays.toString(students));
    }
}


