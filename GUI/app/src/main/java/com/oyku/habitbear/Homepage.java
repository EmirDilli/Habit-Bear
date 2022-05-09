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
    ImageView settings, bearImage;
    TextView bearNameText, highestStreakCount, currentStreakCount, coins;
    String bearsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        bearNameText = (TextView) findViewById(R.id.bearName);
        currentStreakCount = (TextView) findViewById(R.id.currentStreakCount);
        highestStreakCount = (TextView) findViewById(R.id.highestStreakCount);
        coins = (TextView) findViewById(R.id.coinCount);
        User.user.getDataFromDatabase(3, bearNameText, coins, currentStreakCount, highestStreakCount);
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
        bearImage = findViewById(R.id.habitBearIcon);

        if (User.redTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redredmus);
        } else if (User.redTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redredglass);
        } else if (User.redTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redgreenglass);
        } else if (User.redTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redgreenmus);
        } else if (User.redTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redblueglass);
        } else if (User.redTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redbluemus);
        } else if (User.greenTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greenredmus);
        } else if (User.greenTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greenredglass);
        }  else if (User.greenTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greengreenmus);
        } else if (User.greenTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greengreenglass);
        } else if (User.greenTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greenbluemus);
        } else if (User.greenTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greenblueglass);
        }else if (User.blueTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.blueredmus);
        } else if (User.blueTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueredglass);
        } else if (User.blueTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluegreenmus);
        } else if (User.blueTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.bluegreenglass);
        }  else if (User.blueTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluebluemus);
        } else if (User.blueTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueblueglass);
        }else if (User.redTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.redred);
        } else if (User.redTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.redgreen);
        }else if (User.redTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.redblue);
        }else if (User.greenTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.greenred);
        }else if (User.greenTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.greengreen);
        } else if (User.greenTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.greenblue);
        } else if (User.blueTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.bluered);
        } else if (User.blueTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.bluegreen);
        } else if (User.blueTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.blueblue);
        }
        else if (User.redTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.redmus);
        }else if (User.redTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.redglass);
        }else if (User.greenTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayigreenmus);
        }else if (User.greenTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayigreenglass);
        } else if (User.blueTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluemus);
        } else if (User.blueTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueglass);
        }
        else if(User.redPants && User.moustache)
        {
            bearImage.setImageResource((R.mipmap.ayiredpantsmus));
        }
        else if (User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayiglassredpants);
        } else if (User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayigreenpantsmus);
        } else if (User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayigreenpantsglass);
        }
        else if (User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayi31);
        } else if (User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayibluepantsglass);
        }
        else if(User.redTshirt)
        {
            bearImage.setImageResource(R.mipmap.red);
        }
        else if(User.greenTshirt)
        {
            bearImage.setImageResource(R.mipmap.ayigreen);}
        else if(User.blueTshirt)
        {
            bearImage.setImageResource(R.mipmap.ayiblue);}
        else if(User.redPants)
        {
            bearImage.setImageResource(R.mipmap.ayiredpants);}
        else if(User.greenPants)
        {
            bearImage.setImageResource(R.mipmap.ayigreenpants);}
        else if(User.bluePants)
        {
            bearImage.setImageResource(R.mipmap.ayibluepants);}
        else if(User.moustache)
        {
            bearImage.setImageResource(R.mipmap.ayimus);}
        else if(User.glasses)
        {
            bearImage.setImageResource(R.mipmap.ayiglass);}


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
