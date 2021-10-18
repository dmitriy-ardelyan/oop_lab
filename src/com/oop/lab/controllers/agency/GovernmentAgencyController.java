package com.oop.lab.controllers.agency;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.HumanResourcesAgency;
import com.oop.lab.controllers.data_storing.LongTermStoringService;

public class GovernmentAgencyController implements IAgencyController {
    private HumanResourcesAgency humanResourcesAgency;
    private LongTermStoringService longTermStoringService;

    @Override
    public void readData() {

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
        }
        return this;
    }

    @Override
    public IAgencyController saveDataToJson() {
        return this;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public boolean delete(int id) {

        return false;
    }

    @Override
    public void listAllEmployees() {

    }

    @Override
    public Employee findEmployee(int id) {
        return null;
    }

    @Override
    public IAgencyController assignLongTermStoringService(LongTermStoringService service) {
        this.longTermStoringService = service;
        return this;
    }

}
