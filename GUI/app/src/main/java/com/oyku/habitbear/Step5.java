package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oyku.habitbear.BackEnd.User;

import java.util.ArrayList;

public class Step5 extends AppCompatActivity implements View.OnClickListener{

    protected static int habitNo;
    ImageView h1, h2, h3, h4, h5, c1, c2, c3, c4, c5;
    ArrayList<TextView> textViews = new ArrayList<TextView>();
    TextView t1,t2,t3,t4,t5;
    ImageView back;

    // connects this class with the xml file

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

        // Connects xml file to java
        t1 = (TextView) findViewById(R.id.bearNo1);
        t2 = (TextView) findViewById(R.id.bearNo2);
        t3 = (TextView) findViewById(R.id.bearNo3);
        t4 = (TextView) findViewById(R.id.bearNo4);
        t5 = (TextView) findViewById(R.id.bearNo5);

        h1 = (ImageView) findViewById(R.id.pos1);
        h2 = (ImageView) findViewById(R.id.pos2);
        h3 = (ImageView) findViewById(R.id.pos3);
        h4 = (ImageView) findViewById(R.id.pos4);
        h5 = (ImageView) findViewById(R.id.pos5);

        c1 = (ImageView) findViewById(R.id.head1);
        c2 = (ImageView) findViewById(R.id.head2);
        c3 = (ImageView) findViewById(R.id.head3);
        c4 = (ImageView) findViewById(R.id.head4);
        c5 = (ImageView) findViewById(R.id.head5);

        // gets no of users in mountain steps from database
        textViews.add(t1);
        textViews.add(t2);
        textViews.add(t3);
        textViews.add(t4);
        textViews.add(t5);
        User.getCurrentNumbers(mountainNo, habitNo, textViews);

        h1.setVisibility(View.INVISIBLE);
        h2.setVisibility(View.INVISIBLE);
        h3.setVisibility(View.INVISIBLE);
        h4.setVisibility(View.INVISIBLE);
        h5.setVisibility(View.INVISIBLE);

        User.user.getDataFromDatabase(User.user.getId(), h1);
        User.getDressed(h1);
        User.user.getDataFromDatabase(User.user.getId(), h2);
        User.getDressed(h2);
        User.user.getDataFromDatabase(User.user.getId(), h3);
        User.getDressed(h3);
        User.user.getDataFromDatabase(User.user.getId(), h4);
        User.getDressed(h4);
        User.user.getDataFromDatabase(User.user.getId(), h5);
        User.getDressed(h5);


        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
        c3.setVisibility(View.VISIBLE);
        c4.setVisibility(View.VISIBLE);
        c5.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        t5.setVisibility(View.VISIBLE);

        // sets ImageView of the bear visible according to step no

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