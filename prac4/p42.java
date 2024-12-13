package prac4;

/*Создать класс Person, который содержит: a) поля fullName, age. б)
методы move() и talk(), в которых просто вывести на консоль сообщение -"Такойто Person говорит". в) Добавьте два конструктора - Person() и Person(fullName,
age). Создайте два объекта этого класса. Один объект инициализируется
конструктором Person(), другой - Person(fullName, age)*/

// Абстрактный класс Person
abstract class Person {
    protected String fullName;
    protected int age;

    // Абстрактные методы
    public abstract void move();
    public abstract void talk();

    // Конструктор по умолчанию
    public Person() {
        this.fullName = "Unknown";
        this.age = 0;
    }

    // Конструктор с параметрами
    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
}

// Конкретный класс Employee, наследующий абстрактный класс Person
class Employee extends Person {
    // Конструктор по умолчанию
    public Employee() {
        super();  // Вызов конструктора родительского класса
    }

    // Конструктор с параметрами
    public Employee(String fullName, int age) {
        super(fullName, age);  // Вызов конструктора родительского класса с параметрами
    }

    // Реализация метода move()
    @Override
    public void move() {
        System.out.println(fullName + " is moving.");
    }

    // Реализация метода talk()
    @Override
    public void talk() {
        System.out.println(fullName + " says: 'Hello!'");
    }
}

// Основной класс для тестирования
public class p42 {
    public static void main(String[] args) {
        // Создание объекта с конструктором по умолчанию
        Employee employee1 = new Employee();
        employee1.move();  // Вывод: Unknown is moving.
        employee1.talk();  // Вывод: Unknown says: 'Hello!'

        // Создание объекта с конструктором с параметрами
        Employee employee2 = new Employee("John Doe", 30);
        employee2.move();  // Вывод: John Doe is moving.
        employee2.talk();  // Вывод: John Doe says: 'Hello!'
    }
}

