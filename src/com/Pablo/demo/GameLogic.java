package com.Pablo.demo;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    // Random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    // Enemy names
    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};

    // Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Everlasting Mountains", "Haunted Landlines",
            "Castle of the Evil Emperor", "Throne room"};

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

        // Print story intro
        Story.printIntro();

        player = new Player(name);

        player.chooseTrait();

        // Print first story act
        Story.printFirstActIntro();

        // Setting isRunning to true, so the game loop can continue
        isRunning = true;

        // start main game loop
        gameLoop();
    }

    // Method that changes games values based on player xp
    public static void checkAct() {
        if (player.xp >= 10 && act == 1) {
            // Increament act and place
            act = 2;
            place = 1;
            // Story
            Story.printFirstActOutro();
            // Let player level up
            player.chooseTrait();
            // Story
            Story.printSecondActIntro();
            // Assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Evil Mercenary";
            enemies[2] = "Henchman of the Evil Emperor";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Henchman of the Evil Emperor";
            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";
            // Fully heal the player
            player.hp = player.maxHP;
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            // Story
            Story.printSecondActOutro();
            // Level up
            player.chooseTrait();
            // Story
            Story.printThirdActIntro();
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            // Story
            Story.printThirdActOutro();
            // Level up
            player.chooseTrait();
            // Story
            Story.printFourthActIntro();
            // Fully heal the player
            player.hp = player.maxHP;
            // Final battle

        }
    }

    // Method to calculate a random encounter
    public static void randomEncounter() {
        // Random number between 0 and the length of the encounter array
        int encounter = (int) (Math.random() * encounters.length);
        // Calling the respective methods
        if (encounters[encounter].equals("Battle")) {
            // Random battle();
        }else if (encounters[encounter].equals("Rest")) {
            // Take rest();
        }else {
            // Shop();
        }
    }

    // Method to continue the journey
    public static void continueJourney() {
        // check if act must be increased
        checkAct();
        if (act != 4)
            randomEncounter();
    }

    // Printing out important info about player
    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHP);
        printSeperator(20);
        System.out.println("XP: " + player.hp);
        printSeperator(20);

        // Printing the chosen trait
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades -1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades -1]);
        }
        anythingToContinue();
    }

    // Printing the main menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
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