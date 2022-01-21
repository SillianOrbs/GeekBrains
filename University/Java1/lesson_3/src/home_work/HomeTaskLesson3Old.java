package home_work;

import java.util.Scanner;

public class HomeTaskLesson3Old {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Task 1");
        Task1();
        System.out.println();

        System.out.println("Task 2");
        Task2();
        System.out.println();
    }

    public static void Task1() {
        while (true) {
            int number = (int) (Math.random() * 10);

            for (int i = 0; i < 3; i++) {
                System.out.print("Введите предпологаемое число: ");
                int num = sc.nextInt();
                if (num == number) {
                    System.out.println("Ураааа!!! Победа!!!");
                    break;
                } else if (num > number)
                    System.out.println("Возможно загаданное число поменьше...");
                else
                    System.out.println("Возможно загаданное число побольше...");
            }
            System.out.print("Повторить игру ещё раз? 1 – да / 0 – нет     ");
            int answer = sc.nextInt();
            if (answer == 0)
                break;
        }
    }

    public static void Task2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String myWord = words[(int)(Math.random()*words.length)];

        while (true) {
            System.out.print("Введите слово:   ");
            String word = sc.next();
            if (myWord.equals(word)){
                System.out.println("Именно то что я задумал!");
                break;
            } else {
                int length = Math.min(myWord.length(), word.length());
                StringBuffer help = new StringBuffer();
                boolean isHelp = false;
                for (int i = 0; i < length; i++) {
                    if (word.charAt(i) == myWord.charAt(i)) {
                        help.append(word.charAt(i));
                        isHelp = true;
                    } else
                        help.append("#");
                }
                if (isHelp) {
                    for (int i = length; i < 15; i++) {
                        help.append("#");
                    }
                    System.out.println("Ну... Это было близко:      " + help);
                } else {
                    System.out.println("Совсем не близко...");
                }
            }
        }
    }
}
