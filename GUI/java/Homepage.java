package com.oyku.habitbear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity implements View.OnClickListener{

    Button habitsButton, marketButton, calendarButton, inventoryButton;
    ImageView settings;
    TextView txt;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        habitsButton = findViewById(R.id.habits);
        habitsButton.setOnClickListener(this::onClick);
        marketButton = findViewById(R.id.market);
        marketButton.setOnClickListener(this::onClick);
        calendarButton = findViewById(R.id.calendar);
        calendarButton.setOnClickListener(this::onClick);
        inventoryButton = findViewById(R.id.inventory);
        inventoryButton.setOnClickListener(this::onClick);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(this:: onClick);
        txt = (TextView) findViewById(R.id.bearName);
        st = getIntent().getExtras().getString("Bear Name");
        txt.setText(st);
        txt.setVisibility(View.VISIBLE);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == habitsButton.getId())
        {
            Intent intent = new Intent(this, Habits.class);
            startActivity(intent);
        }
        else if(view.getId() == marketButton.getId())
        {
            Intent intent = new Intent(this, Market.class);
            startActivity(intent);
        }
        else if(view.getId() == calendarButton.getId())
        {
            Intent intent = new Intent(this, Calendar.class);
            startActivity(intent);
        }
        else if(view.getId() == inventoryButton.getId())
        {
            Intent intent = new Intent(this, Inventory.class);
            startActivity(intent);
        }
        else if(view.getId() == settings.getId())
        {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }



    }
}
