package home_work;

import java.util.Arrays;

public class HomeTaskLesson3New {
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

        System.out.println("Task 3");
        Task3();
        System.out.println();

        System.out.println("Task 4");
        Task4();
        System.out.println();

        System.out.println("Task 5");
        int[] array5 = Task5(13, 67);
        System.out.println("New array");
        System.out.println(Arrays.toString(array5));
        System.out.println();

        System.out.println("Task 6");
        Task6();
        System.out.println();

        System.out.println("Task 7");
        int[] array7_1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] array7_2 = {2, 2, 2, 1, 2, 2, 10};
        int[] array7_3 = {1, 1, 1, 2, 1};
        System.out.println("For array: " + Arrays.toString(array7_1));
        System.out.println("Result:    " + checkBalance(array7_1));
        System.out.println("For array: " + Arrays.toString(array7_2));
        System.out.println("Result:    " + checkBalance(array7_2));
        System.out.println("For array: " + Arrays.toString(array7_3));
        System.out.println("Result:    " + checkBalance(array7_3));
        System.out.println();

        System.out.println("Task 8");
        int[] array8_1 = {1,2,3,4,5,6,7,8,9,11,23,45};
        int[] array8_2 = {1,2,3,4,5,6,7,8,9,11,23,45};
        System.out.println("Start first array:   " + Arrays.toString(array8_1));
        System.out.println("Phase = -6");
        Task8(array8_1, -6);
        System.out.println("New first array:     " + Arrays.toString(array8_1));
        System.out.println();
        System.out.println("Start second array:   " + Arrays.toString(array8_2));
        System.out.println("Phase = 8");
        Task8(array8_2, 8);
        System.out.println("New second array:     " + Arrays.toString(array8_2));
        System.out.println();
    }

    public static void Task1(){
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Start array");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 :0;
        }
        System.out.println("New array");
        System.out.println(Arrays.toString(array));
    }

    public static void Task2() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("New array");
        System.out.println(Arrays.toString(array));
    }

    public static void Task3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Start array");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }

        System.out.println("New array");
        System.out.println(Arrays.toString(array));
    }

    public static void Task4() {
        int[][] array = new int[11][11];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1)
                    array[i][j] = 1;
                else
                    array[i][j] = 0;
            }
        }

        printArrayDuo(array);
    }

    public static void printArrayDuo(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }


    public static int[] Task5(int len, int initialValue){
        int[] result = new int[len];
        Arrays.fill(result, initialValue);
        return result;
    }

    public static void Task6() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Start array");
        System.out.println(Arrays.toString(array));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            else if(array[i] > max)
                max = array[i];
        }

        System.out.println("MIN value = " + min + "; Max value = " + max);
    }

    public static boolean checkBalance(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum1 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += array[j];
            }
            int sum2 = 0;
            for (int j = i; j < array.length; j++) {
                sum2 += array[j];
            }
            if (sum1 == sum2)
                return true;
        }
        return false;
    }

    public static void Task8(int[] array, int n){
        if(n < 0) {
            n *= -1;
            for (int i = 0; i < n; i++) {
                int buf = array[array.length - 1];
                for (int j = array.length - 2; j >= 0 ; j--) {
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

    }
}
