package prac13;

/*Задание 3. (15%) Доработать класс адреса, который из полученной строки
        формата “Страна[d] Регион[d] Город[d] Улица[d] Дом[d] Корпус[d] Квартира”
        ([d] – разделитель, например, «запятая») выбирает соответствующие части и
        записывает их в соответствующие поля класса Address. Учесть, что в начале и
        конце разобранной части адреса не должно быть пробелов. Все поля адреса
        строковые. Разработать проверочный класс не менее чем на четыре адресных
        строки. В программе предусмотреть две реализации этого метода:
        а) разделитель – только запятая (использовать метод split()); Внимание, при
        разработке нужно учесть, что
        б) разделитель – любой из символов ‘,’ ‘.’ ‘;’ - (класс StringTokenizer8
        ).*/
import java.util.StringTokenizer;

 class Address {
    private String country;  // Страна
    private String region;   // Регион
    private String city;     // Город
    private String street;   // Улица
    private String house;     // Дом
    private String building;  // Корпус
    private String apartment; // Квартира

    // Метод для разбора адреса с использованием split()
    public void parseAddressWithSplit(String address) {
        // Разделяем строку по запятой
        String[] parts = address.split(",");

        // Проверяем и присваиваем значения, убирая пробелы
        if (parts.length > 0) this.country = parts[0].trim();
        if (parts.length > 1) this.region = parts[1].trim();
        if (parts.length > 2) this.city = parts[2].trim();
        if (parts.length > 3) this.street = parts[3].trim();
        if (parts.length > 4) this.house = parts[4].trim();
        if (parts.length > 5) this.building = parts[5].trim();
        if (parts.length > 6) this.apartment = parts[6].trim();
    }

    // Метод для разбора адреса с использованием StringTokenizer
    public void parseAddressWithTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;");

        // Проверяем и присваиваем значения, убирая пробелы
        if (tokenizer.hasMoreTokens()) this.country = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.region = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.city = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.street = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.house = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.building = tokenizer.nextToken().trim();
        if (tokenizer.hasMoreTokens()) this.apartment = tokenizer.nextToken().trim();
    }

    // Печать адреса
    public void printAddress() {
        System.out.println("Страна: " + country);
        System.out.println("Регион: " + region);
        System.out.println("Город: " + city);
        System.out.println("Улица: " + street);
        System.out.println("Дом: " + house);
        System.out.println("Корпус: " + building);
        System.out.println("Квартира: " + apartment);
        System.out.println("-------------------------------");
    }

    // Пример использования
    public static void main(String[] args) {
        String[] addresses = {
                "Россия, Москва, Москва, Тверская, 10, 1, 5",
                "США, Калифорния, Лос-Анджелес, Холливуд, 123, 2, 34",
                "Франция, Иль-де-Франс, Париж, Шанз-Элизе, 45, 3, 12",
                "Германия, Бавария, Мюнхен, Мариенплац, 7, 4, 56"
        };

        Address address = new Address();

        System.out.println("Разбор с использованием split():");
        for (String addr : addresses) {
            address.parseAddressWithSplit(addr);
            address.printAddress();
        }

        System.out.println("Разбор с использованием StringTokenizer:");
        for (String addr : addresses) {
            address.parseAddressWithTokenizer(addr);
            address.printAddress();
        }
    }
}


