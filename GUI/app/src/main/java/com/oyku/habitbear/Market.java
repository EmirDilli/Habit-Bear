package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import com.oyku.habitbear.BackEnd.*;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.awt.*;

public class Market extends AppCompatActivity implements View.OnClickListener{
    int coins;
    Clothes clothes;
    int clotheType;
    ImageView back;
    ImageView clothe1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        back = findViewById(R.id.backMarket);
        back.setOnClickListener(this::onClick);
        clothe1 = findViewById(R.id.clothe1);
        clothe1.setOnClickListener(this::onClick);



        //Click Listener Purchase Clothe Button

        if(!clothes.isPurchased()) {
            if (clothes.hasMoney()) {
                clothes.getAccount().loseCoins();
                for (int i = 0; i < clothes.getAccount().getMyClothes()[clotheType].length; i++) {
                    if(clothes.getAccount().getMyClothes()[clotheType][i].equals(null)){
                        clothes.getAccount().getMyClothes()[clotheType][i] = clothes;
                        break;
                    }
                }


            }
            else {
                //text editor
                String warning = "Not Enough Coins";
            }
        }
        else{
            //text editor
            String alreadyPurchaesed = "You already has the clothe";
        }


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == back.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
        }
        else if(view.getId() == clothe1.getId())
        {
            clothes = (Clothes) Account.cl.getTag();
            //resim değişecek
        }
    }



}