package prac3;

/*1. Создайте объекты класса Double, используя методы valueOf().
        2. Преобразовать значение типа String к типу double. Используем
метод Double.parseDouble().
        3. Преобразовать объект класса Double ко всем примитивным типам.
        4. Вывести значение объекта Double на консоль.
        5. Преобразовать литерал типа double к строке: String d =
        Double.toString(3.14);*/


public class p34 {

    public static void main(String[] args) {

        // 1. Создание объектов класса Double с использованием метода valueOf()
        Double doubleObj1 = Double.valueOf(3.14); // Из значения типа double
        Double doubleObj2 = Double.valueOf("2.718"); // Из строки

        System.out.println("Объект Double (3.14): " + doubleObj1);
        System.out.println("Объект Double (\"2.718\"): " + doubleObj2);

        // 2. Преобразование значения типа String к типу double
        String str = "42.195";
        double parsedDouble = Double.parseDouble(str);
        System.out.println("Преобразованное значение String \"" + str + "\" к double: " + parsedDouble);

        // 3. Преобразование объекта класса Double ко всем примитивным типам
        Double doubleObj = Double.valueOf(99.99); // Создаем объект Double

        byte byteValue = doubleObj.byteValue();
        short shortValue = doubleObj.shortValue();
        int intValue = doubleObj.intValue();
        long longValue = doubleObj.longValue();
        float floatValue = doubleObj.floatValue();
        double doubleValue = doubleObj.doubleValue();

        System.out.println("Преобразование объекта Double ко всем примитивным типам:");
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);

        // 4. Вывод значения объекта Double на консоль
        System.out.println("Значение объекта Double: " + doubleObj);

        // 5. Преобразование литерала типа double к строке
        String doubleAsString = Double.toString(3.14);
        System.out.println("Преобразование double 3.14 к строке: " + doubleAsString);
    }
}
