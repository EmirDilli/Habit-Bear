package com.oyku.habitbear.BackEnd;

import java.util.Calendar;
import java.util.List;

public class AccountAccess {

    public int id;
    public String name;
    public int currentStreak = 0;
    public int maxStreak = 0;

    //public List<Habits> myHabits;
    public int coins;
    //public List<Clothes> myClothes;
    //public List<List<Clothes>> allClothes;

    AccountAccess(Account user){
        this.name = user.getName();
        this.currentStreak = user.getCurrentStreak();
        this.maxStreak = user.getMaxStreak();

        this.coins = user.getCoins();
    }
}
