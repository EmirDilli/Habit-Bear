package com.oyku.habitbear.BackEnd;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MountainAccess {

    public int mountainNo;
    public int stepNo;


    MountainAccess(Mountain mountain){

        this.mountainNo = mountain.getMountainNo();
        this.stepNo = mountain.currStepNo;

    }



    MountainAccess(){

    }


}
