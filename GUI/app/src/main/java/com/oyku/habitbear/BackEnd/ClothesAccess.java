package com.oyku.habitbear.BackEnd;

public class ClothesAccess {

    public int price;
    public int color;
    public int type;
    public boolean purchased;

    ClothesAccess(){

    }

    ClothesAccess(Clothes cloth){

        this.price = cloth.getPrice();
        this.purchased = cloth.isPurchased();
        this.color = cloth.getColor();
        this.type = cloth.getType();

    }

}
