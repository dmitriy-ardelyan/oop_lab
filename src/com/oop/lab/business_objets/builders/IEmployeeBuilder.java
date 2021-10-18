package com.oop.lab.business_objets.builders;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.Vacancy;

import java.util.Date;

public interface IEmployeeBuilder {
    IEmployeeBuilder create();
    IEmployeeBuilder setRegistrationId(int id);
    IEmployeeBuilder addExperiencePoint(String role, int employmentDurationInMonth);
    IEmployeeBuilder setEducation(String education);
    IEmployeeBuilder setDismissedDate(Date dismissedDate);
    IEmployeeBuilder addSuitableVacancy(Vacancy vacancy);
    Employee build();
}
