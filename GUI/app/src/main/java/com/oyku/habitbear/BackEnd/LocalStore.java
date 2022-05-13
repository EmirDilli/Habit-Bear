package com.oyku.habitbear.BackEnd;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class LocalStore {

    SharedPreferences sp;

    public LocalStore(Context context){
        sp = context.getSharedPreferences("user_id",0);
    }

    // Stores user's id to local storage

    public void storeData(int id){

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("id",id);
        editor.commit();
        User.isFirst = true;
        Log.e("DATA","STORED");

    }

    // Gets user's id from local storage
    public int getData(){
        int id = sp.getInt("id",-1);
        return id;
    }
}