package prac9;

import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        // Сравнение по возрасту
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class p91 {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 30);

        // Демонстрация полиморфизма: объекты сравниваются через общий интерфейс Comparable
        System.out.println(person1.compareTo(person2)); // > 0, так как 30 > 25
        System.out.println(person1.compareTo(person3)); // == 0, так как 30 == 30
        System.out.println(person2.compareTo(person3)); // < 0, так как 25 < 30

        // Пример сортировки массива объектов
        Person[] people = {person1, person2, person3};
        Arrays.sort(people);
        System.out.println(Arrays.toString(people)); // Сортировка по возрасту
    }
}