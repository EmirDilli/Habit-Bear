package com.oyku.habitbear.BackEnd;

public class Habits {


    
    private String name;
    private boolean isEnabled;
    private boolean isDone;
    private Mountain mountain;
    private int currentMount;
    private int streak;
    private Account user;
    private boolean editable;
    
    public Habits(String str){
        isDone = false;
        isEnabled = false;
        name = str;
        mountain = new Mountain(1);
        currentMount = 0; // Get from database
        streak = 1; /// get from database
        editable = false;
    }

    public Habits(){
        this.mountain = new Mountain();
    }

    public Mountain getMountain()
    {
        return this.mountain;
    }

    public boolean isEditable()
    {
        return this.editable;
    }

    public int getStreak(){return this.streak;}

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getName(){
        return name;
    }

    public void setName(String str){
        if (editable) {
            name = str;
        }
        else{
            System.out.println("not editable!!!!");
        }
        
    }


    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }


    // TODAY'S HABIT

    public boolean isDone() { /// isHabitDone()
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    ///hasNextStep()->onLastStep()
    public  boolean onLastStep(){
        if (mountain.stepNo == mountain.mountainProgress(streak)) {
            return true;
        }
        return false;
    }

    // Sets is done + step
    public void updateToday() {
        this.isDone = true;
         
        int prize = 1;
        int extra = 2;

        if ( onLastStep() ) {
            currentMount++; // Database
            mountain.stepNo = 1;
            prize += extra;
        }
        else{
            mountain.stepNo++;
        }

        user.coins += prize;

    }
    public void getData(HabitsAccess ma){

        this.name = ma.name;
        this.isEnabled = ma.isEnabled;
        this.isDone = ma.isDone;
        this.mountain.getData(ma.mountain);
        this.streak = ma.streak;
        this.editable = ma.editable;

    }

    
}
