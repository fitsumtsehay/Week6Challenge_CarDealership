package com.example.demo;
// OneToMany relationship with Car.java

import javax.persistence.*;
import java.util.Set;
import javax.validation.constraints.NotNull;

@Entity
public class CarCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String type;

    //empty constructor

    public CarCategory() {
    }


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Car> cars;


    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }



    }



