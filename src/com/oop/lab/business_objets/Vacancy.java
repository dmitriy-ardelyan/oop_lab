package com.oop.lab.business_objets;

public class Vacancy {
    String speciality;
    double minimalSalary;
    String description;

    public Vacancy() {
    }

    public Vacancy(String speciality, double minSalaray, String description) {
        this.speciality = speciality;
        this.minimalSalary = minSalaray;
        this.description = description;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getMinimalSalary() {
        return minimalSalary;
    }

    public void setMinimalSalary(double minimalSalary) {
        this.minimalSalary = minimalSalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
