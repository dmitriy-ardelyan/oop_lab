package com.oop.lab.controllers.agency;

public class AgencyControllerFactory {

    public IAgencyController getAgencyController(String agencyControllerType) {
        if (agencyControllerType.equalsIgnoreCase("g")) {
            return new GovernmentAgencyController();
        } else {
            return new DefaultAgencyController();
        }
    }
}
