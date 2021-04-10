package com.pashin;

import com.pashin.app.*;
import com.pashin.app.chainofresponsibility.impl.InColumnWriter;
import com.pashin.app.chainofresponsibility.impl.InLineWriter;
import com.pashin.app.command.impl.InColumnCommand;
import com.pashin.app.command.impl.InLineCommand;
import com.pashin.app.dao.CarDAOManager;
import com.pashin.app.dao.MotorbikeDAOManager;
import com.pashin.app.strategy.Repairer;
import com.pashin.app.strategy.impl.DOMAnalyzer;
import com.pashin.app.strategy.impl.SAXAnalyzer;
import com.pashin.app.visitor.VehicleVisitor;
import com.pashin.app.visitor.impl.PrintVehicleVisitor;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

import java.io.*;
import java.util.Iterator;

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
        writer.printToFile(v2);*/
        // Command
        /*Writer writer = null;
        try {
            writer = new FileWriter("src/com/pashin/resources/outputVehicle");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Car car = new Car("Lada", 4);
        car.setPrintCommand(new InLineCommand());
        car.print(writer);*/
        // Iterator
        /*Car car = new Car("Lada", 4);
        Iterator iterator = car.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }*/
        // Memento
        /*Car car = new Car("Lada", 4);
        Car.CarMemento carMemento = car.createMemento();
        System.out.println("---------------");
        System.out.println("Оригинал");
        System.out.println("---------------");
        System.out.println(car.getBrand());
        String[] names = car.getAllModelsName();
        double[] prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }

        car.setBrand("BMW");
        car.addModel("new", 200);

        System.out.println("---------------");
        System.out.println("Измененная");
        System.out.println("---------------");
        System.out.println(car.getBrand());
        names = car.getAllModelsName();
        prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }

        car = car.setMemento(carMemento);

        System.out.println("---------------");
        System.out.println("После восстановления");
        System.out.println("---------------");
        System.out.println(car.getBrand());
        names = car.getAllModelsName();
        prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }*/
        // Strategy
        /*Repairer repairer = new Repairer();
        repairer.setAnalyzeStrategy(new DOMAnalyzer());
        repairer.repair(args[0], args[1]);*/
        // Visitor
        /*VehicleVisitor visitor = new PrintVehicleVisitor();
        Car car = new Car("Lada", 4);
        Motorbike motorbike = new Motorbike("MOTO", 4);
        car.accept(visitor);
        motorbike.accept(visitor);*/
        // DAO
        Car car = new Car("CAR", 4);
        Motorbike motorbike = new Motorbike("MOTO", 4);
        CarDAOManager carDAOManager = new CarDAOManager();
        MotorbikeDAOManager motorbikeDAOManager = new MotorbikeDAOManager();

        System.out.println(car.getBrand());
        String[] names = car.getAllModelsName();
        double[] prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }

        carDAOManager.writeCarLikeTxt(car);
        car = carDAOManager.readCarLikeTxt();

        System.out.println(car.getBrand());
        names = car.getAllModelsName();
        prices = car.getAllModelsPrice();
        for (int i = 0; i < car.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }

        System.out.println(motorbike.getBrand());
        names = motorbike.getAllModelsName();
        prices = motorbike.getAllModelsPrice();
        for (int i = 0; i < motorbike.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }

        motorbikeDAOManager.writeMotorbikeLikeSerial(motorbike);
        motorbike = motorbikeDAOManager.readMotorbikeLikeSerial();

        System.out.println(motorbike.getBrand());
        names = motorbike.getAllModelsName();
        prices = motorbike.getAllModelsPrice();
        for (int i = 0; i < motorbike.lengthOfModels(); i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }
    }
}
