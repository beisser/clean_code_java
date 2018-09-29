package com.github.beisser.design_patterns.builder;


/**
 * Faceted Builder
 * <p>
 * allowes to combine multiple builders (for very complex objects)
 *
 * in this case we need:
 *      * a base builder which manages the subbuilders (UserBuilder) and is a fluent builder (allows to combine
 *          builder methods)
 *      * subbuilders which inherit from this base builder
 */

class User {

    public String address;
    public String job;

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

// first we need a builder facade so that each subbuilder can inherit from
class UserBuilder {

    protected User user = new User();

    public UserAddressBuilder lives() {
        return new UserAddressBuilder(user);
    }

    public UserJobBuilder works() {
        return new UserJobBuilder(user);
    }

    // we can use as many other subbuilders

    public User build() {
        return user;
    }
}

// subbuilder 1
// needs to inherit from the facet builder
// and requires the reference to the builded object
class UserAddressBuilder extends UserBuilder {
    public UserAddressBuilder(User user) {
        this.user = user;
    }

    // return current subbuilder
    public UserAddressBuilder at(String address) {
        user.address = address;
        return this;
    }
}

// subbuilder 1
// needs to inherit from the facet builder
// and requires the reference to the builded object
class UserJobBuilder extends UserBuilder {
    public UserJobBuilder(User user) {
        this.user = user;
    }

    // return current subbuilder
    public UserJobBuilder jobsAs(String job) {
        user.job = job;
        return this;
    }
}


// Both subbuilders inherit from the facet builder
// therefore there methods can be used in the same call
class FacetBuilderDemo {
    public static void main(String[] args) {
        UserBuilder ub = new UserBuilder();
        User user = ub
                .lives()
                    .at("test")
                .works()
                    .jobsAs("Worker")
                .build();
        System.out.println(user);
    }
}