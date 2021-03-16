package com.pashin.app.command.impl;

import com.pashin.app.Car;
import com.pashin.app.command.Command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class InColumnCommand implements Command {
    @Override
    public void execute(Car car, OutputStream outputStream) {
        try {
            outputStream.write((car.getBrand() + " models:").getBytes(StandardCharsets.UTF_8));
            String[] names = car.getAllModelsName();
            double[] prices = car.getAllModelsPrice();
            for (int i = 0; i < car.lengthOfModels(); i++) {
                outputStream.write(("\n( " + names[i] + " - " + prices[i] + " )").getBytes(StandardCharsets.UTF_8));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
