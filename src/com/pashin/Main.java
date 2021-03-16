package com.pashin;

import com.pashin.app.*;
import com.pashin.app.chainofresponsibility.Writer;
import com.pashin.app.chainofresponsibility.impl.InColumnWriter;
import com.pashin.app.chainofresponsibility.impl.InLineWriter;
import com.pashin.app.command.impl.InColumnCommand;
import com.pashin.app.command.impl.InLineCommand;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
        /*System.out.println("---------------");
        System.out.println("Добавим");
        System.out.println("---------------");
        VehicleManager.setVehicleFactory(new CarFactory());
        Vehicle vehicle = VehicleManager.createInstance("Lada", 2);
        System.out.println(vehicle.getClass());
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
        clone.setModelNameByName("Priora", "Granta");
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
        VehicleManager.outputAllVehiclePrices(clone);*/
        // Adapter
        /*String[] strings = new String[2];
        strings[0] = "Hello";
        strings[1] = "world";
        Adapter adapter = new Adapter();
        System.out.println(adapter.stringArrToOutputStream(strings));*/
        // Decorator
        /*System.out.println("---------------");
        System.out.println("Декоратор");
        System.out.println("---------------");
        VehicleDecorator vehicleDecorator = new VehicleDecorator(VehicleManager.synchronizedVehicle(vehicle));
        vehicleDecorator.addModel("decorTest", 1);
        VehicleManager.outputAllVehicleModels(vehicle);*/
        // Chain Of Responsibility
        /*Writer writer = new InLineWriter();
        writer.setNextWriter(new InColumnWriter());
        Vehicle v1 = VehicleManager.createInstance("Lada-LINE", 2);
        Vehicle v2 = VehicleManager.createInstance("Lada-COLUMN", 4);
        writer.printToFile(v1);*/
        // Command
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/com/pashin/resources/outputVehicle");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Car car = new Car("Lada", 4);
        car.setPrintCommand(new InLineCommand());
        car.print(outputStream);
        try {
            assert outputStream != null;
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
