package com.example.demo.entity;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity(name = "Flower")
public class Flower
        extends Plant{

    private String color;


    public Flower() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Flower(String name, String color, BigDecimal price, Long id) {
         this.color = color;


    }

}
