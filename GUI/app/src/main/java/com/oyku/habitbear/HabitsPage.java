package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import  com.oyku.habitbear.*;
import com.oyku.habitbear.BackEnd.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class HabitsPage extends AppCompatActivity implements View.OnClickListener{

    ImageView readBooks, eatHealthy, medicine, workout, smoke, custom, bear;
    CheckBox c1,c2,c3,c4,c5,c6;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habits);
        readBooks = findViewById(R.id.study);
        readBooks.setOnClickListener(this::onClick);
        eatHealthy = findViewById(R.id.eat);
        eatHealthy.setOnClickListener(this::onClick);
        medicine = findViewById(R.id.medicine);
        medicine.setOnClickListener(this::onClick);
        workout = findViewById(R.id.workout);
        workout.setOnClickListener(this::onClick);
        smoke = findViewById(R.id.quitSmoke);
        smoke.setOnClickListener(this::onClick);
        custom = findViewById(R.id.health);
        custom.setOnClickListener(this::onClick);
        bear = findViewById(R.id.bear);

        //User.getDressed(bear);
        c1 = findViewById(R.id.first);
        c2 = findViewById(R.id.second);
        c3 = findViewById(R.id.third);
        c4 = findViewById(R.id.fourth);
        c5 = findViewById(R.id.fifth);
        c6 = findViewById(R.id.sixth);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[0].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[0].setEnabled(false);
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[1].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[1].setEnabled(false);
                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[2].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[2].setEnabled(false);
                }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[3].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[3].setEnabled(false);
                }
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[4].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[4].setEnabled(false);
                }
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    User.user.getHabitsArray()[5].setEnabled(true);
                }
                else{
                    User.user.getHabitsArray()[5].setEnabled(false);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == readBooks.getId())
        {
            Intent intent = new Intent(this, StudyMountain.class);
            startActivity(intent);
        }
        if(view.getId() == eatHealthy.getId())
        {
            Intent intent = new Intent(this, EatHealthyMountain.class);
            startActivity(intent);
        }
        if(view.getId() == medicine.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
        }
        if(view.getId() == workout.getId())
        {
            Intent intent = new Intent(this, WorkoutMountain.class);
            startActivity(intent);
        }
        if(view.getId() == smoke.getId())
        {
            Intent intent = new Intent(this, QuitSmokingMountain.class);
            startActivity(intent);
        }
        if(view.getId() == custom.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
        }
    }
}