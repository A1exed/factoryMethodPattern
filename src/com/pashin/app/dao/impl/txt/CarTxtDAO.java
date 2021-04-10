package com.pashin.app.dao.impl.txt;

import com.pashin.app.Car;
import com.pashin.app.dao.TxtDAO;
import com.pashin.exceptions.DuplicateModelNameException;

import java.io.*;

public class CarTxtDAO extends TxtDAO<Car> {
    @Override
    public Car read() {
        try {
            FileReader fileReader = new FileReader(txtFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String brand = bufferedReader.readLine();
            int size = Integer.parseInt(bufferedReader.readLine());
            Car car = new Car(brand, 0);
            String modelName;
            double price;
            for (int i = 0; i < size; i++) {
                modelName = bufferedReader.readLine();
                price = Double.parseDouble(bufferedReader.readLine());
                car.addModel(modelName, price);
            }
            bufferedReader.close();
            fileReader.close();
            return car;
        } catch (DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
