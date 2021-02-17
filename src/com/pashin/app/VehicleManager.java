package com.pashin.app;

public class VehicleManager {
    private static VehicleFactory vehicleFactory = new CarFactory();

    public static void setVehicleFactory(VehicleFactory vehicleFactory) {
        VehicleManager.vehicleFactory = vehicleFactory;
    }

    public static Vehicle createInstance(String brand, int modelArrayLength) {
        return vehicleFactory.createInstance(brand, modelArrayLength);
    }

    public static double getAvgVehiclePrice(Vehicle vehicle) {
        double avg = 0;
        double[] vehiclePrices = vehicle.getAllModelsPrice();
        for (double currentPrice : vehiclePrices) {
            avg += currentPrice;
        }
        return avg / vehiclePrices.length;
    }

    public static void outputAllVehicleModels(Vehicle vehicle) {
        System.out.println(vehicle.getBrand() + " models:");
        for (String s : vehicle.getAllModelsName()) {
            System.out.println(s);
        }
    }

    public static void outputAllVehiclePrices(Vehicle vehicle) {
        System.out.println(vehicle.getBrand() + " prices:");
        for (double d : vehicle.getAllModelsPrice()) {
            System.out.println(d);
        }
    }
}
