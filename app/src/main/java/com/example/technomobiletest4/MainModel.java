package com.example.technomobiletest4;

public class MainModel {

    String brand,pmodel,mpurl,price,storage;

    MainModel()
    {

    }
    public MainModel(String brand, String pmodel, String mpurl, String price, String storage) {
        this.brand = brand;
        this.pmodel = pmodel;
        this.mpurl = mpurl;
        this.price = price;
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPmodel() {
        return pmodel;
    }

    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }

    public String getMpurl() {
        return mpurl;
    }

    public void setMpurl(String mpurl) {
        this.mpurl = mpurl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
