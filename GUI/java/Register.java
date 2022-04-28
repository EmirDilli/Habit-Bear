package com.oyku.habitbear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText editText;
    String bearName;
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
        intent.putExtra("Bear Name", bearName);
        startActivity(intent);
    }
}