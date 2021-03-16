package com.pashin.app;

import com.pashin.app.command.Command;
import com.pashin.app.command.impl.InColumnCommand;
import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.ModelPriceOutOfBoundsException;
import com.pashin.exceptions.NoSuchModelNameException;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Vehicle, Cloneable {
    private String brand;

    private Model[] models;

    private Command printCommand;

    public Car() {
    }

    public Car(String brand, int modelArrayLength) {
        printCommand = new InColumnCommand();
        this.brand = brand;
        models = new Model[modelArrayLength];
        for (int i = 0; i < modelArrayLength; i++) {
            models[i] = new Model();
            models[i].setModelName("M" + i);
            models[i].setPrice(i * 1.0);
        }
    }

    public void setPrintCommand(Command printCommand) {
        this.printCommand = printCommand;
    }

    public void print(OutputStream outputStream) {
        printCommand.execute(this, outputStream);
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
        String[] allModelsName = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            allModelsName[i] = models[i].getModelName();
        }
        return allModelsName;
    }

    @Override
    public double getModelPriceByName(String modelName) throws NoSuchModelNameException{
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                return model.getPrice();
            }
        }
        throw new NoSuchModelNameException("Model not found!");
    }

    @Override
    public void setModelPriceByName(String modelName, double newModelPrice) throws NoSuchModelNameException {
        if (newModelPrice <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
        boolean exFlag = true;
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                model.setPrice(newModelPrice);
                exFlag = false;
                break;
            }
        }
        if (exFlag) throw new NoSuchModelNameException("Model not found!");
    }

    @Override
    public void setModelNameByName(String modelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException {
        boolean exFlag = true;
        for (Model model : models) {
            if (newModelName.equals(model.getModelName())) throw new DuplicateModelNameException("Model already exists!");
        }
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                model.setModelName(newModelName);
                exFlag = false;
                break;
            }
        }
        if (exFlag) throw new NoSuchModelNameException("Model not found!");
    }

    @Override
    public double[] getAllModelsPrice() {
        double[] allModelsPrice = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            allModelsPrice[i] = models[i].getPrice();
        }
        return allModelsPrice;
    }

    @Override
    public void addModel(String modelName, double price) throws DuplicateModelNameException {
        if (price <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                throw new DuplicateModelNameException("Model already exists!");
            }
        }
        Model newModel = new Model(modelName, price);
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = newModel;
    }

    @Override
    public void deleteModel(String modelName) throws NoSuchModelNameException {
        int n = -1;
        for (int i = 0; i < models.length; i++) {
            if (modelName.equals(models[i].getModelName())) {
                n = i;
            }
        }
        if (n < 0) throw new NoSuchModelNameException("Model not found!");
        System.arraycopy(models, n + 1, models, n, models.length - n - 1);
        models = Arrays.copyOf(models, models.length - 1);
    }

    @Override
    public int lengthOfModels() {
        return models.length;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        car.models = models.clone();
        for (int i = 0; i < lengthOfModels(); i++) {
            car.models[i] = models[i].clone();
        }
        return car;
    }

    protected static class Model implements Cloneable {
        private String modelName;

        private double price;

        public Model() {
        }

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "modelName='" + modelName + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        public Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }
    }

    public CarIterator iterator() {
        return new CarIterator(this);
    }
    public class CarIterator implements Iterator {

        private int index;

        private Car car;

        public CarIterator(Car car) {
            index = 0;
            this.car = car;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < car.lengthOfModels();
        }

        @Override
        public Model next() {
            if (hasNext()) {
                index++;
            }
            return models[index];
        }
    }
}
