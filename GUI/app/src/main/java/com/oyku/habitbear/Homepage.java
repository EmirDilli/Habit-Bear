package com.oyku.habitbear;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.oyku.habitbear.BackEnd.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Homepage extends AppCompatActivity implements View.OnClickListener{

    Button habitsButton, marketButton, calendarButton, inventoryButton;
    ImageView settings;
    TextView bearNameText, highestStreak, currentStreak, coins;
    String bearsName;

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
        bearNameText = (TextView) findViewById(R.id.bearName);
        //bearNameText.setText(User.user.getName());
        /*highestStreak = (TextView) findViewById(R.id.highestStreakCount);
        highestStreak.setText(User.user.getMaxStreak());
        currentStreak = (TextView) findViewById(R.id.currentStreakCount);
        currentStreak.setText(User.user.getCurrentStreak());
        coins = (TextView) findViewById(R.id.coinCount);
        coins.setText(User.user.getCoins());*/


      /*  DatabaseReference er = FirebaseDatabase.getInstance().getReference("Tevfik");
        er.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bearsName = String.valueOf(dataSnapshot.getValue());
                bearNameText.setText(bearsName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == habitsButton.getId())
        {
            Intent intent = new Intent(this, HabitsPage.class);
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

    public void setBearsName(String name)
    {
        bearsName = name;
    }

}
