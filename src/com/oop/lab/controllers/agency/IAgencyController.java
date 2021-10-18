package com.oop.lab.controllers.agency;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.HumanResourcesAgency;
import com.oop.lab.controllers.data_storing.LongTermStoringService;

public interface IAgencyController {

    void readData();

    IAgencyController assignAgency(HumanResourcesAgency humanResourcesAgency);
    IAgencyController assignLongTermStoringService(LongTermStoringService service);
    IAgencyController setupDefaultDataIfNeeded();
    IAgencyController saveDataToJson();

    void add(Employee employee);
    boolean delete(int id);
    void listAllEmployees();
    Employee findEmployee(int id);
}
