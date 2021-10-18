package com.oop.lab.business_objets.builders;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.Vacancy;

import java.util.Date;

public class EmployeeBuilder implements IEmployeeBuilder {
    private Employee employee;

    @Override
    public IEmployeeBuilder create() {
        employee = new Employee();
        return this;
    }

    @Override
    public IEmployeeBuilder setRegistrationId(int id) {
        employee.setRegistrationId(id);
        return this;
    }

    @Override
    public IEmployeeBuilder addExperiencePoint(String role, int employmentDurationInMonth) {
        employee.addExperience(role, employmentDurationInMonth);
        return this;
    }

    @Override
    public IEmployeeBuilder setEducation(String education) {
        employee.setEducation(education);
        return this;
    }

    @Override
    public IEmployeeBuilder setDismissedDate(Date dismissedDate) {
        employee.setDismissedSince(dismissedDate);
        return this;
    }

    @Override
    public IEmployeeBuilder addSuitableVacancy(Vacancy vacancy) {
        employee.addSuitableVacancy(vacancy);
        return this;
    }

    @Override
    public Employee build() {
        return employee;
    }
}
