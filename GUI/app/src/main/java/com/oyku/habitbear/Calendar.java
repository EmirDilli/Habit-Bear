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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends AppCompatActivity implements View.OnClickListener {


    ImageView back;
    ImageView bear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        CheckBox ch1, ch2, ch3, ch4, ch5, ch6;
        ImageView h1, h2, h3, h4, h5, h6;
        back = findViewById(R.id.backCalendar);
        back.setOnClickListener(this::onClick);
        bear = findViewById(R.id.bear);

        User.user.getDataFromDatabase(User.user.getId(), bear);
        User.getDressed(bear);

        ch1 = (CheckBox) findViewById(R.id.first);
        ch1.setChecked((User.user.getHabitsArray()[1].isDone()));
        ch1.setEnabled(!User.user.getHabitsArray()[1].isDone());

        ch2 = (CheckBox) findViewById(R.id.second);
        ch2.setChecked((User.user.getHabitsArray()[4].isDone()));
        ch2.setEnabled(!User.user.getHabitsArray()[4].isDone());

        ch3 = (CheckBox) findViewById(R.id.third);
        ch3.setChecked((User.user.getHabitsArray()[0].isDone()));
        ch3.setEnabled(!User.user.getHabitsArray()[0].isDone());

        ch4 = (CheckBox) findViewById(R.id.fourth);
        ch4.setChecked((User.user.getHabitsArray()[2].isDone()));
        ch4.setEnabled(!User.user.getHabitsArray()[2].isDone());

        ch5 = (CheckBox) findViewById(R.id.fifth);
        ch5.setChecked((User.user.getHabitsArray()[3].isDone()));
        ch5.setEnabled(!User.user.getHabitsArray()[3].isDone());

        ch6 = (CheckBox) findViewById(R.id.sixth);
        ch6.setChecked((User.user.getHabitsArray()[5].isDone()));
        ch6.setEnabled(!User.user.getHabitsArray()[5].isDone());

        h1 = (ImageView) findViewById(R.id.eat);
        h2 = (ImageView) findViewById(R.id.water);
        h3 = (ImageView) findViewById(R.id.exercise);
        h4 = (ImageView) findViewById(R.id.clock);
        h5 = (ImageView) findViewById(R.id.study);
        h6 = (ImageView) findViewById(R.id.self);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch1.isChecked()) {
                    User.user.getHabitsArray()[1].updateToday();
                    User.user.getHabitsArray()[1].setDone(true);
                    ch1.setEnabled(false);
                    User.user.updateDataToDatabase();

                }
            }
        });
        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch6.isChecked()) {
                    User.user.getHabitsArray()[5].updateToday();
                    ch6.setEnabled(false);
                    User.user.getHabitsArray()[5].setDone(true);
                    User.user.updateDataToDatabase();

                }
            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch2.isChecked()) {
                    User.user.getHabitsArray()[4].updateToday();
                    User.user.getHabitsArray()[4].setDone(true);
                    ch2.setEnabled(false);
                    User.user.updateDataToDatabase();

                }
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch3.isChecked()) {
                    User.user.getHabitsArray()[0].updateToday();
                    User.user.getHabitsArray()[0].setDone(true);
                    ch3.setEnabled(false);
                    User.user.updateDataToDatabase();
                }
            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch4.isChecked()) {
                    User.user.getHabitsArray()[2].updateToday();
                    User.user.getHabitsArray()[2].setDone(true);
                    ch4.setEnabled(false);
                    User.user.updateDataToDatabase();
                }
            }
        });
        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch5.isChecked()) {
                    User.user.getHabitsArray()[3].updateToday();
                    User.user.getHabitsArray()[3].setDone(true);
                    ch5.setEnabled(false);
                    User.user.updateDataToDatabase();
                }
            }
        });



        if (User.user.getHabitsArray()[0].isEnabled()) {
            h3.setVisibility(View.VISIBLE);
            ch3.setVisibility(View.VISIBLE);
        } else {
            h3.setVisibility(View.INVISIBLE);
            ch3.setVisibility(View.INVISIBLE);
        }
        if (User.user.getHabitsArray()[1].isEnabled()) {
            h1.setVisibility(View.VISIBLE);
            ch1.setVisibility(View.VISIBLE);
        } else {
            h1.setVisibility(View.INVISIBLE);
            ch1.setVisibility(View.INVISIBLE);
        }
        if (User.user.getHabitsArray()[2].isEnabled()) {
            h4.setVisibility(View.VISIBLE);
            ch4.setVisibility(View.VISIBLE);
        } else {
            h4.setVisibility(View.INVISIBLE);
            ch4.setVisibility(View.INVISIBLE);
        }
        if (User.user.getHabitsArray()[3].isEnabled()) {
            h5.setVisibility(View.VISIBLE);
            ch5.setVisibility(View.VISIBLE);
        } else {
            h5.setVisibility(View.INVISIBLE);
            ch5.setVisibility(View.INVISIBLE);
        }
        if (User.user.getHabitsArray()[4].isEnabled()) {
            h2.setVisibility(View.VISIBLE);
            ch2.setVisibility(View.VISIBLE);
        } else {
            h2.setVisibility(View.INVISIBLE);
            ch2.setVisibility(View.INVISIBLE);
        }
        if (User.user.getHabitsArray()[5].isEnabled()) {
            h6.setVisibility(View.VISIBLE);
            ch6.setVisibility(View.VISIBLE);
        } else {
            h6.setVisibility(View.INVISIBLE);
            ch6.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
