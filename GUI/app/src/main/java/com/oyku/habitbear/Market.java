package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import com.oyku.habitbear.BackEnd.*;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.awt.*;

public class Market extends AppCompatActivity implements View.OnClickListener{
    int coins;
    Clothes clothes;
    int clotheType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        ImageView back = findViewById(R.id.backMarket);
        back.setOnClickListener(this::onClick);



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
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }



}
