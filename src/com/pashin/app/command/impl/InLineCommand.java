package com.pashin.app.command.impl;

import com.pashin.app.Car;
import com.pashin.app.command.Command;

import java.io.IOException;
import java.io.Writer;

public class InLineCommand implements Command {
    @Override
    public void execute(Car car, Writer writer) {
        try {
            writer.write((car.getBrand() + " models:\n"));
            String[] names = car.getAllModelsName();
            double[] prices = car.getAllModelsPrice();
            for (int i = 0; i < car.lengthOfModels(); i++) {
                writer.write("( " + names[i] + " - " + prices[i] + " ) ");
            }
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
