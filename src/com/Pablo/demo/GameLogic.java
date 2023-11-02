package com.Pablo.demo;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    // method to get user input from console
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
        }while (input < 1 || input < userChoices);
        return input;
    }

    // method to simulate clearing out the console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    // methodto print a seperator with length n
    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    // method to print a heading
    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue. . . ");
        scanner.next();
    }

    // method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name;
        // print title screen
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("Hellooooo 'Some other text here'");
        System.out.println("Some othe other text here");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        // getting player name
        do {
            clearConsole();
            printHeading("Enter your name");
            name = scanner.next();
            // asking the player if he wants to correct his choice
            clearConsole();
            printHeading("your name is " + name + "\nIs that correct?");
            System.out.println("(1) Yes");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        }while (!nameSet);

        // create new player object with the name
        player = new Player(name);
    }

}
