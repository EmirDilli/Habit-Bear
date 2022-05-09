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

    Button readBooks, eatHealthy, drinkWater, workout, wakeUp, custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habits);
        readBooks = findViewById(R.id.read);
        eatHealthy = findViewById(R.id.eat);
        drinkWater = findViewById(R.id.water);
        workout = findViewById(R.id.exercise);
        wakeUp = findViewById(R.id.clock);
        custom = findViewById(R.id.self);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == readBooks.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
        }
        if(view.getId() == eatHealthy.getId())
        {

        }
        if(view.getId() == drinkWater.getId())
        {

        }
        if(view.getId() == workout.getId())
        {

        }
        if(view.getId() == wakeUp.getId())
        {

        }
        if(view.getId() == custom.getId())
        {

        }
    }
}