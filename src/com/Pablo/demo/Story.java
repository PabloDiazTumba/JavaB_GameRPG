package com.Pablo.demo;

// Class that does nothing but stores methods to print out every part of the story
public class Story {

    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        GameLogic.anythingToContinue();
    }
    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeperator(30);
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
        System.out.println("STORY LINE HERE");
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