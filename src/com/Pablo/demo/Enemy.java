package com.Pablo.demo;

public class Enemy extends Character{

    // Variable to store the players current xp
    int playerXP;

    // Enemy specific constructor
    public Enemy(String name, int playerXP) {
        super(name, (int) (Math.random()*playerXP + playerXP/3 + 5),
                (int) Math.random()*(playerXP/4 + 2) + 1);
        // Assigning variable
        this.playerXP = playerXP;
    }

    // Enemy specific attack and defence calculations
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}
