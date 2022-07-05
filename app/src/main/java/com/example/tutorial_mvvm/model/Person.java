package com.example.tutorial_mvvm.model;

public class Person {
    int imgAvt;
    String name;
    String title;

    public Person(int imgAvt, String name, String title) {
        this.imgAvt = imgAvt;
        this.name = name;
        this.title = title;
    }

    public int getImgAvt() {
        return imgAvt;
    }

    public void setImgAvt(int imgAvt) {
        this.imgAvt = imgAvt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
