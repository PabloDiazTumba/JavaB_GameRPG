package com.Pablo.demo;

public class Player extends Character{

    public int numAtkUpgrades;
    public int numDefUpgrades;

    public String[] atkUpgrades = {"Strength", "Power", "might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy bones", "Stoneskin", "Scale armor", "Holy aura"};

    public Player(String name){
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        if (input == 1){
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}