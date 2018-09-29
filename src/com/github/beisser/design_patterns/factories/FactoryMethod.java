package com.github.beisser.design_patterns.factories;

/**
 * Factory Method
 *
 * usually a static method within the object to build which allows the
 * creation of an object
 */
class User {

    private String username;

    private User(String username) {
        this.username = username;
    }

    public static User userFromWithUsername(String username) {
        return new User(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}

class FactoryMethodExample {

    public static void main (String[] args) {
        User user = User.userFromWithUsername("testuser");
        System.out.println(user);
    }
}
