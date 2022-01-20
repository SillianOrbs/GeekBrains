package home_work;

public class HomeTaskLesson2New {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(Task1(45, 2));
        System.out.println();

        System.out.println("Task 2");
        System.out.println("for -5 :");
        Task2(-5);
        System.out.println("for 78 :");
        Task2(78);
        System.out.println();


        System.out.println("Task 3");
        System.out.println("for -5 :");
        System.out.println(Task3(-5));
        System.out.println("for 78 :");
        System.out.println(Task3(78));
        System.out.println();

        System.out.println("Task 4");
        Task4("Hello, wold!", 10);
        System.out.println();

        System.out.println("Task 5");
        System.out.println("for 400 :");
        Task5(400);
        System.out.println("for 300 :");
        Task5(300);
        System.out.println("for 304 :");
        Task5(304);
        System.out.println();
    }

    public static boolean Task1(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20)
            return true;
        return false;
    }

    public static void Task2(int a){
        if (a >= 0)
            System.out.println("положительное");
        else
            System.out.println("отрицательное");
    }

    public static boolean Task3(int a){
        if (a < 0)
            return true;
        return false;
    }

    public static void Task4(String str, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static void Task5(int year) {
        if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0))
            System.out.println("Является високосным");
        else
            System.out.println("Не является високосным");
    }
}
