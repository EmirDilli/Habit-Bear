package com.oyku.habitbear.BackEnd;

public class Habits {


    
    private String name;
    private boolean isEnabled;
    private boolean isDone;
    private Mountain mountain;
    private int currentMount;
    private int highStreak;
    private int streak;
    private boolean editable;
    
    public Habits(String str){
        isDone = false;
        isEnabled = false;
        name = str;
        mountain = new Mountain(1);
        currentMount = 0;
        streak = 1;
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
        if ((2*mountain.getMountainNo()+1) == mountain.mountainProgress(streak)) {
            return true;
        }
        return false;
    }

    public int getHighStreak() {return highStreak;}


    // Sets is done + step
    public void updateToday() {

         
        int prize = 1;
        int extra = 2;

        if ( onLastStep() ) {
            mountain.increaseMountNo();// Database
            mountain.currStepNo = 1;
            prize += extra;
            User.user.updateDataToDatabase();
        }
        else{
            mountain.currStepNo++;
            User.user.updateDataToDatabase();
        }
        streak++;
        if(highStreak < streak) highStreak = streak;
        User.user.setMaxStreak();
        User.user.setCurrStreak();
        User.user.coins += prize;
        User.user.updateDataToDatabase();

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
