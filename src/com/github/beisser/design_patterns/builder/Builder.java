package com.github.beisser.design_patterns.builder;

/**
 * Builder
 *
 * Builder is about providing an easy API to create objects that are complicated to build
 *
 * with the Builder the objects are build piece by piece using different methods (the building
 * piece by piece is the difference to the Factory-Pattern where the object is build in one block)
 *
 * often a fluent builder makes sense: Methods of a fluent builder return the Builder object itself
 * so that the methods of the API can be chained
 *
 * Bad practice: a constructor of an object has too many arguments
 * Good practice: Allow to construct an object piece by piece
 *
 * Java Lib Builder example: StringBuilder is better than concat multiple substrings. String Builder
 * is also a fluent builder because the append methods return the builder itself
 */

class JavaLibBuilderExample {

    public static void main(String[] args) {

        // example for an builder from the Java API: StringBuilder
        String htmlValue = "Tag Value";

        // bad practice
        System.out.println("<ul>\n<li>" + htmlValue + "</li></ul>");

        // good practice
        // construct complex objects by an API with multiple simple methods
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n<li>");

        // fluent builder returns the builder itself so that methods can be chained.
        sb.append(htmlValue).append("another value");
        sb.append("</li></ul>");

        System.out.println(sb.toString());
    }

}

// custom fluent builder with inheritance
// the problem with inheritance used by builders is the return of this
// this is different in child classes and does not allow to use all methods from the inheritance structure
class FluentBuilderWithInheritance {
    public static void main(String[] args) {
        HobbyPersonBuilder hpb = new HobbyPersonBuilder();
        hpb.addName("nico").addHobby("gaming");

        System.out.println(hpb.getResult());
    }
}

class Person {
    public String name;
    public String hobby;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

// the problem is that not all methods from the inherited Classes can be chained because this
// in the two following classes is different
// the solution are recursive generics and the use of SELF
// by SELF we are saying that PersonBuilder has SOME inheritor (not yet defined)
// the method self() returns this casted to SELF
// the self method needs to be overwritten by the inheritor
// by using this method all methods can be chained
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF addName(String name) {
        person.name = name;
        return self();
    }

    public Person getResult() {
        return person;
    }

    // method that can be overwritten by the inheritor
    protected SELF self() {
        return (SELF) this;
    }
}

// The inheritor of PersonBuilder is HobbyPersonBuilder which is defined here
class HobbyPersonBuilder extends PersonBuilder<HobbyPersonBuilder> {

    public HobbyPersonBuilder addHobby(String hobby) {
        person.hobby = hobby;
        return this;
    }

    // return the actual inheritor
    @Override
    protected HobbyPersonBuilder self()
    {
        return this;
    }

}
