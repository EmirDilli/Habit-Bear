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
    Clothes clothes = new Clothes(10, 10, Color.RED);
    Account account = new Account();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
        ImageView back = findViewById(R.id.backMarket);
        back.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }



}
