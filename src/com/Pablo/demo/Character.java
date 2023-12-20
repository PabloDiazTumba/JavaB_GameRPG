package com.Pablo.demo;

public abstract class Character {

    protected String name;
    protected int maxHP;
    protected int hp;
    public int xp;

    public Character(String name, int maxHP, int xp) {
        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.hp = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return hp;
    }

    public int getXP() {
        return xp;
    }

    public abstract int attack();
    public abstract int defend();
}