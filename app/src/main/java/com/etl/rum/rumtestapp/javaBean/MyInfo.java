package com.etl.rum.rumtestapp.javaBean;

public class MyInfo {
    private String address;
    private String name;

    public MyInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public MyInfo() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
