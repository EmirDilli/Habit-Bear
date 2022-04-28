package com.oyku.habitbear;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.oyku.habitbear.BackEnd.Account;

public class Register extends AppCompatActivity implements View.OnClickListener {
    String prevStarted = "yes";
    public Button button;
    public EditText editText;
    String bearName;
    Account registerAccount = new Account();

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            moveToHomepage();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        button = findViewById(R.id.startButton);
        button.setOnClickListener(this::onClick);
        editText = (EditText) findViewById(R.id.enterBearName);
    }
    public void onClick(View view)
    {
        Intent intent = new Intent(this, Homepage.class);
        bearName = editText.getText().toString();
        registerAccount.setName(bearName);
        intent.putExtra("Bear Name", bearName);
        startActivity(intent);
    }
    public void moveToHomepage(){
        Intent intent = new Intent(this,Homepage.class);
        startActivity(intent);
    }
}