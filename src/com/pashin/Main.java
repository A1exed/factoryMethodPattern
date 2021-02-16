package com.pashin;

import com.pashin.app.Car;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

public class Main {

    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Car car = new Car("Lada", 2);
        Car.Model[] carModels = car.getModels();
        carModels[0].setModelName("Priora");
        carModels[0].setPrice(150);
        carModels[1].setModelName("Granta");
        carModels[1].setPrice(200);
        car.setModels(carModels);
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
        }
    }
}
