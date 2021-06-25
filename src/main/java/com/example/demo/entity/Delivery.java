package com.example.demo.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Delivery.findByName",
                query = "select d from Delivery d where d.name=:name"),
})
@Entity
public class Delivery {

    @Nationalized
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    List<Plant> plants;


    public List<Plant> getPlants() {
        return plants;
    }

    public void setFlowerList(List<Plant> plant) {
        this.plants = plant;
    }


    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDate delivery_date;
    private LocalTime delivery_time;
    @Type(type = "yes_no")
    @ColumnDefault("false")
    private Boolean completed;

    @Id
    @GeneratedValue
    private Long id;


    public Delivery(String name, String address, LocalDate delivery_date, LocalTime delivery_time, boolean deliveryStatus) {
        this.name = name;
        this.address = address;
        this.delivery_date = delivery_date;
        this.delivery_time = delivery_time;
        this.completed = deliveryStatus;
    }

    public Delivery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }

    public LocalTime getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(LocalTime delivery_time) {
        this.delivery_time = delivery_time;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean deliveryStatus) {
        this.completed = deliveryStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
