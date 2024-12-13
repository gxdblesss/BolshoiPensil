package prac13;

/*Задание 2. (5%) Разработать класс Person, в котором имеется функция,
возвращающая Фамилию И.О. Функция должна учитывать возможность
отсутствия значений в полях Имя и Отчество. Программу оптимизировать с
точки зрения быстродействия.*/

 class Person {
    private String lastName; // Фамилия
    private String firstName; // Имя
    private String middleName; // Отчество

    // Конструктор класса
    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Метод для получения Фамилии И.О.
    public String getFullName() {
        StringBuilder fullName = new StringBuilder(lastName); // Начинаем с фамилии

        // Добавляем инициал имени, если оно не пустое
        if (firstName != null && !firstName.isEmpty()) {
            fullName.append(" ").append(firstName.charAt(0)).append(".");
        }

        // Добавляем инициал отчества, если оно не пустое
        if (middleName != null && !middleName.isEmpty()) {
            fullName.append(" ").append(middleName.charAt(0)).append(".");
        }

        return fullName.toString(); // Возвращаем итоговую строку
    }

    // Методы доступа (геттеры) для полей
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    // Пример использования
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        Person person2 = new Person("Петров", "Петр", null);
        Person person3 = new Person("Сидоров", null, "Сидорович");
        Person person4 = new Person("Кузнецов", null, null);

        System.out.println(person1.getFullName()); // Вывод: Иванов И.И.
        System.out.println(person2.getFullName()); // Вывод: Петров П.
        System.out.println(person3.getFullName()); // Вывод: Сидоров С.
        System.out.println(person4.getFullName()); // Вывод: Кузнецов
    }
}


