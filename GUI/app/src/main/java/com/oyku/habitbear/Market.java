package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import com.oyku.habitbear.BackEnd.*;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Market extends AppCompatActivity implements View.OnClickListener {
    int coins;
    Clothes[][] clothes = User.user.allClothes;
    int clotheType;
    ImageView back;
    public ImageView bearsTshirt, bea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        back = findViewById(R.id.backMarket);
        back.setOnClickListener(this::onClick);

        //connecting images
        User.c1 = findViewById(R.id.c1);
        User.c2 = findViewById(R.id.c2);
        User.c3 = findViewById(R.id.c3);
        User.c4 = findViewById(R.id.c4);
        User.c5 = findViewById(R.id.c5);
        User.c6 = findViewById(R.id.c6);
        User.c7 = findViewById(R.id.c7);
        User.c8 = findViewById(R.id.c8);







        User.c1.setOnClickListener(this::onClick);
        User.c2.setOnClickListener(this::onClick);
        User.c3.setOnClickListener(this::onClick);
        User.c4.setOnClickListener(this::onClick);
        User.c5.setOnClickListener(this::onClick);
        User.c6.setOnClickListener(this::onClick);
        User.c7.setOnClickListener(this::onClick);
        User.c8.setOnClickListener(this::onClick);

        User.user.importClothes();



    }

    //Click Listener Purchase Clothe Button

    public void purchaseClothes(Clothes clothes) {

        if (!clothes.isPurchased()) {
            if (clothes.canBeBought(User.user)) {

                User.user.getMyClothes()[clothes.getType()][clothes.getColor()] = clothes;
                User.user.getMyClothes()[clothes.getType()][clothes.getColor()].setPurchased(true);
                User.user.loseCoins();
                Toast.makeText(this, "Purchase successful", Toast.LENGTH_LONG).show();
            }
         else {
            Toast.makeText(this, "You don't have enough coins", Toast.LENGTH_LONG).show();
        }
    }
        else {
            Toast.makeText(this, "You already have that clothing", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == back.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
        }
        else if(view.getId() == User.c1.getId())
        {
            purchaseClothes((Clothes) User.c1.getTag());
        }
        else if(view.getId() == User.c2.getId())
        {
            purchaseClothes((Clothes) User.c2.getTag());
        }
        else if(view.getId() == User.c3.getId())
        {
            purchaseClothes((Clothes) User.c3.getTag());
        }
        else if(view.getId() == User.c4.getId())
        {
            purchaseClothes((Clothes) User.c4.getTag());
        }
        else if(view.getId() == User.c5.getId())
        {
            purchaseClothes((Clothes) User.c5.getTag());
        }
        else if(view.getId() == User.c6.getId())
        {
            purchaseClothes((Clothes) User.c6.getTag());
        }
        else if(view.getId() == User.c7.getId())
        {
            purchaseClothes((Clothes) User.c7.getTag());
        }
        else if(view.getId() == User.c8.getId())
        {
            purchaseClothes((Clothes) User.c8.getTag());
        }



    }



}
