import java.util.Calendar;
import java.awt.Color;
import java.time.LocalDate;


public class Account {
    

    // Properties

    private static int idCount;

    private int id;
    private int name;
    private int currentStreak;
    private int maxStreak;
    private Bear myBear;
    
    private Calendar date = Calendar.getInstance();// will be updated shortly



    private Habits[] myHabits;
    protected int coins;
    private Clothes[] myClothes;
    private Clothes[][] allClothes;




    public Account(){
        // get name from database

        // get idCount from database (last Account's id)
        id = idCount + 1; 
        // get current and max streak from database

        myBear = new Bear();


        setDate(date);
        
        currentStep = 0;
        absent = 0;

        

        myHabits = new Habits[6];
        myHabits[0] =new Habits("Workout");
        myHabits[1] =new Habits("Eat Healthy");
        myHabits[2] =new Habits("Quit Smoking");
        myHabits[3] =new Habits("Read Books");
        myHabits[4] =new Habits("Medicine");
        myHabits[5] =new Habits("Custom"); 
        for (Habits habits : myHabits) {
            habits.set(this);
        } 
         
        coins = 0;
        allClothes = new Clothes[3][4];
        importClothes();
        myClothes = new Clothes[3];  //[ Shirts, Pants, Accessories]

    }

    // METHODS 1
    public int isHabitDone(){
        int doneNo = 0;
        int habitNo = 0;
        for (int i = 0; i < myHabits.length; i++) {
            if (myHabits[i].isDone()) {
                doneNo++;
            }
            if (myHabits[i].isEnabled()) {
                habitNo++;
            }
        }
        if (doneNo == habitNo) {
            return 1;
        } 
        else if(doneNo == 0){
            return -1;
        }
        else {
            return 0;   
        }
    }



    public void addHabit(String str){
        if (!myHabits[5].isEnabled()) {
            myHabits[5].setName(str);
            myHabits[5].setEnabled(true);
        }
        else{
            System.out.println("A CUSTOM HABIT EXISTS. FIRST REMOVE IT.");
        }
    }

    public void removeHabit(){
        myHabits[5].setName("Custom");
        myHabits[5].setEnabled(false);
    }

    public void enableHabit(String str){

        for (Habits habits : myHabits) {
            if (habits.getName().toUpperCase().equals(str.toUpperCase())) {
                habits.setEnabled(true);
            }
        }
    }

    public void deEnableHabit(String str){

        for (Habits habits : myHabits) {
            if (habits.getName().toUpperCase().equals(str.toUpperCase())) {
                habits.setEnabled(false);
            }
        }
    }


    public void loseCoins(){   ////////////// WHY DO WE LOSE COINS THO?
        coins = coins - 5;
    }

    private void importClothes(){
        // Shirts
        allClothes[0][0] = new Clothes(10, 0, Color.RED);
        // Pants
        allClothes[1][0] = new Clothes(10, 1, Color.BLUE);
        // Accessories
        allClothes[2][0] = new Clothes(10, 2, Color.BLACK);
    }

    ///// parameters are the numbers of the clothes in  allClothes, u can update your bear's looks
    public void selectClothes(int shirt, int pant, int other){  
        myClothes[0] = allClothes[0][shirt];
        myClothes[1] = allClothes[1][pant];
        myClothes[2] = allClothes[2][other];
    }







    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Bear getMyBear() {
        return myBear;
    }

    public void setMyBear(Bear myBear) {
        this.myBear = myBear;
    }


    // DATE METHODS

    private void setDate(Calendar x) {
        LocalDate today = LocalDate.now();

        x.set(Calendar.YEAR , today.getYear());
        x.set(Calendar.MONTH , today.getMonthValue());
        x.set(Calendar.DAY_OF_MONTH , today.getDayOfMonth());
    }


    public int getDayOfMonth() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonthNum() {
        return date.get(Calendar.MONTH);
    }

    public int getYear() {
        return date.get(Calendar.YEAR);
    }



    // STREAKS

    public int getCurrentStreak() {
        return currentStreak;
    }


    public void updateCurrentStreak() {
        this.currentStreak++;
    }


    public int getMaxStreak() {
        return maxStreak;
    }


    public void updateMaxStreak() {
        if (maxStreak < currentStreak) {
            this.maxStreak = currentStreak;
        }
    }



    // Mountain

    public void addSteps(){
        currentStep++;
    }

   


     



    






}
