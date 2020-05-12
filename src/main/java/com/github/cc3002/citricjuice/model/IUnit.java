package com.github.cc3002.citricjuice.model;

public interface IUnit {
    String getName();
    int getMaxHP();
    int getAtk();
    int getDef();
    int getEvd();
    int getCurrentHP();
    void setCurrentHP(final int newHP);
}