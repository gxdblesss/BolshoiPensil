package prac18;

//ЗАДАНИЕ 1
//
//Шаг 1. Выполните следующую программу и посмотрите, что происходит:
//Листинг 18.2 Пример обработки деления на ноль
//public class Exception1 {
//    public void exceptionDemo() {
//        System.out.println( 2 / 0 );
//    }
//}
//Описание работы
//Вам необходимо инстанцировать класс и выполнить exceptionDemo().
//Что произойдет?
//Ответ: программа даст сбой, и вы получите следующее сообщение
//java.lang.ArithmeticException: / by zero at
//Exception1.exceptionDemo(Exception1.java:12)
//Это говорит нам о том, что программа пытается выполнить деление
//        на ноль, который он не в состоянии выполнить.
//Объясните поведение программы.
//
//        РЕАЛИЗАЦИЯ:
//

public class Exception1 {
    public void exceptionDemo() {
        System.out.println(2 / 0);
    }

    public static void main(String[] args) {
        Exception1 obj = new Exception1();
        obj.exceptionDemo();
    }
}

//Ошибки:
//java.lang.ArithmeticException: / by zero
//at Exception1.exceptionDemo(Exception1.java:3)
//at Exception1.main(Exception1.java:7)
//
//комментарии:
//
//Программа пытается выполнить операцию деления целого числа на ноль (2 / 0), что не является допустимой операцией для целых чисел в Java. Это приводит к выбросу исключения ArithmeticException.






//Шаг 2. Измените программу следующим образом.
//Замените 2/0 на 2,0 / 0,0 и повторно вызовите метод. Что произойдет?
//Теперь измените код в классе Exception1 и включите блок try-catch
//следующим образом:
//Листинг 18.3 Пример обработки исключения
 class Exception11 {
    public void exceptionDemo() {
        try{
            System.out.println( 2/0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }
}



//Реализация:

 class Exception12 {
    public void exceptionDemo() {
        System.out.println(2.0 / 0.0);
    }

    public static void main(String[] args) {
        Exception1 obj = new Exception1();
        obj.exceptionDemo();
    }
}

//вывод
//        Infinity
//
//
//Шаг 3. Запустите программу и обратите внимание на новое
//поведение.
//Объясните поведение программы.


 class Exception13 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 obj = new Exception1();
        obj.exceptionDemo();
    }
}

//вывод
//
//Attempted division by zero
