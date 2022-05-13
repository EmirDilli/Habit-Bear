package com.oyku.habitbear.BackEnd;

public class ClothesAccess {

    public int price;
    public int color;
    public int type;
    public boolean purchased;

    ClothesAccess(){
        // formed to get data from the database
    }

    // sets the instance variables of this class according to given user
    ClothesAccess(Clothes cloth){

        this.price = cloth.getPrice();
        this.purchased = cloth.isPurchased();
        this.color = cloth.getColor();
        this.type = cloth.getType();

    }

}
