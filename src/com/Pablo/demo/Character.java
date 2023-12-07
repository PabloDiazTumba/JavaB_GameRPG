package com.Pablo.demo;

public abstract class Character {

    public String name;
    public int maxHP, hp, xp;

    public Character(String name, int maxHP, int xp) {
        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.hp = maxHP;
    }

    public abstract int attack();
    public abstract int defend();
}