package com.oop.lab.business_objets;

import com.oop.lab.business_objets.builders.EmployeeBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class HumanResourcesAgency {
    HashSet<Employee> employees;

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public boolean deleteEmployee(Employee employee) {
        return employees.remove(employee);

    }
    public HumanResourcesAgency() {
        employees = new HashSet<>();
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(HashSet<Employee> employees) {
        this.employees = employees;
    }

    public HumanResourcesAgency setupDefaultData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Date dismissedDate = null;
        try {
            dismissedDate = sdf.parse("12/12/2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee firstEmployee =
                employeeBuilder
                        .create()
                        .setRegistrationId(1)
                        .setDismissedDate(dismissedDate)
                        .setEducation("Bachelor")
                        .addExperiencePoint("Magician", 10)
                        .addSuitableVacancy(new Vacancy("Magician", 100500, "Newzeland sorcerrer"))
                        .build();
        Employee secondEmployee =
                employeeBuilder
                        .create()
                        .setRegistrationId(2)
                        .setDismissedDate(dismissedDate)
                        .setEducation("Master")
                        .addExperiencePoint("Pilot", 33)
                        .addSuitableVacancy(new Vacancy("Pilot", 111, "Starship pilot"))
                        .build();
        Fisherman fisherman = new Fisherman();
        fisherman.setName("Bobby");
        fisherman.setRegistrationId(891);
        fisherman.setEducation("None");

        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(fisherman);

        return this;
    }
}
