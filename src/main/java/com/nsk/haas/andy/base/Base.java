package com.nsk.haas.andy.base;

import java.util.Scanner;

public class Base {
    public static final String USER_SIGN = "X";
    public static final String USER_SIGN_SECOND = "O";
    public static final String AI_SIGN = "O";
    public static final String NOT_SIGN = ".";
    public static final int DIMENSION = 3;
    public static final String[][] field = new String[DIMENSION][DIMENSION];

    public static void userStep(String sign, int i) {
        int x;
        int y;
        do {
            if (i == 0) {
                System.out.println("Введите координаты x y (1 - " + DIMENSION + "): ");
            } else {
                System.out.println("Игрок " + i + ". Введите координаты x y (1 - " + DIMENSION + "): ");
            }
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (isCellBusy(x, y));
        field[x][y] = sign;
    }

    public static void initField() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                field[i][j] = NOT_SIGN;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= DIMENSION; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCellBusy(int x, int y) {
        if (x >= 0 && y >= 0 && x <= DIMENSION - 1 && y <= DIMENSION - 1) {
            return !field[x][y].equals(NOT_SIGN);
        }
        return false;
    }

    public static boolean checkLine(int startX, int startY, int dx, int dy, String sign) {
        for (int i = 0; i < DIMENSION; i++) {
            if (!field[startX + i * dx][startY + i * dy].equals(sign)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWin(String sign) {
        for (int i = 0; i < DIMENSION; i++) {
            // проверяем строки
            if (checkLine(i, 0, 0, 1, sign)) {
                return true;
            }
            // проверяем столбцы
            if (checkLine(0, i, 1, 0, sign)) {
                return true;
            }
        }
        // проверяем диагонали
        if (checkLine(0, 0, 1, 1, sign)) {
            return true;
        }
        return checkLine(0, DIMENSION - 1, 1, -1, sign);
    }

    public static boolean checkWin2(String sign) {
        // проверка по строкам
        for (int i = 0; i < DIMENSION; i++) {
            if (field[i][0].equals(sign) && field[i][1].equals(sign) && field[i][2].equals(sign)) {
                return true;
            }
        }

        // проверка по столбцам
        for (int j = 0; j < DIMENSION; j++) {
            if (field[0][j].equals(sign) && field[1][j].equals(sign) && field[2][j].equals(sign)) {
                return true;
            }
        }

        // проверка диагоналей
        if (field[0][0].equals(sign) && field[1][1].equals(sign) && field[2][2].equals(sign)) {
            return true;
        }
        return field[0][2].equals(sign) && field[1][1].equals(sign) && field[2][0].equals(sign);
    }
}
