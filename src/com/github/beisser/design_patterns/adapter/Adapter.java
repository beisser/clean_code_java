package com.github.beisser.design_patterns.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter
 *
 * we get interface X from some system and want to use it with a system only accepting an interface Y
 *
 * we than have to write an Adapter to make them compatible
 *
 * e.g.
 * - there is an API to store users in the Database saveUsers(List<User> users)
 * - there is a problem when we don't have a Users-List available; instead we have Persons-List available
 * - in this case we have to write an PersonToUserAdapter
 *
 */
class Person {
    public String firstname, lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

class User {
    public String username;

    public User(String username) {
        this.username = username;
    }
}

class Persons extends ArrayList<Person> {

    public Persons() {
        add(new Person("John","Doe"));
        add(new Person("Jane","Doe"));
    }

}

class PersonsToUsersAdapter extends ArrayList<User>{

    public PersonsToUsersAdapter(List<Person> persons) {
        persons.stream().forEach(person -> {
            add(new User(person.firstname + "." + person.lastname));
        });
    }

}

class Database {

    public List<User> users = new ArrayList<>();

    public void saveUsers(List<User> users) {
        this.users.addAll(users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.users.stream().forEach( user -> {
            sb.append(user.username);
        });
        return sb.toString();
    }
}


class AdapterDemo {

    public static void main(String[] args) {
        Database db = new Database();
        List<Person> persons = new Persons();
        List<User> users = new PersonsToUsersAdapter(persons);

        db.saveUsers(users);
        System.out.println(db);
    }

}
