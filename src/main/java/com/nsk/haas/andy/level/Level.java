package com.nsk.haas.andy.level;

import com.nsk.haas.andy.base.Base;
import com.nsk.haas.andy.menu.Menu;

import java.util.Random;
import java.util.Scanner;

import static com.nsk.haas.andy.base.Base.*;
import static com.nsk.haas.andy.mode.Mode.modeAgainstAI;

public class Level {

    public static int aiLevel = 0;

    public static void aiLevel() {
        System.out.println("Выберите сложность компьютера: ");
        System.out.println("1. Простой.");
        System.out.println("2. Продвинутый.");
        System.out.println("3. Сложный.");
        System.out.println("4. Вернуться в предыдущее меню.");
        System.out.println("5. Выход.");
        int i;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();

        switch (i) {
            case 1: {
                aiLevel = 0;
                modeAgainstAI();
                break;
            }
            case 2: {
                aiLevel = 1;
                modeAgainstAI();
                break;
            }
            case 3: {
                aiLevel = 2;
                modeAgainstAI();
                break;
            }
            case 4: {
                new Menu().startGame();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Было введено неверное значение!");
            }
        }
    }

    public static void aiStep() {
        int x = -1;
        int y = -1;
        boolean aiWin = false;
        boolean userWin = false;
        // Ищем выигрышный ход
        if (aiLevel == 2) {
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = AI_SIGN;
                        if (checkWin(AI_SIGN)) {
                            x = i;
                            y = j;
                            aiWin = true;
                        }
                        field[i][j] = NOT_SIGN;
                    }
                }
            }
        }
        // Блокируем ход пользователя, если он побеждает на следующем ходу
        if (aiLevel > 0) {
            if (!aiWin) {
                for (int i = 0; i < DIMENSION; i++) {
                    for (int j = 0; j < DIMENSION; j++) {
                        if (!isCellBusy(i, j)) {
                            field[i][j] = USER_SIGN;
                            if (checkWin(USER_SIGN)) {
                                x = i;
                                y = j;
                                userWin = true;
                            }
                            field[i][j] = NOT_SIGN;
                        }
                    }
                }
            }
        }
        if (!aiWin && !userWin) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(DIMENSION);
                y = rnd.nextInt(DIMENSION);
            }
            while (isCellBusy(x, y));
        }
        field[x][y] = AI_SIGN;
        System.out.println("x = " + x + "| y = " + y + "| aiWin = " + aiWin + "| userWin = " + userWin);
    }

    public static void userStep(String sign, int i) {
        getStep(sign, i);
    }
}
