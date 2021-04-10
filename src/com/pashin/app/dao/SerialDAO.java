package com.pashin.app.dao;

import com.pashin.app.Vehicle;

import java.io.*;

public class SerialDAO<T extends Vehicle> {

    protected File serialFile;

    public SerialDAO() {
        serialFile = new File("src/com/pashin/resources/serial");
    }

    public T read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serialFile))) {
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(T vehicle) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serialFile));
            objectOutputStream.writeObject(vehicle);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
