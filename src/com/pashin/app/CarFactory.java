package com.pashin.app;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createInstance(String brand, int modelArrayLength) {
        return new Car(brand, modelArrayLength);
    }
}
