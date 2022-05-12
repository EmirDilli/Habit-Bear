package com.oyku.habitbear.BackEnd;

public class Mountain {
    private int mountainNo; // k 
    protected int stepNo;//2k+1
    protected int currStepNo;
    

    public Mountain(int no){
        mountainNo = no;
        stepNo = 2*mountainNo+1;
        currStepNo = 1;

    }

    public Mountain(){}


    // returns step of user
    public int mountainProgress(int streak){  
        int result = streak;
        for (int i = 0; i < mountainNo; i++) {
            result = result - (2*i + 1);
        }
        return result+1;
    }

    public int getMountainNo(){return this.mountainNo;}
    public void getData(MountainAccess ma){

        this.mountainNo = ma.mountainNo;
        this.currStepNo = ma.stepNo;

    }
    public void increaseMountNo()
    {
        if(mountainNo<3)
        mountainNo++;
    }
}
