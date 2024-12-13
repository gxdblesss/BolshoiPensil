package prac19;

// Пользовательское исключение для недействительного ИНН
class InvalidInnException extends Exception {
    public InvalidInnException(String message) {
        super(message);
    }
}

// Класс клиента с ФИО и ИНН
class Client {
    private String fullName;
    private String inn;

    public Client(String fullName, String inn) throws InvalidInnException {
        if (!isValidInn(inn)) {
            throw new InvalidInnException("Недействительный ИНН: " + inn);
        }
        this.fullName = fullName;
        this.inn = inn;
    }

    private boolean isValidInn(String inn) {
        // Реализуйте проверку ИНН здесь (например, проверка длины и цифр)
        return inn != null && inn.matches("\\d{10}");
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }
}

// Пример использования
public class p191 {
    public static void main(String[] args) {
        try {
            Client client = new Client("Иван Иванов", "1234567890");
            System.out.println("Клиент создан: " + client.getFullName() + ", ИНН: " + client.getInn());
        } catch (InvalidInnException e) {
            System.err.println(e.getMessage());
        }

        try {
            Client invalidClient = new Client("Петр Петров", "invalidINN");
        } catch (InvalidInnException e) {
            System.err.println(e.getMessage());
        }
    }
}