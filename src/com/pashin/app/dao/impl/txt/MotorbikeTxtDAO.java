package com.pashin.app.dao.impl.txt;

import com.pashin.app.Motorbike;
import com.pashin.app.dao.TxtDAO;
import com.pashin.exceptions.DuplicateModelNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MotorbikeTxtDAO extends TxtDAO<Motorbike> {
    @Override
    public Motorbike read() {
        try {
            FileReader fileReader = new FileReader(txtFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String brand = bufferedReader.readLine();
            int size = Integer.parseInt(bufferedReader.readLine());
            Motorbike motorbike = new Motorbike(brand, 0);
            String modelName;
            double price;
            for (int i = 0; i < size; i++) {
                modelName = bufferedReader.readLine();
                price = Double.parseDouble(bufferedReader.readLine());
                motorbike.addModel(modelName, price);
            }
            bufferedReader.close();
            fileReader.close();
            return motorbike;
        } catch (DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
