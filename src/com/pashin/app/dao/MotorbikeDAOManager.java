package com.pashin.app.dao;

import com.pashin.app.Motorbike;
import com.pashin.app.dao.impl.txt.MotorbikeTxtDAO;

public class MotorbikeDAOManager {

    private SerialDAO<Motorbike> serialDAO;

    private TxtDAO<Motorbike> txtDAO;

    public MotorbikeDAOManager() {
        serialDAO = new SerialDAO<>();
        txtDAO = new MotorbikeTxtDAO();
    }

    public Motorbike readMotorbikeLikeTxt() {
        return txtDAO.read();
    }

    public void writeMotorbikeLikeTxt(Motorbike motorbike) {
        txtDAO.write(motorbike);
    }

    public Motorbike readMotorbikeLikeSerial() {
        return serialDAO.read();
    }

    public void writeMotorbikeLikeSerial(Motorbike motorbike) {
        serialDAO.write(motorbike);
    }
}
