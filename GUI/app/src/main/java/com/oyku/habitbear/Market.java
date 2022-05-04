package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;
import com.oyku.habitbear.BackEnd.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Market extends AppCompatActivity implements View.OnClickListener {
    int coins;
    Clothes[][] clothes = User.user.allClothes;
    int clotheType;
    ImageView back;
    //public ImageView c1;
    ImageView bea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        back = findViewById(R.id.backMarket);
        back.setOnClickListener(this::onClick);
        User.c1 = findViewById(R.id.c1);
        User.c1.setOnClickListener(this::onClick);
        User.user.importClothes();
        /*c2 = findViewById(R.id.c2);
        c2.setOnClickListener(this::onClick);
        c3 = findViewById(R.id.c1);
        c3.setOnClickListener(this::onClick);*/
        bea = (ImageView) findViewById(R.id.blol);

    }

    //Click Listener Purchase Clothe Button

    public void purchaseClothes(Clothes clothes) {

        if (!clothes.isPurchased()) {
            if (clothes.canBeBought(User.user)) {
                for (int i = 0; i < User.user.getMyClothes()[clothes.getType()].length; i++) {
                    if (User.user.getMyClothes()[clothes.getType()][i] == null) {
                        User.user.getMyClothes()[clothes.getType()][i] = clothes;
                        User.user.getMyClothes()[clothes.getType()][i].setPurchased(true);
                        User.user.loseCoins();
                        //image.setColorFilter(Color.rgb(110,110,110));
                        break;
                    }
                }
            } else {
                Toast.makeText(this, "You don't have enough coins", Toast.LENGTH_LONG).show();
            }
        } else {
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
        /*else if(view.getId() == c1.getId())
        {
            clothes = (Clothes) c1.getTag();
            bea.setImageResource(R.mipmap.c1);
        }*/
        else if(view.getId() == User.c1.getId())
        {
            purchaseClothes((Clothes) User.c1.getTag());
        }

    }



}
