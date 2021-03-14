package com.pashin.app.chainofresponsibility;

import com.pashin.app.Vehicle;

public interface Writer {

    void printToFile(Vehicle vehicle);

    void setNextWriter(Writer nextWriter);

}
