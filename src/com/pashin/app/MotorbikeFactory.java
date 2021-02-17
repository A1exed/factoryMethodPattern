package com.pashin.app;

public class MotorbikeFactory implements VehicleFactory {
    @Override
    public Vehicle createInstance(String brand, int modelArrayLength) {
        return new Motorbike(brand, modelArrayLength);
    }
}
