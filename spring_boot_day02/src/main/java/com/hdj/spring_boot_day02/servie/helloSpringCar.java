package com.hdj.spring_boot_day02.servie;

public class helloSpringCar {
    private  Integer id;

    @Override
    public String toString() {
        return "helloSpringCar{" +
                "id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public helloSpringCar() {
        super();
    }
}
