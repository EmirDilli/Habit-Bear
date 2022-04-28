package com.oyku.habitbear.BackEnd;

public class Habits {


    
    private String name;
    private boolean isEnabled;
    private boolean isDone;
    private Mountain[] mountain;
    private int currentMount;
    private int streak;
    private Account user;
    private boolean editable;
    
    public Habits(String str){
        isDone = false;
        isEnabled = false;
        name = str;
        mountain = new Mountain[3];
        mountain[0] = new Mountain(1);
        mountain[1] = new Mountain(2);
        mountain[2] = new Mountain(3);
        currentMount = 0; // Get from database
        streak = 1; /// get from database
        editable = false;


    }

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

    
    public void set(Account aUser){
        this.user = aUser;
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
        if (mountain[currentMount].stepNo == mountain[currentMount].mountainProgress(streak)) {
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
            mountain[currentMount].stepNo = 1;
            prize += extra;
        }
        else{
            mountain[currentMount].stepNo++;
        }

        user.coins += prize;

    }

    
}
