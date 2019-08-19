package com.nsk.haas.andy.base;

import com.nsk.haas.andy.mode.GameModeImpl;

import java.util.Scanner;

public class MainMenu {
    private GameModeImpl mode = new GameModeImpl();

    public void gameMenuSelection() {
        System.out.println("Choose a game mode: ");
        System.out.println("1. Player with PC.");
        System.out.println("2. Player with Player.");
        System.out.println("3. Quit the game.");

        int playerSelectedNumber;

        Scanner scanner = new Scanner(System.in);

        playerSelectedNumber = scanner.nextInt();

        switch (playerSelectedNumber) {
            case 1:
                System.out.println("Game mode against computer is selected. The game has begun!");
                mode.playerWithPcMode();
                break;

            case 2:
                System.out.println("Game mode player vs. player is selected.");
                System.out.println("Currently the mode is not yet implemented! Sorry!");
                // mode.playerWithPlayerMode();
                break;

            case 3:
                System.out.println("Game exit menu was selected. Good luck!");
                System.exit(0);
                break;

            default:
                System.out.println("Select the correct value in accordance with the proposed menu!");
                gameMenuSelection();
        }
    }
}