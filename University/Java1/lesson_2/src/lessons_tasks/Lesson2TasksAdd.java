package lessons_tasks;

/**
 * Дополнительное задание к уроку (самый корнец файла "Задачи на уроках")
 */
public class Lesson2TasksAdd {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Task1();
        System.out.println();

        System.out.println("Task 2");
        Task2();
        System.out.println();

        System.out.println("Task 3");
        Task3();
        System.out.println();

        System.out.println("Task 4");
        Task4();
        System.out.println();

        System.out.println("Task 5");
        Task5();
        System.out.println();

        System.out.println("Task 6");
        Task6();
        System.out.println();

    }

    public static void Task1(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 5 || i == 0 || j == 5 || j == 0)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void Task2() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 5 || j == 0 || i == j)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void Task3() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ( i == 5 || j == 0 || i == j)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void Task4(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 4 && i > 1 && j < 4 && j > 1)
                    System.out.print("   ");
                else
                    System.out.print("*  ");
            }
            System.out.println();
        }
    }

    public static void Task5(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i > 3 && j < 2) || (j > 3 && i < 2))
                    System.out.print("   ");
                else
                    System.out.print("*  ");
            }
            System.out.println();
        }
    }

    public static void Task6() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || j == 5 || i == j)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
