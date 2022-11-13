package com.example.kwailitybakers.Models;

public class OrderModel {

    int orderImage;

    String soldItem ,price ,orderno;

    public OrderModel()
    {
        this.orderImage=orderImage;
        this.soldItem=soldItem;
        this.price=price;
        this.orderno=orderno;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(String soldItem) {
        this.soldItem = soldItem;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

}

