package com.oyku.habitbear.BackEnd;

import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.oyku.habitbear.HabitsPage;
import com.oyku.habitbear.R;

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
    public static void getCurrentNumbers(int mountainNo, int habitNo){

        User.list = new Integer[2*mountainNo + 1];
        for(int i = 0; i < User.list.length; i++)
        {
            User.list[i] = 0;
        }
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("User");

        dr.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                for (DataSnapshot ds : task.getResult().getChildren()) {

                    long mountNo = (long)ds.child("habits").child(String.valueOf(habitNo)).child("mountain").child("mountainNo").getValue();

                    if(mountainNo == (int)mountNo){

                        long streak = (long)ds.child("habits").child(String.valueOf(habitNo)).child("streak").getValue();
                        int stepNo = User.mountainProgress((int)streak,(int)mountNo);

                        User.list[stepNo - 1]++;
                    }

                }
            }
        });
    }
    public static void getDressed(ImageView bearImage)
    {
        if (User.redTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redredmus);
        } else if (User.redTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redredglass);
        } else if (User.redTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redgreenglass);
        } else if (User.redTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redgreenmus);
        } else if (User.redTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.redblueglass);
        } else if (User.redTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.redbluemus);
        } else if (User.greenTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greenredmus);
        } else if (User.greenTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greenredglass);
        }  else if (User.greenTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greengreenmus);
        } else if (User.greenTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greengreenglass);
        } else if (User.greenTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.greenbluemus);
        } else if (User.greenTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.greenblueglass);
        }else if (User.blueTshirt && User.redPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.blueredmus);
        } else if (User.blueTshirt && User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueredglass);
        } else if (User.blueTshirt && User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluegreenmus);
        } else if (User.blueTshirt && User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.bluegreenglass);
        }  else if (User.blueTshirt && User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluebluemus);
        } else if (User.blueTshirt && User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueblueglass);
        }else if (User.redTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.redred);
        } else if (User.redTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.redgreen);
        }else if (User.redTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.redblue);
        }else if (User.greenTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.greenred);
        }else if (User.greenTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.greengreen);
        } else if (User.greenTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.greenblue);
        } else if (User.blueTshirt && User.redPants) {
            bearImage.setImageResource(R.mipmap.bluered);
        } else if (User.blueTshirt && User.greenPants) {
            bearImage.setImageResource(R.mipmap.bluegreen);
        } else if (User.blueTshirt && User.bluePants) {
            bearImage.setImageResource(R.mipmap.blueblue);
        }
        else if (User.redTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.redmus);
        }else if (User.redTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.redglass);
        }else if (User.greenTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayigreenmus);
        }else if (User.greenTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayigreenglass);
        } else if (User.blueTshirt && User.moustache) {
            bearImage.setImageResource(R.mipmap.bluemus);
        } else if (User.blueTshirt && User.glasses) {
            bearImage.setImageResource(R.mipmap.blueglass);
        }
        else if(User.redPants && User.moustache)
        {
            bearImage.setImageResource((R.mipmap.ayiredpantsmus));
        }
        else if (User.redPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayiglassredpants);
        } else if (User.greenPants && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayigreenpantsmus);
        } else if (User.greenPants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayigreenpantsglass);
        }
        else if (User.bluePants && User.moustache) {
            bearImage.setImageResource(R.mipmap.ayi31);
        } else if (User.bluePants && User.glasses) {
            bearImage.setImageResource(R.mipmap.ayibluepantsglass);
        }
        else if(User.redTshirt)
        {
            bearImage.setImageResource(R.mipmap.red);
        }
        else if(User.greenTshirt)
        {
            bearImage.setImageResource(R.mipmap.ayigreen);}
        else if(User.blueTshirt)
        {
            bearImage.setImageResource(R.mipmap.ayiblue);}
        else if(User.redPants)
        {
            bearImage.setImageResource(R.mipmap.ayiredpants);}
        else if(User.greenPants)
        {
            bearImage.setImageResource(R.mipmap.ayigreenpants);}
        else if(User.bluePants)
        {
            bearImage.setImageResource(R.mipmap.ayibluepants);}
        else if(User.moustache)
        {
            bearImage.setImageResource(R.mipmap.ayimus);}
        else if(User.glasses)
        {
            bearImage.setImageResource(R.mipmap.ayiglass);}
    }



}
