package prac10;
/*Создать свой класс Student со всеми переменными экземпляра,
конструктором, включающим все переменные, предпочтительно использовать
79
геттеры и сеттеры для каждой переменной. Класс студент имеет свойства: Имя,
Фамилия, Специальность, Курс, Группа
Задание 2. (45%)
Напишите класс SortingStudentsByGPA (может у вас называться Tester
        или Main, так как содержит функцию main()) создайте поле как массив
объектов Student с названием iDNumber, вы можете использовать как массив,
так и и ArrayList или TreeSet для хранения данных о студентах
Добавьте методы класса: 1) заполнения массива setArray() 2) метод для
сортировки по среднему баллу студентов quicksort() который реализует
интерфейс Comparator таким образом, чтобы он сортировал студентов с их
итоговым баллом в порядке убывания. В качестве алгоритма сортировки
использовать методы сортировок: слиянием и быструю сортировку (добавьте в
класс еще один метод). 3)метод для вывода массива студентов outArray()
4)Добавьте в класс возможность сортировать список студентов по другому полю
Задание 3. (50%)
        Напишите программу, которая объединяет два списка данных о студентах
в один отсортированный списках.*/






import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Класс, представляющий студента
class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;
    private double gpa;

    // Конструктор
    public Student(String firstName, String lastName, String major, int year, String group, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
        this.gpa = gpa;
    }

    // Геттеры и сеттеры
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student{firstName='%s', lastName='%s', major='%s', year=%d, group='%s', gpa=%.2f}",
                firstName, lastName, major, year, group, gpa);
    }
}

// Класс для сортировки студентов по GPA
class SortingStudentsByGPA {
    Student[] students;

    public SortingStudentsByGPA(int size) {
        students = new Student[size];
    }

    // Метод для заполнения массива студентов
    public void setArray() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Major: ");
            String major = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Group: ");
            String group = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            students[i] = new Student(firstName, lastName, major, year, group, gpa);
        }
    }

    // Метод для вывода массива студентов
    public void outArray() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Метод для быстрой сортировки по GPA
    public void quickSort(Comparator<Student> comparator) {
        quickSort(students, 0, students.length - 1, comparator);
    }

    private void quickSort(Student[] students, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pivotIndex = partition(students, low, high, comparator);
            quickSort(students, low, pivotIndex - 1, comparator);
            quickSort(students, pivotIndex + 1, high, comparator);
        }
    }

    private int partition(Student[] students, int low, int high, Comparator<Student> comparator) {
        Student pivot = students[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(students[j], pivot) <= 0) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1; // Возвращаем индекс опорного элемента
    }

    // Метод для сортировки студентов по GPA (в порядке убывания)
    public static class SortingByGPA implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getGpa(), s1.getGpa()); // Убывание
        }
    }

    // Метод для сортировки слиянием
    public void mergeSort(Comparator<Student> comparator) {
        mergeSort(students, 0, students.length - 1, comparator);
    }

    private void mergeSort(Student[] students, int left, int right, Comparator<Student> comparator) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(students, left, mid, comparator);
            mergeSort(students, mid + 1, right, comparator);
            merge(students, left, mid, right, comparator);
        }
    }

    private void merge(Student[] students, int left, int mid, int right, Comparator<Student> comparator) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = students[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = students[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (comparator.compare(L[i], R[j]) <= 0) {
                students[k] = L[i];
                i++;
            } else {
                students[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            students[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            students[k] = R[j];
            j++;
            k++;
        }
    }

    // Метод для сортировки по фамилии
    public static class SortingByLastName implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getLastName().compareTo(s2.getLastName()); // По возрастанию
        }
    }

    // Метод для объединения двух массивов студентов
    public static Student[] mergeStudentArrays(Student[] array1, Student[] array2, Comparator<Student> comparator) {
        Student[] merged = new Student[array1.length + array2.length];
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);

        Arrays.sort(merged, comparator);
        return merged;
    }
}

// Основной класс для тестирования
public class p101 {
    public static void main(String[] args) {
        // Создаем два массива студентов
        SortingStudentsByGPA groupA = new SortingStudentsByGPA(3);
        SortingStudentsByGPA groupB = new SortingStudentsByGPA(3);

        // Заполнение первого массива студентов
        System.out.println("Enter details for Group A:");
        groupA.setArray();

        // Заполнение второго массива студентов
        System.out.println("Enter details for Group B:");
        groupB.setArray();

        // Сортируем студентов по GPA
        System.out.println("\nSorting Group A by GPA:");
        groupA.quickSort(new SortingStudentsByGPA.SortingByGPA());
        groupA.outArray();

        System.out.println("\nSorting Group B by GPA:");
        groupB.quickSort(new SortingStudentsByGPA.SortingByGPA());
        groupB.outArray();

        // Объединение двух групп студентов
        Student[] mergedStudents = SortingStudentsByGPA.mergeStudentArrays(
                groupA.students, groupB.students, new SortingStudentsByGPA.SortingByGPA()
        );

        System.out.println("\nMerged and Sorted Students by GPA:");
        for (Student student : mergedStudents) {
            System.out.println(student);
        }

        // Сортировка по фамилии
        System.out.println("\nSorting Merged Students by Last Name:");
        Arrays.sort(mergedStudents, new SortingStudentsByGPA.SortingByLastName());
        for (Student student : mergedStudents) {
            System.out.println(student);
        }
    }
}