package Java1.lesson_1;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("printThreeWords");
        printThreeWords();
        System.out.println();

        System.out.println("checkSumSign");
        checkSumSign();
        System.out.println();

        System.out.println("printColor");
        printColor();
        System.out.println();


    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 1;
        int b = 2;
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor(){
        int value = 15;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");

    }

    public static void compareNumbers(){
        int a = -8, b = 76;

        if(a >=  b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }
}
