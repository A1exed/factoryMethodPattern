package com.pashin.app.command;

import com.pashin.app.Car;

import java.io.Serializable;
import java.io.Writer;

public interface Command extends Serializable {
    void execute(Car car, Writer writer);
}
