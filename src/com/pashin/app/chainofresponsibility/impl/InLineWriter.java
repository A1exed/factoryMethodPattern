package com.pashin.app.chainofresponsibility.impl;

import com.pashin.app.Vehicle;
import com.pashin.app.chainofresponsibility.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class InLineWriter implements Writer {

    private Writer nextWriter;

    @Override
    public void printToFile(Vehicle vehicle) {
        if (vehicle.lengthOfModels() <= 3) {
            try (FileWriter fileWriter = new FileWriter("src/com/pashin/resources/outputVehicle")) {
                fileWriter.write(vehicle.getBrand() + " models:\n");
                String[] names = vehicle.getAllModelsName();
                double[] prices = vehicle.getAllModelsPrice();
                for (int i = 0; i < vehicle.lengthOfModels(); i++) {
                    fileWriter.write("( " + names[i] + " - " + prices[i] + " ) ");
                }
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            nextWriter.printToFile(vehicle);
        }
    }

    @Override
    public void setNextWriter(Writer nextWriter) {
        this.nextWriter = nextWriter;
    }
}
