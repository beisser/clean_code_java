package com.github.beisser.design_patterns.solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Dependency Inversion
 *
 * splitted into 2 parts:
 *      1. High level module should not depend on low level modules e.g.
 *          low-level module example: a class used as a data storage
 *          high-level module example: a class which browses the data from the data storage
 *          -> in this case the browsing class should not depend on the data storage class meaning
 *             no instance of the data storage should be used in the browser class
*           -> instead: use abstractions (interfaces and abstract classes)
 *
 *      2. Always use abstractions (interfaces and abstract classes) instead of implementation
 *          classes if possible
 */

// BAD APPROACH

// low-level-class
class Database {
    List<String> data = new ArrayList<>();

    public void addData(String newData) {
        this.data.add(newData);
    }

    public List<String> getData() {
        return data;
    }
}

// high-level class
// high-level because the client will use this class to browse and search the
// data
class Search {

    private Database database;

    // BAD PRACTICE because the high level module depends on the low-level module
    public Search(Database database) {
        this.database = database;
    }

    public boolean hasEntry(String entry) {
        return this.database.getData().contains(entry);
    }
}


// BETTER APPROACH
interface DatabaseBrowser {
    public boolean hasEntry(String entry);
}

// low-level-class
class BetterDatabase implements DatabaseBrowser{
    List<String> data = new ArrayList<>();

    public void addData(String newData) {
        this.data.add(newData);
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public boolean hasEntry(String entry) {
        return false;
    }
}

// high-level class
class BetterSearch {

    public boolean hasEntry(DatabaseBrowser databaseBrowser, String entry) {
        return databaseBrowser.hasEntry(entry);
    }
}
