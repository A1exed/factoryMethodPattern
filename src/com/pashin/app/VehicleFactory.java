package com.pashin.app;

public interface VehicleFactory {
    Vehicle createInstance(String brand, int modelArrayLength);
}
