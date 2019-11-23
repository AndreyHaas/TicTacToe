package com.nsk.haas.andy.mode;

import static com.nsk.haas.andy.base.Base.*;
import static com.nsk.haas.andy.level.Level.aiStep;
import static com.nsk.haas.andy.level.Level.userStep;

public class Mode {
    public static void modeTwoPlayers() {

        int count = 0;
        initField();

        while (true) {

            printField();
            userStep(USER_SIGN, 1);
            count++;

            if (checkWin(USER_SIGN)) {
                System.out.println("Победил ПЕРВЫЙ игрок");
                printField();
                break;
            }
            userStep(USER_SIGN_SECOND, 2);
            count++;

            if (checkWin(USER_SIGN_SECOND)) {
                System.out.println("Победил ВТОРОЙ игрок");
                printField();
                break;
            }

            if (count == Math.pow(DIMENSION, 2)) {
                printField();
                break;
            }
        }
    }

    public static void modeAgainstAI() {

        int count = 0;
        initField();

        while (true) {
            printField();
            userStep(USER_SIGN, 0);
            count++;

            if (checkWin(USER_SIGN)) {
                System.out.println("Победил игрок");
                printField();
                break;
            }
            aiStep();
            count++;

            if (checkWin(AI_SIGN)) {
                System.out.println("Победил компьютер");
                printField();
                break;
            }

            if (count == Math.pow(DIMENSION, 2)) {
                printField();
                break;
            }
        }
    }
}
