package com.pashin.app.dao;

import com.pashin.app.Vehicle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class TxtDAO<T extends Vehicle> {

    protected File txtFile;

    public TxtDAO() {
        txtFile = new File("src/com/pashin/resources/txt");
    }

    public abstract T read();

    public void write(T vehicle) {
        try {
            FileWriter fileWriter = new FileWriter(txtFile);
            fileWriter.append(vehicle.getBrand()).append('\n');
            fileWriter.append(String.valueOf(vehicle.lengthOfModels())).append('\n');
            String[] modelNames = vehicle.getAllModelsName();
            double[] prices = vehicle.getAllModelsPrice();
            for (int i = 0; i < vehicle.lengthOfModels(); i++) {
                fileWriter.append(modelNames[i]).append('\n');
                fileWriter.append(String.valueOf(prices[i])).append('\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
