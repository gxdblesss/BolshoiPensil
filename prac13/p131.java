package prac13;



/*1. Напишите метод, который принимает в качестве параметра любую
строку, например “I like Java!!!”.
        2. Распечатать последний символ строки. Используем метод
String.charAt().
        3. Проверить, заканчивается ли ваша строка подстрокой “!!!”.
Используем метод String.endsWith().
        4. Проверить, начинается ли ваша строка подстрокой “I like”.
Используем метод String.startsWith().
        5. Проверить, содержит ли ваша строка подстроку “Java”. Используем
метод String.contains().
        6. Найти позицию подстроки “Java” в строке “I like Java!!!”.
        7. Заменить все символы “а” на “о”.
        8. Преобразуйте строку к верхнему регистру.
9. Преобразуйте строку к нижнему регистру.
10. Вырезать строку Java c помощью метода String.substring().*/;


class StringManipulation {
    public static void main(String[] args) {
        // 1. Объявляем строку
        String str = "I like Java!!!";

        // 2. Распечатать последний символ строки
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Последний символ строки: " + lastChar);

        // 3. Проверить, заканчивается ли строка подстрокой "!!!"
        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Строка заканчивается на '!!!': " + endsWithExclamation);

        // 4. Проверить, начинается ли строка подстрокой "I like"
        boolean startsWithILike = str.startsWith("I like");
        System.out.println("Строка начинается с 'I like': " + startsWithILike);

        // 5. Проверить, содержит ли строка подстроку "Java"
        boolean containsJava = str.contains("Java");
        System.out.println("Строка содержит 'Java': " + containsJava);

        // 6. Найти позицию подстроки "Java" в строке
        int javaPosition = str.indexOf("Java");
        System.out.println("Позиция подстроки 'Java': " + javaPosition);

        // 7. Заменить все символы "а" на "о"
        String replacedString = str.replace('а', 'о');
        System.out.println("Строка после замены 'а' на 'о': " + replacedString);

        // 8. Преобразовать строку к верхнему регистру
        String upperCaseString = str.toUpperCase();
        System.out.println("Строка в верхнем регистре: " + upperCaseString);

        // 9. Преобразовать строку к нижнему регистру
        String lowerCaseString = str.toLowerCase();
        System.out.println("Строка в нижнем регистре: " + lowerCaseString);

        // 10. Вырезать строку "Java" с помощью метода String.substring()
        String substringJava = str.substring(javaPosition, javaPosition + "Java".length());
        System.out.println("Вырезанная подстрока 'Java': " + substringJava);
    }
}

