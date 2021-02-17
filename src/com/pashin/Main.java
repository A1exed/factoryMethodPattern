package com.pashin;

import com.pashin.app.Car;
import com.pashin.app.Motorbike;
import com.pashin.app.Vehicle;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

public class Main {

    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Vehicle car = new Motorbike("Lada", 0);
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
        }
    }
}
