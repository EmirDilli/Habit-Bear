package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.oyku.habitbear.BackEnd.User;

public class Step5 extends AppCompatActivity implements View.OnClickListener{

    protected static int habitNo;
    ImageView h1, h2, h3, h4, h5;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step5);



        int mountainNo = User.user.getHabits().get(habitNo).getMountain().getMountainNo();
        int streak = User.user.getHabits().get(habitNo).getStreak();
        int stepNo = User.user.getHabits().get(habitNo).getMountain().mountainProgress(streak);
        Integer[] list = User.list;



        h1 = (ImageView) findViewById(R.id.pos1);
        h2 = (ImageView) findViewById(R.id.pos2);
        h3 = (ImageView) findViewById(R.id.pos3);
        h4 = (ImageView) findViewById(R.id.pos4);
        h5 = (ImageView) findViewById(R.id.pos5);


        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);

        if (stepNo == 1){
            h1.setVisibility(View.VISIBLE);
        }
        else if (stepNo == 2){
            h2.setVisibility(View.VISIBLE);
        }
        else if(stepNo == 3){
            h3.setVisibility(View.VISIBLE);
        }
        else if(stepNo == 4){
            h4.setVisibility(View.VISIBLE);
        }
        else {
            h5.setVisibility(View.VISIBLE);
        }

        for (int i = 1; i <= 2*mountainNo + 1; i++) {
            // ayi kafasi koy
            // string = list[ i + streak - stepNo];
        }

        back = findViewById(R.id.backMountain);
        back.setOnClickListener(this::onClick);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == back.getId())
        {
            Intent intent = new Intent(this, HabitsPage.class);
            startActivity(intent);
            User.user.updateDataToDatabase();
        }
    }
}