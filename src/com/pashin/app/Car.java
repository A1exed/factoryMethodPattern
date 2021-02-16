package com.pashin.app;

import com.pashin.exceptions.DuplicateModelNameException;
import com.pashin.exceptions.ModelPriceOutOfBoundsException;
import com.pashin.exceptions.NoSuchModelNameException;

import java.util.Arrays;

public class Car {
    private String brand;

    private Model[] models;

    public Car() {
    }

    public Car(String brand, int modelArrayLength) {
        this.brand = brand;
        models = new Model[modelArrayLength];
        for (int i = 0; i < modelArrayLength; i++) {
            models[i] = new Model();
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Model[] getModels() {
        return models;
    }

    public void setModels(Model[] models) {
        this.models = models;
    }

    public String[] getAllModelsName() {
        String[] allModelsName = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            allModelsName[i] = models[i].getModelName();
        }
        return allModelsName;
    }

    public int getModelPriceByName(String modelName) throws NoSuchModelNameException{
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                return model.getPrice();
            }
        }
        throw new NoSuchModelNameException("Model not found!");
    }

    public void setModelPriceByName(String modelName, int newModelPrice) throws NoSuchModelNameException {
        if (newModelPrice <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
        boolean exFlag = true;
        for (Model model : models) {
            if (modelName.equals(model.getModelName())) {
                model.setPrice(newModelPrice);
                exFlag = false;
            }
        }
        if (exFlag) throw new NoSuchModelNameException("Model already exists!");
    }

    public int[] getAllModelsPrice() {
        int[] allModelsPrice = new int[models.length];
        for (int i = 0; i < models.length; i++) {
            allModelsPrice[i] = models[i].getPrice();
        }
        return allModelsPrice;
    }

    public void addModel(String modelName, int price) throws DuplicateModelNameException {
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

    public int lengthOfModels() {
        return models.length;
    }

    public class Model {
        private String modelName;

        private int price;

        public Model() {
        }

        public Model(String modelName, int price) throws DuplicateModelNameException {
            if (price <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
            for (Model model : models) {
                if (modelName.equals(model.getModelName())) {
                    throw new DuplicateModelNameException("Model already exists!");
                }
            }
            this.modelName = modelName;
            this.price = price;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) throws DuplicateModelNameException {
            for (Model model : models) {
                if (modelName.equals(model.getModelName())) {
                    throw new DuplicateModelNameException("Model already exists!");
                }
            }
            this.modelName = modelName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            if (price <= 0) throw new ModelPriceOutOfBoundsException("Invalid price value!");
            this.price = price;
        }
    }
}
