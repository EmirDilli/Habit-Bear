package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Calendar extends AppCompatActivity{

    CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        ch = (CheckBox) findViewById(R.id.first);
        //if(ch.isChecked())
        {

        }
    }

}