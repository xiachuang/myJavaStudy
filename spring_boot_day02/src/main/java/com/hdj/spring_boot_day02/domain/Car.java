package com.hdj.spring_boot_day02.domain;

import org.springframework.beans.factory.annotation.Value;

public class Car {
    @Value("1001")
    private  Integer id;
    @Value("BW")
    private String carName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                '}';
    }
}
