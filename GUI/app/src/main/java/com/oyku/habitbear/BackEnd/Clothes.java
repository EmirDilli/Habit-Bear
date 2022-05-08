package com.oyku.habitbear.BackEnd;

public class Clothes {

    private int price;
    private int color;
    private int type;
    private boolean purchased;

    //Color codes: 0-red, 1-blue, 2-green
    public Clothes(int price, int type, int color) {
        this.price = price;
        this.type = type;
        this.color = color;
        purchased = false;
    }

    public Clothes(){}

    public String getName(){
        
        if (type == 0){
            return "Shirt";
        }
        else if (type == 1){
            return "Pants";
        }
        else if (type == 2){
            return "Accessory";
        }
        else
        {
            return "Null";
        }
    }

    public boolean canBeBought(Account user){
        if (user.coins >= price) {
            return true;
        }
        return false;
    }


    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {return type;}

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void getData(ClothesAccess ma){

        this.type = ma.type;
        this.price = ma.price;
        this.color = ma.color;
        this.purchased = ma.purchased;

    }
}
