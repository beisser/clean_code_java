package com.github.beisser.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Observer
 *
 * an object which wants to listen to events and wants to get informed when such an event happens
 * the object generating those events is the Observable / Subject
 * difference:
 *  - Subject can take subscriptions and fire events
 *  - Observable can only take subscriptions
 *
 */

// generally use reactive extensions

// small example custom reactive extensions like implementation
// Storing and returning and subscription is not part of the example

// creating an Subject class which holds all subscribers and fires events
class Subject<T>
{
    private int count = 0;
    private List<Consumer<T>> subscribers = new ArrayList<>();

    public void subscribe(Consumer<T> subscriber)
    {
        this.subscribers.add(subscriber);
    }

    public void next(T value)
    {
        for (Consumer<T> subscriber : this.subscribers)
            subscriber.accept(value);
    }

}

class Person {

    public Subject<Person> observable = new Subject<>();
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.observable.next(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

class ObserverDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.observable.subscribe(p -> System.out.println("VALUE CHANGED" + p));
        person.setAge(12);
    }

}







