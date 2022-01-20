package Java1.lesson_1;

public class HomeTaskLesson1 {
    public static void main(String[] args) {
        int aInt = 1;
        short aShort = 2;
        long aLong = 3;

        byte aByte = 4;

        float aFloat = 5.7f;
        double aDoub = 6.8;

        boolean aBool = true;

        //String srt = "String";

        System.out.println("Task 3");
        System.out.println(Task3(2,6, 7, 1));
        System.out.println();

        System.out.println("Task 4");
        System.out.println(Task4(3, 7));
        System.out.println();

        System.out.println("Task 5");
        Task5(-8);
        System.out.println();

        System.out.println("Task 6");
        System.out.println(Task6(9));
        System.out.println();


        System.out.println("Task 7");
        Task7("Ная");
        System.out.println();


        System.out.println("Task 8");
        Task8(400);
        Task8(300);
        Task8(304);
        System.out.println();

    }

    public static int Task3(int a, int b , int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean Task4(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20)
            return true;
        return false;
    }

    public static void Task5(int a) {
        if (a >= 0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");
    }

    public static boolean Task6(int a) {
        if (a < 0)
            return true;
        return false;
    }

    public static void Task7(String name){
        System.out.println("Привет, " + name);
    }

    public static void Task8(int year) {
        if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0))
            System.out.println("Является високосным");
        else
            System.out.println("Не является високосным");
    }
}
