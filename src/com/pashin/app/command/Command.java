package com.pashin.app.command;

import com.pashin.app.Car;

import java.io.OutputStream;

public interface Command {
    void execute(Car car, OutputStream outputStream);
}
