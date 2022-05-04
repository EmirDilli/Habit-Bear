package com.oyku.habitbear.BackEnd;

import android.widget.ImageView;
import java.util.Calendar;
import com.oyku.habitbear.*;
import java.util.ArrayList;

public class Account{

    // Properties
    private static int idCount = 0;
    private int id;
    private String name;
    private int currentStreak;
    private int maxStreak;
    private Calendar date = Calendar.getInstance();// will be updated shortly
    private Habits[] myHabits;
    protected int coins;
    private Clothes[][] myClothes;
    public Clothes[][] allClothes;


    public Account(){
        // get name from database

        // get idCount from database (last com.oyku.habitbear.Account's id)
        id = idCount + 1;
        // get current and max streak from database

        /*setDate(date);
        
        currentStep = 0;
        absent = 0;*/



        myHabits = new Habits[6];
        myHabits[0] =new Habits("Workout");
        myHabits[1] =new Habits("Eat Healthy");
        myHabits[2] =new Habits("Quit Smoking");
        myHabits[3] =new Habits("Read Books");
        myHabits[4] =new Habits("Medicine");
        myHabits[5] =new Habits("Custom");
        for (Habits habits : myHabits) {
            habits.set(this);
        }

        coins = 100;
        allClothes = new Clothes[1][1];
        myClothes = new Clothes[3][3]; //[ Shirts, Pants, Accessories]

    }

    // METHODS 1
    public int isHabitDone(){
        int doneNo = 0;
        int habitNo = 0;
        for (int i = 0; i < myHabits.length; i++) {
            if (myHabits[i].isDone()) {
                doneNo++;
            }
            if (myHabits[i].isEnabled()) {
                habitNo++;
            }
        }
        if (doneNo == habitNo) {
            return 1;
        }
        else if(doneNo == 0){
            return -1;
        }
        else {
            return 0;
        }
    }

    public int getCoins()
    {
        return coins;
    }

    public void addHabit(String str){
        if (!myHabits[5].isEnabled()) {
            myHabits[5].setName(str);
            myHabits[5].setEnabled(true);
        }
        else{
            System.out.println("A CUSTOM HABIT EXISTS. FIRST REMOVE IT.");
        }
    }

    public void removeHabit(){
        myHabits[5].setName("Custom");
        myHabits[5].setEnabled(false);
    }

    public void enableHabit(String str){

        for (Habits habits : myHabits) {
            if (habits.getName().toUpperCase().equals(str.toUpperCase())) {
                habits.setEnabled(true);
            }
        }
    }

    public void deEnableHabit(String str){

        for (Habits habits : myHabits) {
            if (habits.getName().toUpperCase().equals(str.toUpperCase())) {
                habits.setEnabled(false);
            }
        }
    }


    public void loseCoins(){   ////////////// WHY DO WE LOSE COINS THO?
        coins = coins - 10;
    }

    public void importClothes(){

        // Shirts
        allClothes[0][0] = new Clothes(10, 0, 0);
        setClothingImage(0, 0);
        /*allClothes[0][1] = new Clothes(10, 0, 1);
        setClothingImage(0, 1);
        allClothes[0][2] = new Clothes(10, 0, 2);
        setClothingImage(0, 2);*/

        // Pants
       /* allClothes[1][0] = new Clothes(10, 1, 0);
        setClothingImage(1, 0);
        allClothes[1][1] = new Clothes(10, 1, 1);
        setClothingImage(1, 1);
        allClothes[1][2] = new Clothes(10, 1, 2);
        setClothingImage(1, 2);

        // Accessories
        allClothes[2][0] = new Clothes(10, 2, 0);
        setClothingImage(2, 0);
        allClothes[2][1] = new Clothes(10, 2, 1);
        setClothingImage(2, 1);
        allClothes[2][2] = new Clothes(10, 2, 2);
        setClothingImage(2, 2);*/
    }

    public void setClothingImage(int type, int abc) {
        //the clothing piece that's going to be set
        if(type == 0)
        {
            if(abc == 0)
            {//red imagela ilişkilendirilecek
                User.c1.setTag(allClothes[0][0]);
            }
        }
            /*else if(color == 1)
            {//green
                clothing = (ImageView) findViewById(R.id.c2);
                clothing.setTag(allClothes[type][color]);
            }
            else if(color == 2)
            {//blue
                clothing = (ImageView) findViewById(R.id.c3);
                clothing.setTag(allClothes[type][color]);
            }
        }*/
        /*else if(type == 1)
        {
            if(color == 0)
            {//red imagela ilişkilendirilecek
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
            else if(color == 1)
            {//green
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
            else if(color == 2)
            {//blue
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
        }
        else if(type == 2)
        {
            if(color == 0)
            {//red imagela ilişkilendirilecek
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
            else if(color == 1)
            {//green
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
            else if(color == 2)
            {//blue
                clothing = (ImageView) findViewById(R.id.clothe1);
                clothing.setTag(allClothes[type][color]);
            }
        }*/
    }

    ///// parameters are the numbers of the clothes in  allClothes, u can update your bear's looks
    public Clothes selectClothes(int type,int selectClothing){
        return myClothes[type][selectClothing];
    }


    // GETTERS & SETTERS
    public Clothes[][] getMyClothes(){
        return myClothes;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    // DATE METHODS
/*
   private void setDate(Calendar x) {

        LocalDate today = new LocalDate.now();

        x.set(Calendar.YEAR ,
                today.getYear());
        x.set(Calendar.MONTH , today.getMonthValue());
        x.set(Calendar.DAY_OF_MONTH , today.getDayOfMonth());
    }




    public int getDayOfMonth() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonthNum() {
        return date.get(Calendar.MONTH);
    }

    public int getYear() {
        return date.get(Calendar.YEAR);
    }
    */

    // STREAKS

    public int getCurrentStreak() {
        return currentStreak;
    }


    public void updateCurrentStreak() {
        this.currentStreak++;
    }


    public int getMaxStreak() {
        return maxStreak;
    }


    public void updateMaxStreak() {
        if (maxStreak < currentStreak) {
            this.maxStreak = currentStreak;
        }
    }

    // com.oyku.habitbear.Mountain

    public void addSteps(){
       // currentStep++;
    }

}
