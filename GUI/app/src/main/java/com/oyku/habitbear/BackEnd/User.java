package com.oyku.habitbear.BackEnd;

import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static Account user = new Account();
    public static ImageView c1 = null;
    public static ImageView c2= null;
    public static ImageView c3 = null;
    public static ImageView c4 = null;
    public static ImageView c5 = null;
    public static ImageView c6 = null;
    public static ImageView c7 = null;
    public static ImageView c8 = null;
    public static ImageView p1 = null;
    public static ImageView p2= null;
    public static ImageView p3 = null;
    public static ImageView p4 = null;
    public static ImageView p5 = null;
    public static ImageView p6 = null;
    public static ImageView p7 = null;
    public static ImageView p8 = null;

    public static CheckBox ch1;
    public static CheckBox ch2;
    public static CheckBox ch3;
    public static CheckBox ch4;
    public static CheckBox ch5;
    public static CheckBox ch6;
    public static ImageView h1;
    public static ImageView h2;
    public static ImageView h3;
    public static ImageView h4;
    public static ImageView h5;
    public static ImageView h6;

    public static boolean redTshirt = false;
    public static boolean greenTshirt = false;
    public static boolean blueTshirt = false;
    public static boolean redPants = false;
    public static boolean greenPants = false;
    public static boolean bluePants = false;
    public static boolean moustache = false;
    public static boolean glasses = false;

    public static Integer[] list;

    public static int mountainProgress(int streak, int mountainNo){

        int result = streak;
        for (int i = 0; i < mountainNo; i++) {
            result = result - (2*i + 1);
        }
        return result+1;
    }
    public void getCurrentNumbers(int mountainNo, int habitNo){

        User.list = new Integer[2*mountainNo + 1];
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("User");

        dr.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                for (DataSnapshot ds : task.getResult().getChildren()) {

                    long mountNo = (long)ds.child("habits").child(String.valueOf(habitNo)).child("mountain").child("mountainNo").getValue();

                    if(mountainNo == (int)mountNo){

                        long streak = (long)ds.child("habits").child(String.valueOf(habitNo)).child("streak").getValue();
                        int stepNo = User.mountainProgress((int)streak,(int)mountNo);

                        User.list[stepNo]++;
                    }

                }
            }
        });
    }


}
