package prac13;

/*Задание 4. (25%) Реализуйте класс Shirt: Метод toString() выводит
объяснение и значение полей построчно.
Дан также строковый массив: shirts[0] = "S001,Black Polo Shirt,Black,XL";
shirts[1] = "S002,Black Polo Shirt,Black,L"; shirts[2] = "S003,Blue Polo
Shirt,Blue,XL"; shirts[3] = "S004,Blue Polo Shirt,Blue,M"; shirts[4] = "S005,Tan Polo
Shirt,Tan,XL"; shirts[5] = "S006,Black T-Shirt,Black,XL"; shirts[6] = "S007,White TShirt,White,XL"; shirts[7] = "S008,White T-Shirt,White,L"; shirts[8] = "S009,Green
T-Shirt,Green,S"; shirts[9] = "S010,Orange T-Shirt,Orange,S"; shirts[10] =
        "S011,Maroon Polo Shirt,Maroon,S";
Преобразуйте строковый массив в массив класса Shirt и выведите его на
консоль.*/


class Shirt {
    // Поля класса Shirt
    private String id;          // Идентификатор футболки
    private String name;        // Название футболки
    private String color;       // Цвет футболки
    private String size;        // Размер футболки

    // Конструктор класса Shirt
    public Shirt(String id, String name, String color, String size) {
        this.id = id;           // Инициализация идентификатора
        this.name = name;       // Инициализация названия
        this.color = color;     // Инициализация цвета
        this.size = size;       // Инициализация размера
    }

    // Метод toString - возвращает строковое представление объекта Shirt
    @Override
    public String toString() {
        // Формируем строку, содержащую информацию о футболке
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");          // Добавляем ID
        sb.append("Название: ").append(name).append("\n");  // Добавляем название
        sb.append("Цвет: ").append(color).append("\n");     // Добавляем цвет
        sb.append("Размер: ").append(size).append("\n");     // Добавляем размер
        return sb.toString(); // Возвращаем итоговую строку
    }

    // Метод main для тестирования класса Shirt
    public static void main(String[] args) {
        // Исходный массив строк, представляющих футболки
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        // Создаем массив объектов Shirt того же размера, что и массив строк
        Shirt[] shirtArray = new Shirt[shirts.length];

        // Перебираем массив строк и заполняем массив объектов Shirt
        for (int i = 0; i < shirts.length; i++) {
            // Разделяем каждую строку на части по запятой
            String[] shirtDetails = shirts[i].split(",");

            // Создаем новый объект Shirt и заполняем его данными
            shirtArray[i] = new Shirt(shirtDetails[0], shirtDetails[1], shirtDetails[2], shirtDetails[3]);
        }

        // Выводим информацию о каждой футболке на консоль
        for (Shirt shirt : shirtArray) {
            System.out.println(shirt); // Вызываем метод toString() для вывода информации
            System.out.println("----------------------------------"); // Разделитель между футболками
        }
    }
}


