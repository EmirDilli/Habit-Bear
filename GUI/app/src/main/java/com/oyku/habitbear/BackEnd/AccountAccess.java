package com.oyku.habitbear.BackEnd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AccountAccess {

    public int id;
    public String name;
    public int currentStreak = 0;
    public int maxStreak = 0;

    public  boolean redTshirt;
    public  boolean greenTshirt;
    public  boolean blueTshirt;
    public  boolean redPants;
    public  boolean greenPants;
    public  boolean bluePants;
    public  boolean moustache;
    public  boolean glasses;

    public String currStr;
    public String maxStr;
    public String compareDt;

    public List<HabitsAccess> habits;
    public List<List<ClothesAccess>> myClothes;

    public int coins;

    AccountAccess(){
        // formed to get data from the database
    }

    // sets the instance variables of this class according to given user

    AccountAccess(Account user){
        this.id = user.getId();
        this.name = user.getName();
        this.currentStreak = user.getCurrentStreak();
        this.maxStreak = user.getMaxStreak();

        redTshirt = User.redTshirt;
        greenTshirt = User.greenTshirt;
        blueTshirt = User.blueTshirt;
        redPants = User.redPants;
        greenPants = User.greenPants;
        bluePants = User.bluePants;
        moustache = User.moustache;
        glasses = User.glasses;

        this.coins = user.getCoins();
        this.habits = new ArrayList<HabitsAccess>();
        this.myClothes = new ArrayList<List<ClothesAccess>>();
        this.currStr = user.getCurrStr();
        this.maxStr = user.getHighStr();
        this.compareDt = user.getCompareDate();

        List<Habits> allHabits = user.getHabits();
        List<List<Clothes>> clothes = user.getClothes();

        for (int i = 0; i < allHabits.size(); i++) {
            habits.add(new HabitsAccess(allHabits.get(i)));
        }
        for (int i = 0; i < clothes.size(); i++) {
            this.myClothes.add(new ArrayList<ClothesAccess>());
            for (int j = 0; j < clothes.get(i).size(); j++) {
                if(clothes.get(i).get(j) == null)
                {
                    this.myClothes.get(i).add(new ClothesAccess(new Clothes(-1, -1, -1)));
                }
                else
                {
                    this.myClothes.get(i).add(new ClothesAccess(clothes.get(i).get(j)));
                }


            }

        }

    }
}
