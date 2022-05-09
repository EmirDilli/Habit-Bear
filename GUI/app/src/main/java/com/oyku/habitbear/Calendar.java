package com.oyku.habitbear;
import com.oyku.habitbear.*;
import com.oyku.habitbear.BackEnd.Habits;
import com.oyku.habitbear.BackEnd.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends AppCompatActivity{





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);




        setContentView(R.layout.calendar);
        User.ch1 = (CheckBox) findViewById(R.id.first);
        User.ch1.setOnClickListener(this::onClick);
        User.ch2 = (CheckBox) findViewById(R.id.second);
        User.ch2.setOnClickListener(this::onClick);
        User.ch3 = (CheckBox) findViewById(R.id.third);
        User.ch3.setOnClickListener(this::onClick);
        User.ch4 = (CheckBox) findViewById(R.id.fourth);
        User.ch4.setOnClickListener(this::onClick);
        User.ch5 = (CheckBox) findViewById(R.id.fifth);
        User.ch5.setOnClickListener(this::onClick);
        User.ch6 = (CheckBox) findViewById(R.id.sixth);
        User.ch6.setOnClickListener(this::onClick);

        User.h1 = (ImageView) findViewById(R.id.eat);
        User.h2 = (ImageView) findViewById(R.id.water);
        User.h3 = (ImageView) findViewById(R.id.exercise);
        User.h4 = (ImageView) findViewById(R.id.clock);
        User.h5 = (ImageView) findViewById(R.id.study);
        User.h6 = (ImageView) findViewById(R.id.self);


        if(User.user.getHabitsArray()[0].isEnabled()){
            User.h1.setVisibility(View.VISIBLE);
            User.ch1.setVisibility(View.VISIBLE);
        }
        else{
            User.h1.setVisibility(View.INVISIBLE);
            User.ch1.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[1].isEnabled()){
            User.h2.setVisibility(View.VISIBLE);
            User.ch2.setVisibility(View.VISIBLE);
        }
        else{
            User.h2.setVisibility(View.INVISIBLE);
            User.ch2.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[2].isEnabled()){
            User.h3.setVisibility(View.VISIBLE);
            User.ch3.setVisibility(View.VISIBLE);
        }
        else{
            User.h3.setVisibility(View.INVISIBLE);
            User.ch3.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[3].isEnabled()){
            User.h4.setVisibility(View.VISIBLE);
            User.ch4.setVisibility(View.VISIBLE);
        }
        else{
            User.h4.setVisibility(View.INVISIBLE);
            User.ch4.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[4].isEnabled()){
            User.h5.setVisibility(View.VISIBLE);
            User.ch5.setVisibility(View.VISIBLE);
        }
        else{
            User.h5.setVisibility(View.INVISIBLE);
            User.ch5.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[5].isEnabled()){
            User.h6.setVisibility(View.VISIBLE);
            User.ch6.setVisibility(View.VISIBLE);
        }
        else{
            User.h6.setVisibility(View.INVISIBLE);
            User.ch6.setVisibility(View.INVISIBLE);
        }

    }

    public void onClick(View view) {
        if(view.getId() == User.ch1.getId()){
            User.user.getHabitsArray()[0].updateToday();
            User.ch1.setEnabled(false);
        }
        if(view.getId() == User.ch2.getId()){
            User.user.getHabitsArray()[1].updateToday();
            User.ch2.setEnabled(false);
        }
        if(view.getId() == User.ch3.getId()){
            User.user.getHabitsArray()[2].updateToday();
            User.ch3.setEnabled(false);
        }
        if(view.getId() == User.ch4.getId()){
            User.user.getHabitsArray()[3].updateToday();
            User.ch4.setEnabled(false);
        }
        if(view.getId() == User.ch5.getId()){
            User.user.getHabitsArray()[4].updateToday();
            User.ch5.setEnabled(false);
        }
        if(view.getId() == User.ch6.getId()){
            User.user.getHabitsArray()[5].updateToday();
            User.ch6.setEnabled(false);
        }
    }






}