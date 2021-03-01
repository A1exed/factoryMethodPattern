package com.pashin.app.decorator;

import com.pashin.app.Vehicle;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.NoSuchModelNameException;

public class VehicleDecorator implements Vehicle {
    private Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getBrand() {
        return null;
    }

    @Override
    public synchronized void setBrand(String brand) {
        vehicle.setBrand(brand);
    }

    @Override
    public synchronized String[] getAllModelsName() {
        return vehicle.getAllModelsName();
    }

    @Override
    public synchronized double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        return vehicle.getModelPriceByName(modelName);
    }

    @Override
    public synchronized void setModelPriceByName(String modelName, double newModelPrice) throws NoSuchModelNameException {
        vehicle.setModelPriceByName(modelName, newModelPrice);
    }

    @Override
    public synchronized double[] getAllModelsPrice() {
        return vehicle.getAllModelsPrice();
    }

    @Override
    public synchronized void addModel(String modelName, double price) throws DuplicateModelNameException {
        vehicle.addModel(modelName, price);
    }

    @Override
    public synchronized void deleteModel(String modelName) throws NoSuchModelNameException {
        vehicle.deleteModel(modelName);
    }

    @Override
    public synchronized int lengthOfModels() {
        return vehicle.lengthOfModels();
    }

    @Override
    public synchronized Vehicle clone() throws CloneNotSupportedException {
        return vehicle.clone();
    }
}
