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

    Button habitsButton, marketButton, calendarButton, inventoryButton, lol;
    ImageView settings;
    TextView bearNameText, highestStreakCount, currentStreakCount, coins;
    String bearsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User.user.getDataFromDatabase(3);
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
        lol = findViewById(R.id.lol);
        lol.setOnClickListener(this::onClick);
        bearNameText = (TextView) findViewById(R.id.bearName);
        bearNameText.setText(User.user.getName());
        currentStreakCount = (TextView) findViewById(R.id.currentStreakCount);
        highestStreakCount = (TextView) findViewById(R.id.highestStreakCount);
        coins = (TextView) findViewById(R.id.coinCount);



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
        else if(view.getId() == lol.getId())
        {
            bearNameText.setText(User.user.getName());
            currentStreakCount.setText(User.user.getCurrentStreak()+ "");
            highestStreakCount.setText(User.user.getMaxStreak() + "");
            coins.setText(User.user.getCoins() + "");

        }
    }

    public void setBearsName(String name)
    {
        bearsName = name;
    }

}
