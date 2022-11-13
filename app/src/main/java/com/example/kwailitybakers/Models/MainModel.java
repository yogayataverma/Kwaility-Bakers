package com.example.kwailitybakers.Models;

public class MainModel {
    int image;
    String name , price , desci;

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDesci(String desci) {
        this.desci= desci;
    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDesci() {
        return desci;
    }

    public MainModel(int image, String name , String price , String desci) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.desci = desci;
    }
}
