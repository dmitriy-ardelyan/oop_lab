package com.oop.lab.controllers.agency;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.HumanResourcesAgency;
import com.oop.lab.controllers.data_storing.LongTermStoringService;

public class DefaultAgencyController implements IAgencyController {
    private final static int THE_ONE_WHO_MUST_NOT_BE_NAMED = 666;
    private HumanResourcesAgency humanResourcesAgency;
    private LongTermStoringService longTermStoringService;

    @Override
    public void readData() {
        this.humanResourcesAgency.setEmployees(longTermStoringService.readData());
    }

    @Override
    public IAgencyController assignLongTermStoringService(LongTermStoringService service) {
        this.longTermStoringService = service;
        return this;
    }

    @Override
    public IAgencyController assignAgency(HumanResourcesAgency humanResourcesAgency) {
        this.humanResourcesAgency = humanResourcesAgency;
        return this;
    }

    @Override
    public IAgencyController setupDefaultDataIfNeeded() {
        if (humanResourcesAgency.getEmployees().isEmpty()) {
            humanResourcesAgency.setupDefaultData();
            saveDataToJson();
        }
        return this;
    }

    @Override
    public IAgencyController saveDataToJson() {
        longTermStoringService.createFileIfNeeded().saveDataToFile(humanResourcesAgency);
        return this;
    }

    @Override
    public void add(Employee employee) {
        if (humanResourcesAgency.addEmployee(employee)) {
            System.out.println("Employee successfully added");
        } else {
            System.out.println("Employee already exists in HR Agency base");
        }
    }

    @Override
    public boolean delete(int id) {
        Employee employee =
                humanResourcesAgency
                        .getEmployees()
                        .stream()
                        .filter(e -> e.getRegistrationId() == id)
                        .findFirst()
                        .get();
        return humanResourcesAgency.deleteEmployee(employee);
    }

    @Override
    public void listAllEmployees() {
        for (Employee employee : humanResourcesAgency.getEmployees()) {
            if (employee.getRegistrationId() != THE_ONE_WHO_MUST_NOT_BE_NAMED) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public Employee findEmployee(int id) {
        return
                humanResourcesAgency
                        .getEmployees()
                        .stream()
                        .filter(employee -> employee.getRegistrationId() == id)
                        .findFirst()
                        .get();
    }
}
