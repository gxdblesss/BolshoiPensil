package prac11;

/*Задание 1. (20%)
        Написать программу, выводящую фамилию разработчика, дату и время
        получения задания, а также дату и время сдачи задания. Для получения
        последней даты и времени использовать класс Date из пакета java.util.*
        (Объявление Dated=newDate() или метод System.currentTimeMillis().*/

import java.util.Date;
 class Assignment1 {
    public static void main(String[] args) {
        String developerSurname = "Пастернак";
        Date dateReceived = new Date(); // Дата получения задания
        Date dateSubmitted = new Date(); // Дата сдачи задания (в данном случае - текущая дата)

        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + dateReceived);
        System.out.println("Дата и время сдачи задания: " + dateSubmitted);
    }
}
