package com.pashin;

import com.pashin.app.*;
import com.pashin.app.adapter.Adapter;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

public class Main {

    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException, CloneNotSupportedException {
        /*Vehicle car = new Motorbike("Lada", 0);
        car.addModel("Priora", 150);
        car.addModel("Granta", 200);
        car.addModel("Zhiga", 10);
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.print(car.getAllModelsName()[i] + " ");
            System.out.print(car.getAllModelsPrice()[i] + "\n");
        }
        car.setModelPriceByName("Zhiga", 15);
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.print(car.getAllModelsName()[i] + " ");
            System.out.print(car.getAllModelsPrice()[i] + "\n");
        }
        // car.getModelPriceByName("123");
        car.deleteModel("Zhiga");
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.print(car.getAllModelsName()[i] + " ");
            System.out.print(car.getAllModelsPrice()[i] + "\n");
        }*/

        // Factory
        System.out.println("---------------");
        System.out.println("Добавим");
        System.out.println("---------------");
        VehicleManager.setVehicleFactory(new MotorbikeFactory());
        Vehicle vehicle = VehicleManager.createInstance("Lada", 0);
        vehicle.addModel("Priora", 150);
        vehicle.addModel("Granta", 200);
        vehicle.addModel("Zhiga", 10);
        System.out.println("Avg: " + VehicleManager.getAvgVehiclePrice(vehicle));
        VehicleManager.outputAllVehicleModels(vehicle);
        VehicleManager.outputAllVehiclePrices(vehicle);
        // car.getModelPriceByName("123");
        System.out.println("---------------");
        System.out.println("Удалим");
        System.out.println("---------------");
        vehicle.deleteModel("Zhiga");
        System.out.println("Avg: " + VehicleManager.getAvgVehiclePrice(vehicle));
        VehicleManager.outputAllVehicleModels(vehicle);
        VehicleManager.outputAllVehiclePrices(vehicle);
        // Clone
        System.out.println("---------------");
        System.out.println("Клонируем и меняем цену приоры");
        Vehicle clone = vehicle.clone();
        clone.setModelPriceByName("Priora", 666);
        System.out.println("---------------");
        System.out.println("Оригинал");
        System.out.println("---------------");
        System.out.println("Avg: " + VehicleManager.getAvgVehiclePrice(vehicle));
        VehicleManager.outputAllVehicleModels(vehicle);
        VehicleManager.outputAllVehiclePrices(vehicle);
        System.out.println("---------------");
        System.out.println("Клон");
        System.out.println("---------------");
        System.out.println("Avg: " + VehicleManager.getAvgVehiclePrice(clone));
        VehicleManager.outputAllVehicleModels(clone);
        VehicleManager.outputAllVehiclePrices(clone);

        // Adapter
        /*String[] strings = new String[2];
        strings[0] = "Hello";
        strings[1] = "world";
        System.out.println(Adapter.stringArrToOutputStream(strings));*/

    }
}
