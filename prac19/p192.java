package prac19;

import java.util.Arrays;
import java.util.Comparator;

// Пользовательское исключение для отсутствующего студента
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Интерфейс для студента
interface Student {
    String getFullName();
    double getAverageGrade();
}

// Реализация студента
class StudentImpl implements Student {
    private String fullName;
    private double averageGrade;

    public StudentImpl(String fullName, double averageGrade) {
        this.fullName = fullName;
        this.averageGrade = averageGrade;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}

// Класс для управления студентами
class StudentManager {
    private Student[] students;

    public StudentManager(Student[] students) {
        this.students = students;
    }

    public void sortStudentsByAverageGrade() {
        Arrays.sort(students, Comparator.comparingDouble(Student::getAverageGrade).reversed());
    }

    public Student findStudentByFullName(String fullName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с ФИО " + fullName + " не найден.");
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Пример использования
public class p192 {
    public static void main(String[] args) {
        Student[] students = {
                new StudentImpl("Иван Иванов", 4.5),
                new StudentImpl("Мария Петрова", 3.7),
                new StudentImpl("Алексей Сидоров", 4.8)
        };

        StudentManager manager = new StudentManager(students);

        System.out.println("Студенты до сортировки:");
        manager.printStudents();

        manager.sortStudentsByAverageGrade();
        System.out.println("\nСтуденты после сортировки по среднему баллу:");
        manager.printStudents();

        try {
            Student foundStudent = manager.findStudentByFullName("Мария Петрова");
            System.out.println("\nНайденный студент: " + foundStudent);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            Student notFoundStudent = manager.findStudentByFullName("Неизвестный Студент");
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}