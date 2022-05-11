package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oyku.habitbear.BackEnd.User;

import java.util.ArrayList;

public class Step7 extends AppCompatActivity implements  View.OnClickListener {

    protected static int habitNo;
    ImageView h1, h2, h3, h4, h5, h6, h7, c1, c2, c3, c4, c5, c6, c7;
    ArrayList<TextView> textViews = new ArrayList<TextView>();
    TextView t1,t2,t3,t4,t5,t6,t7;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step7);



        int mountainNo = User.user.getHabits().get(habitNo).getMountain().getMountainNo();
        int streak = User.user.getHabits().get(habitNo).getStreak();
        int stepNo = User.user.getHabits().get(habitNo).getMountain().mountainProgress(streak);
        Integer[] list = User.list;



        h1 = (ImageView) findViewById(R.id.pos1);
        h2 = (ImageView) findViewById(R.id.pos2);
        h3 = (ImageView) findViewById(R.id.pos3);
        h4 = (ImageView) findViewById(R.id.pos4);
        h5 = (ImageView) findViewById(R.id.pos5);
        h6 = (ImageView) findViewById(R.id.pos6);
        h7 = (ImageView) findViewById(R.id.pos7);


        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);
        h6.setVisibility(View.INVISIBLE);
        h7.setVisibility(View.INVISIBLE);


        // Connects xml file to java
        t1 = (TextView) findViewById(R.id.bearNo1);
        t2 = (TextView) findViewById(R.id.bearNo2);
        t3 = (TextView) findViewById(R.id.bearNo3);
        t4 = (TextView) findViewById(R.id.bearNo4);
        t5 = (TextView) findViewById(R.id.bearNo5);
        t6 = (TextView) findViewById(R.id.bearNo6);
        t7 = (TextView) findViewById(R.id.bearNo7);


        c1 = (ImageView) findViewById(R.id.head1);
        c2 = (ImageView) findViewById(R.id.head2);
        c3 = (ImageView) findViewById(R.id.head3);
        c4 = (ImageView) findViewById(R.id.head4);
        c5 = (ImageView) findViewById(R.id.head5);
        c6 = (ImageView) findViewById(R.id.head6);
        c7 = (ImageView) findViewById(R.id.head7);

        // for db
        textViews.add(t1);
        textViews.add(t2);
        textViews.add(t3);
        textViews.add(t4);
        textViews.add(t5);
        textViews.add(t6);
        textViews.add(t7);

        User.getCurrentNumbers(mountainNo, habitNo, textViews);

        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);
        h6.setVisibility(View.INVISIBLE);
        h7.setVisibility(View.INVISIBLE);


        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
        c3.setVisibility(View.VISIBLE);
        c4.setVisibility(View.VISIBLE);
        c5.setVisibility(View.VISIBLE);
        c6.setVisibility(View.VISIBLE);
        c7.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        t5.setVisibility(View.VISIBLE);
        t6.setVisibility(View.VISIBLE);
        t7.setVisibility(View.VISIBLE);

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
        else if(stepNo == 5){
            h5.setVisibility(View.VISIBLE);
        }
        else if(stepNo == 6){
            h6.setVisibility(View.VISIBLE);
        }
        else {
            h7.setVisibility(View.VISIBLE);
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