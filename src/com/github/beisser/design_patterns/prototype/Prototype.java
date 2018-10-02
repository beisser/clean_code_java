package com.github.beisser.design_patterns.prototype;

import java.io.Serializable;

/**
 * prototype is an existing object which is copied and customized afterwards
 *
 * to get a complete new object with out editing the prototype object a deep copy is needed!
 * IMPORTANT WE MUST NOT USE THE CLONEABLE INTERFACE!
 *
 * options:
 *      copy constructor (not good for complicated objects)
 *      serialization
 */

class PrototypeUser {

    private String username;

    public PrototypeUser(String username) {
        this.username = username;
    }

    // this is a copy constructor
    public PrototypeUser(PrototypeUser other) {
        this(other.username);
    }
}

// copy with serialization -> best way
class SerializeUser implements Serializable {

    private String username;

    public SerializeUser(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SerializeUser{" +
                "username='" + username + '\'' +
                '}';
    }
}


class PrototypeDemo {
    SerializeUser user = new SerializeUser("Testuser");
// import org.apache.commons.lang3.SerializationUtils is needed
// this is how to create a copy
//    SerializeUser user2 = SerializationUtils.roundtrip(user);
}
