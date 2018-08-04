package com.github.beisser.design_patterns.solid.singleResponsiblity;

import java.util.ArrayList;
import java.util.List;

/**
 * Single Responsibility
 *
 * - a class should only be responsible for a single goal
 * - this class should be the _only_ place for this responsibility in the project
 *
 * helps to keep classes maintainable
 */
 class Blog {
    List<String> entires = new ArrayList<String>();

    public void addEntry(String newEntry) {
        this.entires.add(newEntry);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "entires=" + entires +
                '}';
    }

    // WARNING the following methods break the single responsibility
    // persistance should be handled in other class !!!
    public void saveToFile() {
        // persistance logic
    }

    public List<String> load() {
        // load logic
        return new ArrayList<String>();
    }
}

/**
 * Persitance operations should go in a own class
 */
class BlogService {
    public void saveToFile() {
        // persistance logic
    }

    public List<String> load() {
        // load logic
        return new ArrayList<String>();
    }
}
