package home_work;


public class HomeTaskLesson2Old {
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
        System.out.println(Task6(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(Task6(new int[] {1, 1, 1, 2, 1}));
        System.out.println(Task6(new int[] {1, 1, 1, 2}));
        System.out.println();

        System.out.println("Task 7");
        Task7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        Task7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -3);
        System.out.println();
    }

    public static void Task1() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Start array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }

        System.out.println("New array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static void Task2() {
        int[] array = new int[8];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static void Task3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Start array:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5)
                //чтобы при умножении они былм ровно и не смещались
                System.out.print("  " + array[i]);
            else
                System.out.print(" " + array[i]);
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }

        System.out.println("New array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static void Task4(){
        int[][] array = new int[6][6];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j + i == 5)
                    array[i][j] = 1;
            }
        }

        System.out.println("New array");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Task5(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            else if (array[i] < min)
                min = array[i];
        }

        System.out.println("Array :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Min number = " + min);
        System.out.println("Max number = " + max);
    }

    public static boolean Task6(int[] array){
        System.out.println("Start array");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < array.length; i++) {
            int summ1 = 0;
            for (int j = 0; j < i; j++) {
                summ1 += array[j];
            }
            int summ2 = 0;
            for (int j = i; j < array.length; j++) {
                summ2 += array[j];
            }
            if (summ1 == summ2)
                return true;
        }
        return false;
    }

    public static void Task7(int[] array, int n){
        System.out.println("Start array :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        if (n < 0) {
            n *= -1;
            for (int i = 0; i < n; i++) {
                int buf = array[array.length - 1];
                for (int j = array.length - 2; j >= 0; j--) {
                    array[j + 1] = array[j];
                }
                array[0] = buf;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int buf = array[0];
                for (int j = 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 1] = buf;
            }
        }

        System.out.println("New array :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
