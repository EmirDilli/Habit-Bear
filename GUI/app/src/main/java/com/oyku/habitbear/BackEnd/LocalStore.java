package com.oyku.habitbear.BackEnd;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class LocalStore {

    SharedPreferences sp;

    public LocalStore(Context context){
        sp = context.getSharedPreferences("user_id",0);
    }

    public void storeData(int id){

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("id",id);
        editor.commit();
        User.isFirst = true;
        Log.e("DATA","STORED");

    }

    public int getData(){
        int id = sp.getInt("id",-1);
        return id;
    }
}