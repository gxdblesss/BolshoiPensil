package prac1;

public class Task15{
    public static void main(String[] args) {
        System.out.println("Аргументы командной строки:");

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
        }
    }
}

//конфигурация

// cd ~/IdeaProjects/BolshoiPensil/prac1