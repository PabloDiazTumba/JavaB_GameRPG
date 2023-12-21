package com.Pablo.demo;

// Class that does nothing but stores methods to print out every part of the story
public class Story {

    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("Once upon a time, in a mystical land of dragons and magic,");
        System.out.println("you, a brave adventurer, embark on a perilous journey.");
        System.out.println("Your destiny awaits, filled with challenges and mysteries.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("You find yourself in the Everlasting Mountains,");
        System.out.println("a place known for its treacherous paths and hidden dangers.");
        System.out.println("As you venture forward, you encounter fierce ogres and cunning goblins.");
        System.out.println("Your journey has just begun.");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("You emerge victorious from the battles,");
        System.out.println("your skills sharpened and your spirit unbroken.");
        System.out.println("Yet, darker challenges lie ahead as you move to the Haunted Landlines.");
        System.out.println("Prepare yourself for the next act of your adventure.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("In the Haunted Landlines, the air is thick with mystical energies.");
        System.out.println("Gather your courage as you face evil mercenaries and the minions");
        System.out.println("of the Evil Emperor. Your choices shape your destiny.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("You overcome the challenges, growing stronger with each battle.");
        System.out.println("As you journey towards the Castle of the Evil Emperor,");
        System.out.println("know that the final confrontation awaits.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("The Castle of the Evil Emperor looms large before you,");
        System.out.println("guarded by powerful enchantments. Your heart races as");
        System.out.println("you prepare for the ultimate showdown.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("The Evil Emperor falls, defeated by your unwavering courage.");
        System.out.println("The world is saved, and you stand as its hero.");
        System.out.println("Thank you for playing, brave adventurer!");
        GameLogic.anythingToContinue();
    }

    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("A new chapter begins as you explore the aftermath of your triumph.");
        System.out.println("What adventures await you in this world you've saved?");
        System.out.println("The journey continues...");
        GameLogic.anythingToContinue();
    }

    public static void printEnd(Player player) {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Congratulations, " + player.name + "! You defeated the Evil Emperor and saved the world!");
        GameLogic.printSeperator(30);
        System.out.println("This game was developed by Pablo Diaz from STI Liljeholmen");
        System.out.println("I hope you enjoyed it");
    }
}