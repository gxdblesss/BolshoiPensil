package prac11;

/*Задание 3. (20%)
        Доработайте класс Student предусмотрите поле для хранения даты
        рождения, перепишите метод toString() таким образом, чтобы он разработайте
        метод, возвращал строковое представление даты рождения по вводимому в
        метод формату даты (например, короткий, средний и полный формат даты).*/

import java.text.SimpleDateFormat;
import java.util.Date;

class Student {
    private String name;
    private Date birthDate; // Поле для хранения даты рождения

    public Student(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getBirthDateFormatted(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(birthDate);
    }

    @Override
    public String toString() {
        return "Студент: " + name + ", Дата рождения: " + getBirthDateFormatted("dd-MM-yyyy");
    }
}

 class Assignment3 {
    public static void main(String[] args) {
        Student student = new Student("Алексей Петров", new Date(95, 4, 15)); // 15 мая 1995 года
        System.out.println(student);
        System.out.println("Дата рождения в формате 'YYYY/MM/DD': " + student.getBirthDateFormatted("yyyy/MM/dd"));
    }
}

