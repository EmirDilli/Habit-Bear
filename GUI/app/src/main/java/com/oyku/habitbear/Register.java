package com.oyku.habitbear;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.oyku.habitbear.BackEnd.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity{ //implements View.OnClickListener {
    String prevStarted = "yes";
    public Button button;
    public EditText editText;
    public Account registerAccount = new Account();
    String bearName;
    Intent initial;

   @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            //User.user.setId(tevfikten kullanıcı sayısı + 1);
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
        editText = (EditText) findViewById(R.id.enterBearName);
        User.user = registerAccount;

        button = findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initial = new Intent(Register.this, Homepage.class);
                bearName = editText.getText().toString();
                User.user.setName(bearName);
                User.user.addNewDataToDatabase();
                /*DatabaseReference er = FirebaseDatabase.getInstance().getReference("Tevfik");
                er.child("1").setValue(User.user.getName());*/
                startActivity(initial);
            }
        });

   }

    public void moveToHomepage(){
        Intent intent = new Intent(Register.this, Homepage.class);
        startActivity(intent);
    }
}