public class Mountain {
    private int mountainNo; // k 
    protected int stepNo; //2k+1 
    

    public Mountain(int no){
        mountainNo = no;
        stepNo = 2*mountainNo+1;
    }

    // returns step of user
    public int mountainProgress(int streak){  
        int result = streak;
        for (int i = 0; i < mountainNo; i++) {
            result = result - (2*i + 1);
        }
        return result;
    }

}
