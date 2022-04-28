package com.oyku.habitbear.BackEnd;

import android.graphics.Color;

public class Clothes {

    private int price;
    private Account user;
    private Color color;
    private int type;
    private boolean purchased;


    
    public Clothes(int price, int type, Color color) {
        this.price = price;
        this.type = type;
        this.color = color;
        purchased = false;
    }

    public void set(Account aUser){
        this.user = aUser;
    }

    public String getName(){
        
        if (type == 0){
            return "Shirt";
        }
        else if (type == 1){
            return "Pant";
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
