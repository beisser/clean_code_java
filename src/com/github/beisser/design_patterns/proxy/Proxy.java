package com.github.beisser.design_patterns.proxy;

/**
 * Proxy
 *
 * interface to access a resource; this proxy interface looks like the interface of the underlying object but
 * allows additional functionality e.g.
 *  - security checks
 *  - logging
 *  - caching
 *
 *  to create a proxy we just override the methods of the underlying objects and change the methods accordingly
 *
 * good thing is, the proxy can be used in all places where the underlying object is used
 *
 * proxy vs. decorator
 * difference: proxy provides an identical interface, the decorator provides an enhanced interface
 */
interface Drivable {
    public void drive();
}

class Car implements Drivable {
    private Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {

    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

class Driver {
    private int age;

    public Driver(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// this proxy behaves like a car (has the same API) but has extra
// functionality (security check)
class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if(this.getDriver().getAge() > 18) {
            super.drive();
        } else {
            System.out.println("Driving not allowed");
        }
    }
}