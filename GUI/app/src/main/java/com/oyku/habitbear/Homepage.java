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

import java.text.SimpleDateFormat;
import java.util.Date;


public class Homepage extends AppCompatActivity implements View.OnClickListener{

    Button habitsButton, marketButton, calendarButton, inventoryButton;
    ImageView settings, bearImage;
    TextView bearNameText, highestStreakCount, currentStreakCount, coins;
    String bearsName;
    String date, compareDate = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        bearNameText = (TextView) findViewById(R.id.bearName);
        currentStreakCount = (TextView) findViewById(R.id.currentStreakCount);
        highestStreakCount = (TextView) findViewById(R.id.highestStreakCount);
        coins = (TextView) findViewById(R.id.coinCount);
        bearImage = findViewById(R.id.habitBearIcon);

        if(User.isFirst)
        {
            User.user.getDataFromDatabase(User.user.getId(), bearNameText, coins, currentStreakCount, highestStreakCount, bearImage);
        }
        else
        {
            LocalStore ls = new LocalStore(this);
            int id = ls.getData();
            User.user.getDataFromDatabase(id, bearNameText, coins, currentStreakCount, highestStreakCount, bearImage);
        }

        /*date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        compareDate = User.user.getCompareDate();
        if(!date.equals(compareDate)){
            compareDate = date;
            for (int i = 0; i < User.user.getHabitsArray().length ; i++) {
                User.user.getHabitsArray()[i].setDone(false);
            }
            User.user.setCompareDate(compareDate);
            User.user.updateDataToDatabase();
        }*/

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

        User.getDressed(bearImage);


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
            date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            compareDate = User.user.getCompareDate();
            if(!date.equals(compareDate)){
                compareDate = date;
                for (int i = 0; i < User.user.getHabitsArray().length ; i++) {
                    User.user.getHabitsArray()[i].setDone(false);
                }
                User.user.setCompareDate(compareDate);
                User.user.updateDataToDatabase();
            }
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
