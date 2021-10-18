package com.oop.lab.main;

import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.HumanResourcesAgency;
import com.oop.lab.business_objets.Vacancy;
import com.oop.lab.controllers.agency.AgencyControllerFactory;
import com.oop.lab.controllers.agency.DefaultAgencyController;
import com.oop.lab.controllers.agency.IAgencyController;
import com.oop.lab.controllers.data_storing.LongTermStoringService;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Human Resources Agency system");
        System.out.println("Select agency type default - D; Government - G");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        HumanResourcesAgency humanResourcesAgency = new HumanResourcesAgency();

        AgencyControllerFactory agencyControllerFactory = new AgencyControllerFactory();
        IAgencyController controller = agencyControllerFactory.getAgencyController(input);
        controller
                .assignAgency(humanResourcesAgency)
                .assignLongTermStoringService(new LongTermStoringService())
                .setupDefaultDataIfNeeded()
                .readData();

        while (true) {
            printMenu();
            sc = new Scanner(System.in);
            input = sc.next();
            switch (input) {
                case "l":
                case "L": {
                    System.out.println("-------------------------------------");
                    System.out.println("OUTPUT");
                    System.out.println("-------------------------------------");
                    controller.listAllEmployees();
                }
                break;
                case "n":
                case "N": {
                    System.out.println("-------------------------------------");
                    System.out.println("OUTPUT");
                    System.out.println("-------------------------------------");
                    controller.add(randomEmployee());
                }
                break;
                case "d":
                case "D": {
                    System.out.println("-------------------------------------");
                    System.out.println("OUTPUT");
                    System.out.println("-------------------------------------");
                    System.out.println("ID pls");
                    input = sc.next();
                    if (controller.delete(Integer.parseInt(input))) {
                        System.out.println("Deleted succesfully");
                    } else {
                        System.out.println("User is not tracked in HR agency");
                    }
                }
                case "s":
                case "S": {
                    System.out.println("-------------------------------------");
                    System.out.println("OUTPUT");
                    System.out.println("-------------------------------------");
                    System.out.println("ID pls");
                    input = sc.next();
                    System.out.println(controller.findEmployee(Integer.parseInt(input)));
                }
                case "w":
                case "W": {
                    controller.saveDataToJson();
                }
                case "r":
                case "R": {
                    controller.readData();
                }
                break;
                case "x":
                case "X": {
                    return;
                }
                default: {
                    System.out.println("Invalid Input");
                    continue;
                }
            }

        }
    }

    private static void printMenu() {
        System.out.println("-------------------------------------");
        System.out.println("HR AGENCY SYSTEM MENU");
        System.out.println("-------------------------------------");
        System.out.println("List All Employees - L");
        System.out.println("New Employee - N");
        System.out.println("Delete Employee - D");
        System.out.println("Search Employee - S");
        System.out.println("Write Into File - W");
        System.out.println("Read From File - R");
        System.out.println("Exit - E");
        System.out.println("-------------------------------------");
    }

    private static Employee randomEmployee() {
        Employee employee = new Employee();
        Random random = new Random();

        employee.setRegistrationId(random.nextInt(100500));
        employee.setEducation("Ololo default education");
        employee.setDismissedSince(Calendar.getInstance().getTime());
        employee.addExperience("Dancer", 12);
        employee.addSuitableVacancy(new Vacancy("Panda Hugger", 100, "Hugs for pandas"));
        return employee;
    }
}
