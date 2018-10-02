package com.github.beisser.design_patterns.singleton;

/**
 * Singleton
 *
 * for some components only one instance should exist application wide e.g.
 *      - database
 *      - ServiceManager
 */

/**
 * Basic Singleton
 *
 * IMPORTANT: Basic Singleton has some problems:
 *      - problem private constructor can be called by using Reflection
 *      - multiple instances of this object can be created by serializing and deserializing the object (serialize
 *        does not care about the private constructor) -> fixed by added readResolve()
 */
class BasicSingleton {

    // prevent creating new instances by making the constructor private
    private BasicSingleton() {}

    // create one instance
    private static BasicSingleton instance;

    static {
        try {
            instance = new BasicSingleton();
        } catch (Exception e) {
            System.out.println("Error crating singleton");
        }
    }

    public static BasicSingleton getInstance() {
        return instance;
    }

    // with this method even with serialization only one instance is created
    protected Object readResolve() {
        return instance;
    }
}

/**
 * ThreadSaveLazySingleton
 *
 * if a singleton is lazy loaded there might be problems with multithreading (multiple threads in different
 * states call the getInstance() an might create multiple instances
 *
 * therefore the singleton must be made threadsafe
 */
class ThreadSaveLazySingleton {

    private static ThreadSaveLazySingleton instance;

    private ThreadSaveLazySingleton() {
    }

    // making getInstance() threadsafe with synchronized
    public static synchronized ThreadSaveLazySingleton getInstance() {
        if(instance == null) {
            instance = new ThreadSaveLazySingleton();
        }
        return instance;
    }
}

