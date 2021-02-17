package com.pashin.app;

import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.ModelPriceOutOfBoundsException;
import com.pashin.exceptions.NoSuchModelNameException;

public class Motorbike implements Vehicle, Cloneable {
    private String brand;

    private Model head = new Model();
    {
        head.prev = head;
        head.next = head;
    }

    private int size = 0;

    public Motorbike() {
    }

    public Motorbike(String brand, int modelListLength) {
        this.size = modelListLength;
        this.brand = brand;
        Model prev = head;
        Model next = head;
        for (int i = 0; i < modelListLength; i++) {
            Model model = new Model();
            prev.next = model;
            next.prev = model;
            model.next = prev;
            model.prev = next;
            prev = model;
        }
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String[] getAllModelsName() {
        String[] allModelsName = new String[size];
        Model model = head.next;
        for (int i = 0; i < size; i++) {
            allModelsName[i] = model.modelName;
            model = model.next;
        }
        return allModelsName;
    }

    @Override
    public double getModelPriceByName(String modelName) throws NoSuchModelNameException {
        Model model = head.next;
        for (int i = 0; i < size; i++) {
            if (modelName.equals(model.modelName)) {
                return model.price;
            }
            model = model.next;
        }
        throw new NoSuchModelNameException("Model not found!");
    }

    @Override
    public void setModelPriceByName(String modelName, double newModelPrice) throws NoSuchModelNameException {
        if (newModelPrice <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
        boolean exFlag = true;
        Model model = head.next;
        for (int i = 0; i < size; i++) {
            if (modelName.equals(model.modelName)) {
                model.price = newModelPrice;
                exFlag = false;
            }
            model = model.next;
        }
        if (exFlag) throw new NoSuchModelNameException("Model already exists!");
    }

    @Override
    public double[] getAllModelsPrice() {
        Model model = head.next;
        double[] allModelsPrice = new double[size];
        for (int i = 0; i < size; i++) {
            allModelsPrice[i] = model.price;
            model = model.next;
        }
        return allModelsPrice;
    }

    @Override
    public void addModel(String modelName, double price) throws DuplicateModelNameException {
        if (price <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
        Model model = head.next;
        for (int i = 0; i < size; i++) {
            if (modelName.equals(model.modelName)) {
                throw new DuplicateModelNameException("Model already exists!");
            }
            model = model.next;
        }
        Model newModel = new Model();
        newModel.modelName = modelName;
        newModel.price = price;
        newModel.next = head;
        newModel.prev = model.prev;
        model.prev.next = newModel;
        head.prev = newModel;
        size++;
    }

    @Override
    public void deleteModel(String modelName) throws NoSuchModelNameException {
        boolean exFlag = true;
        Model model = head.next;
        for (int i = 0; i < size; i++) {
            if (modelName.equals(model.modelName)) {
                model.prev.next = model.next;
                model.next.prev = model.prev;
                size--;
                exFlag = false;
            }
            model = model.next;
        }
        if (exFlag) throw new NoSuchModelNameException("Model not found!");
    }

    @Override
    public int lengthOfModels() {
        return size;
    }

    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        Motorbike motorbike = (Motorbike) super.clone();
        motorbike.head = new Model();
        motorbike.head.prev = motorbike.head;
        motorbike.head.next = motorbike.head;
        Model model = head.next;
        Model prev = motorbike.head;
        Model next = motorbike.head;
        while (model != head) {
            Model newModel = model.clone();
            prev.next = newModel;
            next.prev = newModel;
            newModel.next = prev;
            newModel.prev = next;
            prev = newModel;
            model = model.next;
        }
        return motorbike;
    }

    private static class Model implements Cloneable {
        String modelName = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        @Override
        public Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }
    }
}
