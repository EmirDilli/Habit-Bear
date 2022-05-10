package com.oyku.habitbear.BackEnd;

public class HabitsAccess {

    public String name;
    public boolean isEnabled;
    public boolean isDone;
    public MountainAccess mountain;
    public int streak;
    public boolean editable;

    HabitsAccess(){

    }

    HabitsAccess(Habits habit){

        this.name = habit.getName();
        this.isEnabled = habit.isEnabled();
        this.isDone = habit.isDone();
        this.mountain = new MountainAccess(habit.getMountain());
        this.streak = habit.getStreak();
        this.editable = habit.isEditable();

    }
}