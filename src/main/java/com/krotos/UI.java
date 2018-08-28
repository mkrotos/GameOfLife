package com.krotos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);
    private boolean run = true;
    private GameCore gameCore = null;

    public void run() {
        while (run) {
            System.out.println("s - start new game, n - next turn, e - exit");
            char action = scanner.next().charAt(0);

            switch (action) {
                case 's':
                    int height;
                    int width;
                    if (gameCore != null && gameCore.isNotEnded()) {
                        System.out.println("Current game isn't finished yet. Do you want to start a new game? (y/n)");
                        char wantANewGame = scanner.next().charAt(0);
                        switch (wantANewGame) {
                            case 'n':
                                continue;
                            case 'y':
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println("Enter the height of the board: ");
                    try {
                        height = scanner.nextInt();
                        System.out.println("Enter the width of the board: ");
                        width = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong input");
                        scanner.nextLine();
                        break;
                    }
                    gameCore = new GameCore(height, width);
                    gameCore.start();
                    break;
                case 'n':

                    if (gameCore != null && gameCore.isNotEnded()) {
                        gameCore.nextTurn();
                    } else if (gameCore != null) {
                        System.out.println("Game ended. You can start a new game.");
                    } else {
                        System.out.println("First you have to start the game");
                    }
                    break;
                case 'e':
                    run = false;
                    break;
                default:
                    System.out.println("There is no such option");
                    break;
            }
        }
        System.out.println("Bye");
    }

}
