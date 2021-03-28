package com.pashin.app.visitor;

import com.pashin.app.Car;
import com.pashin.app.Motorbike;

public interface VehicleVisitor {
    void visitCar(Car car);

    void visitMotorbike(Motorbike motorbike);
}
