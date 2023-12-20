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
            player = new Player(name);  // Set the player here
            clearConsole();
            printHeading("your name is " + name + "\nIs that correct?");
            System.out.println("(1) Yes");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

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
            finalBattle();

        }
    }

    // Method to calculate a random encounter
    public static void randomEncounter() {
        // Random number between 0 and the length of the encounter array
        int encounter = (int) (Math.random() * encounters.length);
        // Calling the respective methods
        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        }else if (encounters[encounter].equals("Rest")) {
            takeRest();
        }else {
            shop();
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
        // Player xp and gold

        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        // Number of pots
        System.out.println("Number of potions: " + player.pots);
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

    // Shopping / encountering a travelling trader
    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger. \nHe offers you something:");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magic potion: " + price + " gold.");
        printSeperator(20);
        // Ask the player to buy one
        System.out.println("Do you want to buy one?\n (1) Yes!\n(2) No thank you.");
        int input = readInt("-> ", 2);
        // Check if player wants to buy
        if (input == 1) {
            clearConsole();
            // Check if player has enough gold
            if (player.gold >= price) {
                printHeading("you bought a magical potion for " + price + "gold.");
                player.pots++;
                player.gold -= price;
            }else
                printHeading("You dont have enough gold to buy this");
            anythingToContinue();
        }
    }

    // Take a rest
    public static void takeRest() {
        clearConsole();
        if (player.restsLeft >= 1) {
            printHeading("Do you want to take a rest?(" + player.restsLeft + "rest(s) left).");
            System.out.println("(1) Tes\n(2) No, not now.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                // Player takes a rest
                clearConsole();
                if (player.hp < player.maxHP) {
                    int hpRestored = (int) (Math.random()* (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHP)
                        player.hp = player.maxHP;
                    System.out.println("You took a rest and restored up to " + hpRestored + "health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHP + " health.");
                    player.restsLeft--;
                }
            }else
                System.out.println("You're at full health. You dont need to rest now!");
            anythingToContinue();
        }
    }

    // Creating a random battle
    public static void randomBattle() {
        clearConsole();
        printHeading("You encountered and evil minded creature. You'll have to fight it!");
        anythingToContinue();
        // Creating new enemy with random name
        battle(new Enemy(enemies[(int)(Math.random()* enemies.length)], player.xp));
    }

    // The main battle method
    public static void battle(Enemy enemy) {
        // Main battle loop
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.xp + "/" + enemy.maxHP);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHP);
            System.out.println("Choose and action:");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            // React accordingly to player input
            if (input == 1) {
                // FIGHT, calculate dmg, dmgTook
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                // Check that dmg and dmgTook is not negative
                if (dmgTook < 0) {
                    // Add some dmg if payer defends well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                // Deal dmg to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                // print the info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the  " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                // Check if player is still alive or dead
                if (player.hp <= 0) {
                    playerDied(); // Method to end game
                    break;
                } else if (enemy.hp <= 0) {
                    // Print player won
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    // Random drops
                    boolean addRest = (Math.random()* 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random()* enemy.xp);
                    if (addRest) {
                        player.restsLeft ++;
                        System.out.println("You earned the chance to get additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the "
                                + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            } else if (input == 2) {
                // Use potion()
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHP) {
                    // Player can take potions
                    // Make sure player is sure
                    printHeading("Do you want to drink a potion? (" + player.pots + " left.");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    if (input == 1) {
                        // Player took potion
                        player.hp = player.maxHP;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to "
                                + player.maxHP);
                        anythingToContinue();
                    }
                }else{
                    // Player cannot take potion
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }
            }else{
                // Run away
                clearConsole();
                // Check tha player is not in final act (Final boss battle)
                if (act != 4) {
                    // chance to escape 35%
                    if (Math.random()*10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    }else{
                        printHeading("You didnt manage to escape.");
                        int dmgTook = enemy.attack();
                        System.out.println("In your cowardness you took 0 " + dmgTook + " damage!");
                        anythingToContinue();
                        // Check if player is alive
                        if (player.hp <= 0)
                            playerDied();
                    }
                }else {
                    printHeading("YOU CANNOT ESCAPE THE EVIL EMPEROR!!!");
                    anythingToContinue();
                }

            }
        }
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

    // The final battle
    public static void finalBattle() {
        // Creating the evil emperor and letting player fight him
        battle(new Enemy("The EVIL EMPEROR", 300));
        // printing the proper ending act
        Story.printEnd(player);
        isRunning = false;
    }

    // Method that gets called when the player is dead
    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        printHeading("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for playing my game. I hope you enjoyed it =)");
        isRunning = false;
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

    public static void setPlayer(Player player) {
        GameLogic.player = player;
    }
}