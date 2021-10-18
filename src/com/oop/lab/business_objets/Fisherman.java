package com.oop.lab.business_objets;

public class Fisherman extends Employee{
    private String name;

    @Override
    public String toString() {
        return super.toString() + "Fisherman{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
