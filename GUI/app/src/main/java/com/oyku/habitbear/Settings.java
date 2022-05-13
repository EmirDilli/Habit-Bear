package com.oyku.habitbear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.oyku.habitbear.BackEnd.User;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    EditText changeName;
    String newName;
    Button done;

    // connects this class with the xml file

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ImageView back = findViewById(R.id.backSettings);
        back.setOnClickListener(this::onClick);
        changeName = findViewById(R.id.enterNewName);
        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            // changes user's name when clicked
            @Override
            public void onClick(View view) {
                newName = changeName.getText().toString();
                User.user.setName(newName);
                Toast.makeText(getBaseContext(), "You successfully changed your name!", Toast.LENGTH_LONG).show();
                User.user.updateDataToDatabase();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}