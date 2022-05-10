package com.oyku.habitbear.BackEnd;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class Account{

    // Properties
    private int id;
    private String name;
    private int currentStreak;
    private int maxStreak;
    private Calendar date;// will be updated shortly
    private Habits[] myHabits;
    protected int coins;
    private Clothes[][] myClothes;
    public Clothes[][] allClothes;


    public Account(){
        // get name from database

        // get idCount from database (last com.oyku.habitbear.Account's id)

        // get current and max streak from database

        /*setDate(date);
        
        currentStep = 0;
        absent = 0;*/
        date = Calendar.getInstance();



        myHabits = new Habits[6];
        myHabits[0] =new Habits("Workout");
        myHabits[1] =new Habits("Eat Healthy");
        myHabits[2] =new Habits("Quit Smoking");
        myHabits[3] =new Habits("Read Books");
        myHabits[4] =new Habits("Medicine");
        myHabits[5] =new Habits("Custom");

        coins = 100;
        allClothes = new Clothes[3][3];
        myClothes = new Clothes[3][3];

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
        allClothes[0][1] = new Clothes(10, 0, 1);
        setClothingImage(0, 1);
        allClothes[0][2] = new Clothes(10, 0, 2);
        setClothingImage(0, 2);

        // Pants
        allClothes[1][0] = new Clothes(10, 1, 0);
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
    }

    public void setClothingImage(int type, int color) {
        //the clothing piece that's going to be set
        if (type == 0) {
            if (color == 0) {//red imagela ilişkilendirilecek
                User.c1.setTag(allClothes[0][0]);
            } else if (color == 1) {//green
                User.c2.setTag(allClothes[0][1]);
            } else if (color == 2) {//blue
                User.c3.setTag(allClothes[0][2]);
            }
        } else if (type == 1) {
            if (color == 0) {//red imagela ilişkilendirilecek
                User.c4.setTag(allClothes[1][0]);
            } else if (color == 1) {//green
                User.c5.setTag(allClothes[1][1]);
            } else if (color == 2) {//blue
                User.c6.setTag(allClothes[1][2]);
            }
        } else if (type == 2) {
            if (color == 0) {//red imagela ilişkilendirilecek
                User.c7.setTag(allClothes[2][0]);
            } else if (color == 1) {//green
                User.c8.setTag(allClothes[2][1]);
            }
        }
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

    public List<Habits> getHabits(){
        return Arrays.asList(this.myHabits);
    }

    public List<List<Clothes>> getClothes(){
        List<List<Clothes>> result = new ArrayList<>();
        for (int i = 0; i < this.myClothes.length; i++) {
            result.add(Arrays.asList(this.myClothes[i]));
        }
        return result;
    }








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

    public void addNewDataToDatabase(){
        AccountAccess ma = new AccountAccess(this);

        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("User");
        DatabaseReference key = FirebaseDatabase.getInstance().getReference("ID_Keys");

        key.child("User").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                //Log.d("MESSAGE","SUCCESFULL");
                int count = Integer.parseInt(task.getResult().getValue(String.class));
                key.child("User").setValue(String.valueOf(count+1));
                ma.id = count + 1;
                dr.child(String.valueOf(ma.id)).setValue(ma);
            }
        });
    }
    public void getData(AccountAccess ma){

        User.redTshirt = ma.redTshirt;
        User.greenTshirt = ma.greenTshirt;
        User.blueTshirt = ma.blueTshirt;
        User.redPants = ma.redPants;
        User.greenPants = ma.greenPants;
        User.bluePants = ma.bluePants;
        User.moustache = ma.moustache;
        User.glasses = ma.glasses;

        this.id = ma.id;
        this.name = ma.name;
        this.currentStreak = ma.currentStreak;
        this.maxStreak = ma.maxStreak;
        this.coins = ma.coins;

        myHabits = new Habits[ma.habits.size()];

        for (int i = 0; i < myHabits.length; i++) {
            myHabits[i] = new Habits();
            myHabits[i].getData(ma.habits.get(i));
        }

        myClothes = new Clothes[3][3];

        for (int i = 0; i < myClothes.length; i++) {
            for (int j = 0; j < myClothes[i].length; j++) {
                myClothes[i][j] = new Clothes();
                if(ma.myClothes.get(i).get(j).type == -1) myClothes[i][j] = null;
                else{
                    myClothes[i][j].getData(ma.myClothes.get(i).get(j));
                }

            }

        }

    }
    public void getDataFromDatabase(int id, TextView bearName, TextView coinCount, TextView currStreak, TextView highStreak, ImageView bearImage){
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("User");

        dr.child(String.valueOf(id)).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                AccountAccess ac = task.getResult().getValue(AccountAccess.class);
                getData(ac);
                bearName.setText(name);
                coinCount.setText(coins + "");
                currStreak.setText(currentStreak + "");
                highStreak.setText(maxStreak + "");
                User.getDressed(bearImage);

            }
        });
    }
    public void updateDataToDatabase(){
        AccountAccess ma = new AccountAccess(this);

        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("User");

        dr.child(String.valueOf(id)).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                dr.child(String.valueOf(id)).setValue(ma);
            }
        });
    }
    public Habits[] getHabitsArray(){
        return (this.myHabits);
    }

    }


