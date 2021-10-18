package com.oop.lab.business_objets;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Employee {

    private int registrationId;
    private HashMap<String, Integer> experience;
    private String education;
    private Date dismissedSince;
    private ArrayList<Vacancy> suitableVacancies;

    public void addSuitableVacancy(Vacancy vacancy) {
        suitableVacancies.add(vacancy);
    }

    public void addExperience(String role, int employmentDurationInMonth) {
        experience.put(role, employmentDurationInMonth);
    }

    public Employee() {
        experience = new HashMap<>();
        suitableVacancies = new ArrayList<>();
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getDismissedSince() {
        return dismissedSince;
    }

    public void setDismissedSince(Date dismissedSince) {
        this.dismissedSince = dismissedSince;
    }

    public Employee(int registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return registrationId == employee.registrationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "registrationId=" + registrationId +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", dismissedSince=" + dismissedSince +
                ", suitableVacancies=" + suitableVacancies +
                '}';
    }
}
