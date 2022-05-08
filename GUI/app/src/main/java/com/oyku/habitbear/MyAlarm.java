package com.oyku.habitbear;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.oyku.habitbear.BackEnd.User;

public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(User.user.getHabits().get(0).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(0).updateToday();
            }
            User.ch1.setChecked(false);
        }
        if(User.user.getHabits().get(1).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(1).updateToday();
            }
            User.ch1.setChecked(false);
        }
        if(User.user.getHabits().get(2).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(2).updateToday();
            }
            User.ch1.setChecked(false);
        }
        if(User.user.getHabits().get(3).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(3).updateToday();
            }
            User.ch1.setChecked(false);
        }
        if(User.user.getHabits().get(4).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(4).updateToday();
            }
            User.ch1.setChecked(false);
        }
        if(User.user.getHabits().get(5).isEnabled()){
            if(User.ch1.isChecked()){
                User.user.getHabits().get(5).updateToday();
            }
            User.ch1.setChecked(false);
        }
    }
}
