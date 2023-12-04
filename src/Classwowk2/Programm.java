package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Programm {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final int WIN_COUNT = 4;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!")) break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!")) break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y")) break;
        }
    }

    static void initialize() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 5) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean checkGameState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    static boolean checkWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkHorizontal(x, y, dot, WIN_COUNT) ||
                        checkVertical(x, y, dot, WIN_COUNT) ||
                        checkDiagonal1(x, y, dot, WIN_COUNT) ||
                        checkDiagonal2(x, y, dot, WIN_COUNT)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkHorizontal(int x, int y, char dot, int winCount) {
        if (x > fieldSizeX - winCount) return false;
        for (int i = 0; i < winCount; i++) {
            if (field[y][x + i] != dot) return false;
        }
        return true;
    }

    static boolean checkVertical(int x, int y, char dot, int winCount) {
        if (y > fieldSizeY - winCount) return false;
        for (int i = 0; i < winCount; i++) {
            if (field[y + i][x] != dot) return false;
        }
        return true;
    }

    static boolean checkDiagonal1(int x, int y, char dot, int winCount) {
        if (x > fieldSizeX - winCount || y > fieldSizeY - winCount) return false;
        for (int i = 0; i < winCount; i++) {
            if (field[y + i][x + i] != dot) return false;
        }
        return true;
    }

    static boolean checkDiagonal2(int x, int y, char dot, int winCount) {
        if (x < winCount - 1 || y > fieldSizeY - winCount) return false;
        for (int i = 0; i < winCount; i++) {
            if (field[y + i][x - i] != dot) return false;
        }
        return true;
    }
}
