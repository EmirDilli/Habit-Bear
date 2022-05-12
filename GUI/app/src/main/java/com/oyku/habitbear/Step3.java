package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oyku.habitbear.BackEnd.User;

import java.util.ArrayList;

public class Step3 extends AppCompatActivity implements View.OnClickListener{

    protected static int habitNo;
    ImageView h1, h2, h3, c1, c2, c3;
    ArrayList<TextView> textViews = new ArrayList<TextView>();
    TextView t1,t2,t3;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3);



        int mountainNo = User.user.getHabits().get(habitNo).getMountain().getMountainNo();
        int streak = User.user.getHabits().get(habitNo).getStreak();
        int stepNo = User.user.getHabits().get(habitNo).getMountain().mountainProgress(streak);
        Integer[] list = User.list;

        t1 = (TextView) findViewById(R.id.firstText);
        t2 = (TextView) findViewById(R.id.secondText);
        t3 = (TextView) findViewById(R.id.ThirdText);
        h1 = (ImageView) findViewById(R.id.pos1);
        h2 = (ImageView) findViewById(R.id.pos2);
        h3 = (ImageView) findViewById(R.id.pos3);

        User.user.getDataFromDatabase(User.user.getId(), h1);
        User.getDressed(h1);
        User.user.getDataFromDatabase(User.user.getId(), h2);
        User.getDressed(h2);
        User.user.getDataFromDatabase(User.user.getId(), h3);
        User.getDressed(h3);

        c1 = (ImageView) findViewById(R.id.firstHead);
        c2 = (ImageView) findViewById(R.id.secondHead);
        c3 = (ImageView) findViewById(R.id.thirdHead);
        textViews.add(t1); textViews.add(t2); textViews.add(t3);
        User.getCurrentNumbers(mountainNo, habitNo, textViews);
        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);

        if (stepNo == 1){
            h1.setVisibility(View.VISIBLE);
            h2.setVisibility(View.INVISIBLE);
            h3.setVisibility(View.INVISIBLE);
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.INVISIBLE);
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.INVISIBLE);
        }
        else if (stepNo == 2){
            h1.setVisibility(View.INVISIBLE);
            h2.setVisibility(View.VISIBLE);
            h3.setVisibility(View.INVISIBLE);
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
        }
        else{
            h1.setVisibility(View.VISIBLE);
            h2.setVisibility(View.INVISIBLE);
            h3.setVisibility(View.INVISIBLE);
            c1.setVisibility(View.INVISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
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