package com.Pablo.demo;

public class Player extends Character {

    public int numAtkUpgrades;
    public int numDefUpgrades;

    // Additional player stats
    int gold, restsLeft, pots;

    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // Set additional stats
        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
    }

    public Player(String playerName, int maxHp, int hp, int xp, int numAtkUpgrades,
                  int numDefUpgrades, int gold, int restsLeft, int pots) {
        super(playerName, maxHp, hp);
        this.numAtkUpgrades = numAtkUpgrades;
        this.numDefUpgrades = numDefUpgrades;
        this.gold = gold;
        this.restsLeft = restsLeft;
        this.pots = pots;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp / 4 + numDefUpgrades * 3 + 3) + xp / 10 + numDefUpgrades * 2 + numAtkUpgrades + 1);
    }

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        if (input == 1) {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }

    public int getNumAtkUpgrades() {
        return numAtkUpgrades;
    }

    public int getNumDefUpgrades() {
        return numDefUpgrades;
    }

    public int getGold() {
        return gold;
    }

    public int getRestsLeft() {
        return restsLeft;
    }

    public int getPots() {
        return pots;
    }
}