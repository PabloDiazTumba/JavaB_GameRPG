package com.Pablo.demo;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                input = 1;
                System.out.println("Please enter a number!");
            }
        }while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole(){
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue. . . ");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;

        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("Hellooooo");
        System.out.println("Some other other text here");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("Enter your name");
            name = scanner.next();
            clearConsole();
            printHeading("your name is " + name + "\nIs that correct?");
            System.out.println("(1) Yes");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        }while (!nameSet);

        player = new Player(name);
        player.chooseTrait();

        // Setting isRunning to true, so the game loop can continue
        isRunning = true;

        // start main game loop
        gameLoop();
    }

    

    // Main game loop
    private static void gameLoop() {
        while (isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;

        }
    }


}