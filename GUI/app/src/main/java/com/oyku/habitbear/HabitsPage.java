package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import  com.oyku.habitbear.*;
import com.oyku.habitbear.BackEnd.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HabitsPage extends AppCompatActivity implements View.OnClickListener{

    ImageView readBooks, eatHealthy, medicine, workout, smoke, custom;

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