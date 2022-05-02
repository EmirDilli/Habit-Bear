package com.oyku.habitbear.BackEnd;

import android.graphics.Color;

public class Clothes {

    private int price;
    private Account user;
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

    public void set(Account aUser){
        this.user = aUser;
    }

    public Account getAccount(){return this.user;}

    public String getName(){
        
        if (type == 0){
            return "Shirt";
        }
        else if (type == 1){
            return "Pants";
        }
        else {
            return "Accessory";
        }
    }

    public boolean hasMoney(){
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
