package home_tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * тут поменяла x и y местами (в самом массиве), т.к. путает эта перестановка,
 * да и оси x, y в математике за другие оси отвечают, а так и более понятнее и логичнее
 * ну и пусть что поидее ось y в минус уходит =)
 */
public class HomeTaskLesson4 {
    public static char[][] map;
    public static int SIZE;     // = 3;
    public static int WIN_NUMBER;       // = 3;
    public static final char EMPTY_DOT = '*';
    public static final char HUMAN_DOT = 'X';
    public static final char BOT_DOT = 'O';
    public static final Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static final String ANSI_YELLOW = "\u001B[33m";  // вывод побидителя
    public static final String ANSI_GREEN = "\u001B[32m";   // для вывода ходов игрока
    public static final String ANSI_RED = "\u001B[31m";     // для выводв ходов компьютера
    public static final String ANSI_PURPLE = "\u001B[35m";  // для вывода пустых значений
    public static final String ANSI_BLUE = "\u001B[34m";    // для вывода нового хода
    public static final String ANSI_RESET = "\u001B[0m";    // возвращение цвета назад


    public static void main(String[] args) {
        initMap();
        printMap();
        boolean result;
        do {
            result = turnHuman();
            if (result)
                break;
            result = turnBot();
            if (result)
                break;
        } while (true);
        System.out.println();
        System.out.println("Спасибо за игру!");
    }

    public static void initMap() {
        System.out.println("Настройка игрового поля:");
        do {
            System.out.print("Введите размер игровой карты " + ANSI_YELLOW
                    + "(карта должна быть рамером не меньше 3 и не больше 9): " + ANSI_RESET);
            SIZE = sc.nextInt();
            if (SIZE >= 3 && SIZE <= 9)
                break;
            else
                System.out.println("Вы ввели некорректный формат...");
        } while (true);
        do {
            System.out.print("Введите комбо для выгирыша " + ANSI_YELLOW
                    + "(комбо не должно быть меньше 3х и не должно привышать размера карты): " + ANSI_RESET);
            WIN_NUMBER = sc.nextInt();
            if (WIN_NUMBER >= 3 && WIN_NUMBER <= SIZE)
                break;
            else
                System.out.println("Вы ввели некорректный формат...");
        } while (true);
        System.out.println("Настройка игры завершена");
        System.out.println("Приятной игры!");
        System.out.println();

        map = new char[SIZE][SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, EMPTY_DOT);
        }
    }

    /**
     * отрисовка карты игры
     */
    public static void printMap(){
        printMap(-1, -1);
    }

    /**
     * отрисовка карты игры с подсветкой последнего хода
     * @param x - координа x последнего хода
     * @param y - координа y последнего хода
     */
    public static void printMap(int x, int y){
        System.out.println("Состояние поля:");
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0)
                System.out.print("  ");
            else
                System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                /*В зависимости от метки подсвечиваем её цветом,
                если вам это не нужно можно выводить просто символ следующим методом:
                        System.out.print(map[i][j] + " ");
                Без каких либо условий в блоке данного цикла
                */
                if (i == x && j == y)
                    //Для нового хода(будь это робот или человек) - голубая подсветка
                    System.out.print(ANSI_BLUE + map[i][j] + ANSI_RESET + " ");
                else if (map[i][j] == EMPTY_DOT)
                    //Для пустых ячекк - фиолетовая подсветка
                    System.out.print(ANSI_PURPLE + map[i][j] + ANSI_RESET + " ");
                else if (map[i][j] == HUMAN_DOT)
                    //Для ранних ходов человека(если это не новый ход) - зеленая подсветка
                    System.out.print(ANSI_GREEN + map[i][j] + ANSI_RESET + " ");
                else if (map[i][j] == BOT_DOT)
                    //Для ранних ходов комьютера(если это не новый ход) - красная подсветка
                    System.out.print(ANSI_RED + map[i][j] + ANSI_RESET + " ");
            }
            System.out.println();
        }
    }

    /**
     * Ход человека
     */
    public static boolean turnHuman() {
        int x, y;
        do {
            System.out.print("Введите координаты входа в формате 'x y' (сначала строка, потом столбец): ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isNotValidCeil(x, y, true));
        map[x][y] = HUMAN_DOT;

        printMap(x, y);
        return checkMap(HUMAN_DOT);
    }

    /**
     * Проверяет на валидность потенциальной ячейки на заполнение, так же для пользователя выводит подсказки
     * @param x - координа x потенциально хода
     * @param y - координа y потенциально хода
     * @param isHuman - ходит человек или нет
     * @return - возможно ли заполнить данную точку в поле
     */
    public static boolean isNotValidCeil(int x, int y, boolean isHuman){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            //если это ход человека высвечиваем подсказку, что не так в ходе
            if (isHuman)
                System.out.println("!  Неправильный диапазон значений для x/y." +
                        "Введите корректное значение, оно должно быть в диапазоне " +
                        "[1, " + SIZE + "] - включая границы.");
            return true;
        }
        //если это ход человека высвечиваем подсказку, что не так в ходе
        if (isHuman) {
            if (map[x][y] != EMPTY_DOT) {
                System.out.println("Данная точка к сожалению занята, попробуйте другу.");
                return true;
            }
            return false;
        }
        return map[x][y] != EMPTY_DOT;
    }

    /**
     * Ход бота
     */
    public static boolean turnBot() {
        int x, y;
        int[] tern = createTurn();
        x = tern[0];
        y = tern[1];
        boolean isNotCreate = false;
        if (x == -1 || y == -1) {
            isNotCreate = true;
        }
        do {
            if (isNotCreate) {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        } while (isNotValidCeil(x, y, false));
        map[x][y] = BOT_DOT;

        System.out.println("Ход компьютера в точку: " + ANSI_RED + x + " " + y + ANSI_RESET);
        printMap(x, y);
        return checkMap(BOT_DOT);
    }

    /**
     * Проверяет выиграл ли игрок (его марку мы передаем)
     */
    public static boolean checkWin(char mark) {
        //сначала проверяем по вертикали
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == mark)
                    count++;
                else
                    count = 0;
                if (count == WIN_NUMBER)
                    return true;
            }
        }
        //потом по горизонтали
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == mark)
                    count++;
                else
                    count = 0;
                if (count == WIN_NUMBER)
                    return true;
            }
        }
        //потом по диагонали - с левого верхнего угла на правый нижний
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == mark)
                        count++;
                    else
                        count = 0;
                    if (count == WIN_NUMBER)
                        return true;

                }
            }
        }
        count = 0;
        // Проверка по обратной диагонали
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + j == SIZE - 1) {
                    if (map[i][j] == mark)
                        count++;
                    else
                        count = 0;
                    if (count == WIN_NUMBER)
                        return true;

                }
            }
        }

        return false;
    }

    /**
     * Проверяет заполнена ли карта полностью
     */
    public static boolean isFullMap(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }

    /**
     * Тут записана проверка конца игры - либо кто-то выграл, либо вся карта заполнена
     * @param mark - марка игрока, ход которого был перед данной проверкой
     * @return - true - конец игры/ false - игра продолжается
     */
    public static boolean checkMap(char mark) {
        boolean check = checkWin(mark);
        if (check) {
            if (mark == HUMAN_DOT)
                System.out.println("Победил " + ANSI_YELLOW + "человек!!!" + ANSI_RESET);
            else
                System.out.println("Победил " + ANSI_YELLOW + "компьютер!!!" + ANSI_RESET);
            return true;
        }
        check = isFullMap();
        if (check){
            System.out.println("Вся карта заполнена - " + ANSI_YELLOW + "ничья!!!" + ANSI_RESET);
            return true;
        }
        return false;
    }



    /**
     * Проверяет выиграл ли игрок (его марку мы передаем)
     */
    public static int[] createTurn() {
        //Сначала по диагонали - с левого верхнего угла на правый нижний
        int hCount = 0;
        int bCount = 0;
        int eCount = 0;
        int max[] = {0, 0, 0};

        //по диагонали
        for (int i = 0; i < SIZE; i++) {
            hCount = 0;
            bCount = 0;
            eCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[j][i] == HUMAN_DOT)
                        hCount++;
                    if (map[j][i] == BOT_DOT)
                        bCount++;
                    if (map[j][i] == EMPTY_DOT)
                        eCount++;
                }
            }
            if(bCount == 0 && eCount != 0 && hCount > max[0]) {
                max[0] = hCount;
                max[1] = 0;
                max[2] = 1;
            }
        }

        // Проверка по обратной диагонали
        for (int i = 0; i < SIZE; i++) {
            hCount = 0;
            bCount = 0;
            eCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (i + j == SIZE - 1) {
                    if (map[j][i] == HUMAN_DOT)
                        hCount++;
                    if (map[j][i] == BOT_DOT)
                        bCount++;
                    if (map[j][i] == EMPTY_DOT)
                        eCount++;
                }
            }
            if(bCount == 0 && eCount != 0 && hCount > max[0]) {
                max[0] = hCount;
                max[1] = 0;
                max[2] = 2;
            }
        }

        //потом по вертикали
        for (int i = 0; i < SIZE; i++) {
            hCount = 0;
            bCount = 0;
            eCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == HUMAN_DOT)
                    hCount++;
                if (map[j][i] == BOT_DOT)
                    bCount++;
                if (map[j][i] == EMPTY_DOT)
                    eCount++;
            }
            if (bCount == 0 && eCount != 0 && hCount > max[0]){
                max[0] = hCount;
                max[1] = i;
                max[2] = 3;
            }
        }

        //потом по горизонтали
        for (int i = 0; i < SIZE; i++) {
            hCount = 0;
            bCount = 0;
            eCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == HUMAN_DOT)
                    hCount++;
                if (map[i][j] == BOT_DOT)
                    bCount++;
                if (map[i][j] == EMPTY_DOT)
                    eCount++;
            }
            if (bCount == 0 && eCount != 0 && hCount > max[0]){
                max[0] = hCount;
                max[1] = i;
                max[2] = 4;
            }
        }

        switch (max[2]) {
            case 1: {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i == j && i > 0 && i != SIZE - 1) {
                            int preIndex = i - 1;
                            int postIndex = i + 1;
                            if ((map[postIndex][postIndex] == HUMAN_DOT || map[preIndex][preIndex] == HUMAN_DOT)
                                    && map[i][j] == EMPTY_DOT) {
                                return new int[]{i, j};
                            }
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i + j == SIZE - 1) {
                            if (i > 0 && j > 0 && j != SIZE - 1 && i != SIZE - 1
                                    && (map[i - 1][j + 1] == HUMAN_DOT || map[i + 1][j - 1] == HUMAN_DOT)
                                    && map[i][j] == EMPTY_DOT) {
                                return new int[]{i, j};
                            }
                        }
                    }
                }
                break;
            }
            case 3: {
                for (int j = 0; j < SIZE; j++) {
                    if (((j != SIZE - 1 && map[j + 1][max[1]] == HUMAN_DOT)
                            || (j != 0 && map[j - 1][max[1]] == HUMAN_DOT))
                            && map[max[1]][j] == EMPTY_DOT) {
                        return new int[]{j, max[1]};
                    }
                }
                break;
            }
            case 4: {
                for (int j = 0; j < SIZE; j++) {
                    if (((j != SIZE - 1 && map[max[1]][j + 1] == HUMAN_DOT)
                            || (j != 0 && map[max[1]][j - 1] == HUMAN_DOT))
                            && map[max[1]][j] == EMPTY_DOT) {
                        return new int[]{max[1], j};
                    }
                }
                break;
            }
        }

        return new int[]{-1, -1};
    }
}
