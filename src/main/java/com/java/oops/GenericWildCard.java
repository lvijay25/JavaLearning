package com.java.oops;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    static int vehicleCount;
    public void display(){
        vehicleCount++;
        System.out.println("Vehicle Count " + vehicleCount);
    }
}

class Bus extends Vehicle {
    static int busCount;
    public void display(){
        busCount++;
        System.out.println("Bus Count " + busCount);
    }
}
class Rocket extends Vehicle {
    static int rocketCount;
    public void display(){
        rocketCount++;
        System.out.println("Rocket count " + rocketCount);
    }
}

public class GenericWildCard {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);

        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        List<Bus> busList = new ArrayList<>();
        busList.add(bus1);
        busList.add(bus2);

        Rocket rocket1 = new Rocket();
        Rocket rocket2 = new Rocket();
        List<Rocket> rocketList = new ArrayList<>();
        rocketList.add(rocket1);
        rocketList.add(rocket2);

        constructAllVehiclesUpper_Bound(vehicleList);

        constructAllVehiclesLower_Bound(busList);

        constructAllVehiclesUnBounded(rocketList);
        constructAllVehiclesUnBounded(vehicleList);
        constructAllVehiclesUnBounded(busList);

        /**
         * ? extends ClassName
         * ? super ClassName
         *
         */

    }
    public static void constructAllVehiclesUpper_Bound(List<? extends Vehicle> vehicle){
        vehicle.forEach(Vehicle::display);
    }

    public static void constructAllVehiclesLower_Bound(List<? super Bus> vehicle){
        vehicle.forEach(bus -> ((Vehicle) bus).display());
    }

    public static void constructAllVehiclesUnBounded(List<?> vehicle) {
        vehicle.forEach(bus -> ((Vehicle) bus).display());
    }

    public static void constructAllVehiclesBoundedType(){

    }
}