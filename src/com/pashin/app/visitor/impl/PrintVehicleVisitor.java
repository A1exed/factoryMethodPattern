package com.pashin.app.visitor.impl;

import com.pashin.app.Car;
import com.pashin.app.Motorbike;
import com.pashin.app.visitor.VehicleVisitor;

public class PrintVehicleVisitor implements VehicleVisitor {
    @Override
    public void visitCar(Car car) {
        System.out.print((car.getBrand() + " models:\n"));
        String[] names = car.getAllModelsName();
        double[] prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.print("( " + names[i] + " - " + prices[i] + " ) ");
        }
        System.out.print("\n");
    }

    @Override
    public void visitMotorbike(Motorbike motorbike) {
        System.out.print(motorbike.getBrand() + " models:");
        String[] names = motorbike.getAllModelsName();
        double[] prices = motorbike.getAllModelsPrice();
        for (int i = 0; i < motorbike.lengthOfModels(); i++) {
            System.out.print("\n( " + names[i] + " - " + prices[i] + " )");
        }
        System.out.print("\n");
    }
}
