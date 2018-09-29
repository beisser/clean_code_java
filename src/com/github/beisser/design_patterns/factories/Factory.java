package com.github.beisser.design_patterns.factories;

/**
 * Factory
 *
 * used when the creation of an object is very complex
 * Difference to builder is that object is build in one block
 *
 * types of factories:
 *      Factory Method (static method which returns an object)
 *      Factory (group various factory methods in one class)
 *      Abstract Factory (hierarchy of factories representing the hierarchy of object to be build)
 *
 */
class FactoryUser {

    private String username;

    private FactoryUser(String username) {
        this.username = username;
    }

    public static class Factory {
        public static FactoryUser userFromWithUsername(String username) {
            return new FactoryUser(username);
        }
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}

// Factory (group various factory methods in one class)
class FactoryClassExample {

    public static void main (String[] args) {
        FactoryUser user = FactoryUser.Factory.userFromWithUsername("testuser");
        System.out.println(user);
    }
}

