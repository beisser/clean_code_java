package com.github.beisser.design_patterns.solid.singleResponsiblity;

/**
 * Liskov Substitution
 *
 * a subclass should be able to replace a baseclass
 *
 * e.g. if there is an API which takes a base class you should be able
 * to replace the base class with a sub class without breaking things
 */
class Vehicle {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Car extends Vehicle {

    @Override
    public void setName(String name) {
        super.setName("ALWAYS THE SAME NAME");
    }
}

class LSDemo {

    static void example(Vehicle vehicle, String name) {
        vehicle.setName(name);
        System.out.println(vehicle);
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        example(vehicle,"dynamic name");

        // Liskov Substitution breaks while using the sub class
        // the subclass behaves in another way
        // so the sub class can not replace the base class
        // this is what breaks the Liskov Substitution
        Vehicle car = new Car();
        example(car, "dynamic name");
    }

}

