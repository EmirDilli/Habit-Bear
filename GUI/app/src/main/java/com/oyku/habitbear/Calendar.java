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

import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends AppCompatActivity{


    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        back = findViewById(R.id.backCalendar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calendar.this, Homepage.class);
                startActivity(intent);
            }
        });

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(calendar.get(java.util.Calendar.YEAR),calendar.get(java.util.Calendar.MONTH),
                calendar.get(java.util.Calendar.DAY_OF_MONTH));
        setAlarm(calendar.getTimeInMillis());


        User.ch1 = (CheckBox) findViewById(R.id.first);
        User.ch2 = (CheckBox) findViewById(R.id.second);
        User.ch3 = (CheckBox) findViewById(R.id.third);
        User.ch4 = (CheckBox) findViewById(R.id.fourth);
        User.ch5 = (CheckBox) findViewById(R.id.fifth);
        User.ch6 = (CheckBox) findViewById(R.id.sixth);

        User.h1 = (ImageView) findViewById(R.id.eat);
        User.h2 = (ImageView) findViewById(R.id.water);
        User.h3 = (ImageView) findViewById(R.id.exercise);
        User.h4 = (ImageView) findViewById(R.id.clock);
        User.h5 = (ImageView) findViewById(R.id.study);
        User.h6 = (ImageView) findViewById(R.id.self);


        if(User.user.getHabits().get(0).isEnabled()){
            User.h1.setVisibility(View.VISIBLE);
            User.ch1.setVisibility(View.VISIBLE);
        }
        else{
            User.h1.setVisibility(View.INVISIBLE);
            User.ch1.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabits().get(1).isEnabled()){
            User.h2.setVisibility(View.VISIBLE);
            User.ch2.setVisibility(View.VISIBLE);
        }
        else{
            User.h2.setVisibility(View.INVISIBLE);
            User.ch2.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabits().get(2).isEnabled()){
            User.h3.setVisibility(View.VISIBLE);
            User.ch3.setVisibility(View.VISIBLE);
        }
        else{
            User.h3.setVisibility(View.INVISIBLE);
            User.ch3.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabits().get(3).isEnabled()){
            User.h4.setVisibility(View.VISIBLE);
            User.ch4.setVisibility(View.VISIBLE);
        }
        else{
            User.h4.setVisibility(View.INVISIBLE);
            User.ch4.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabits().get(4).isEnabled()){
            User.h5.setVisibility(View.VISIBLE);
            User.ch5.setVisibility(View.VISIBLE);
        }
        else{
            User.h5.setVisibility(View.INVISIBLE);
            User.ch5.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabits().get(5).isEnabled()){
            User.h6.setVisibility(View.VISIBLE);
            User.ch6.setVisibility(View.VISIBLE);
        }
        else{
            User.h6.setVisibility(View.INVISIBLE);
            User.ch6.setVisibility(View.INVISIBLE);
        }

    }
    private void setAlarm(long time)
    {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyAlarm.class);
        PendingIntent pintent = PendingIntent.getBroadcast(this,0,intent,0);
        manager.setRepeating(AlarmManager.RTC, time, 60000,pintent);

    }




}