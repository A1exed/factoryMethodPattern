package com.pashin.app.dao;

import com.pashin.app.Car;
import com.pashin.app.dao.impl.txt.CarTxtDAO;

public class CarDAOManager {

    private SerialDAO<Car> serialDAO;

    private TxtDAO<Car> txtDAO;

    public CarDAOManager() {
        serialDAO = new SerialDAO<>();
        txtDAO = new CarTxtDAO();
    }

    public Car readCarLikeTxt() {
        return txtDAO.read();
    }

    public void writeCarLikeTxt(Car car) {
        txtDAO.write(car);
    }

    public Car readCarLikeSerial() {
        return serialDAO.read();
    }

    public void writeCarLikeSerial(Car car) {
        serialDAO.write(car);
    }
}
