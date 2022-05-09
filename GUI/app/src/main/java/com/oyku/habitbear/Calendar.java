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

        CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
        ImageView h1,h2,h3,h4,h5,h6;


        setContentView(R.layout.calendar);
        ch1 = (CheckBox) findViewById(R.id.first);

        ch2 = (CheckBox) findViewById(R.id.second);

        ch3 = (CheckBox) findViewById(R.id.third);

        ch4 = (CheckBox) findViewById(R.id.fourth);

        ch5 = (CheckBox) findViewById(R.id.fifth);

        ch6 = (CheckBox) findViewById(R.id.sixth);


        h1 = (ImageView) findViewById(R.id.eat);
        h2 = (ImageView) findViewById(R.id.water);
        h3 = (ImageView) findViewById(R.id.exercise);
        h4 = (ImageView) findViewById(R.id.clock);
        h5 = (ImageView) findViewById(R.id.study);
        h6 = (ImageView) findViewById(R.id.self);

        if(ch1.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setChecked(false);
        }
        if(ch2.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setEnabled(false);
        }
        if(ch3.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setEnabled(false);
        }
        if(ch4.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setEnabled(false);
        }
        if(ch5.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setEnabled(false);
        }
        if(ch6.isChecked()){
            User.user.getHabitsArray()[0].updateToday();
            ch1.setEnabled(false);
        }

        h1.setVisibility(View.VISIBLE);
        if(User.user.getHabitsArray()[0].isEnabled()){
            h1.setVisibility(View.VISIBLE);
            ch1.setVisibility(View.VISIBLE);
        }
        else{

        }
        if(User.user.getHabitsArray()[1].isEnabled()){
            h2.setVisibility(View.VISIBLE);
            ch2.setVisibility(View.VISIBLE);
        }
        else{
            h2.setVisibility(View.INVISIBLE);
            ch2.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[2].isEnabled()){
            h3.setVisibility(View.VISIBLE);
            ch3.setVisibility(View.VISIBLE);
        }
        else{
            h3.setVisibility(View.INVISIBLE);
            ch3.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[3].isEnabled()){
            h4.setVisibility(View.VISIBLE);
            ch4.setVisibility(View.VISIBLE);
        }
        else{
            h4.setVisibility(View.INVISIBLE);
            ch4.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[4].isEnabled()){
            h5.setVisibility(View.VISIBLE);
            ch5.setVisibility(View.VISIBLE);
        }
        else{
            h5.setVisibility(View.INVISIBLE);
            ch5.setVisibility(View.INVISIBLE);
        }
        if(User.user.getHabitsArray()[5].isEnabled()){
            h6.setVisibility(View.VISIBLE);
            ch6.setVisibility(View.VISIBLE);
        }
        else{
            h6.setVisibility(View.INVISIBLE);
            ch6.setVisibility(View.INVISIBLE);
        }

    }








}