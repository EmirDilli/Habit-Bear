package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.oyku.habitbear.BackEnd.*;

public class Inventory extends AppCompatActivity {
    private Clothes clothes;
    private int type;
    private int whichClotheInType;
    private Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        //clickListener to wear clothe when its selected
            clothes = account.getMyClothes()[type][whichClotheInType];
    }
}