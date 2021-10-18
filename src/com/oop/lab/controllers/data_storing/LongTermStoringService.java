package com.oop.lab.controllers.data_storing;

import com.google.gson.Gson;
import com.oop.lab.business_objets.Employee;
import com.oop.lab.business_objets.HumanResourcesAgency;

import java.io.*;
import java.util.HashSet;

public class LongTermStoringService {
    private File employeesList;
    private Gson gson;

    public LongTermStoringService() {
        gson = new Gson();
    }

    public LongTermStoringService createFileIfNeeded() {
        employeesList = new File("./employees.json");
        if (!employeesList.exists()) {
            try {
                employeesList.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public LongTermStoringService saveDataToFile(HumanResourcesAgency humanResourcesAgency) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter("./employees.json"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.write(gson.toJson(humanResourcesAgency));
        printWriter.close();

        return this;
    }

    public HashSet<Employee> readData(){
        BufferedReader bufferedReader = null;
        String json = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("./employees.json"));
            json = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HumanResourcesAgency humanResourcesAgency = gson.fromJson(json, HumanResourcesAgency.class);
        return humanResourcesAgency.getEmployees();
    }
}
