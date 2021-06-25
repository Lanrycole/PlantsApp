package com.example.demo.entity;

import javax.persistence.Entity;

@Entity(name = "Shrub")
public class Shrub extends Plant {

    private String height;
    private String width;

    public Shrub() {

    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Shrub(String height, String width) {
        this.height = height;
        this.width = width;
    }
}
