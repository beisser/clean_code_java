package com.github.beisser.design_patterns.visitor;

/**
 * Visitor
 *
 * add additional behaviour to complete hierarchy of classes
 *
 * a component (visitor) is allowed to traverse the complete hierarchy
 * generally implemented by adding one method "visit()" to all elements of the hierarchy
 */

// DOUBLE DISPATCH VISITOR

// we want to add additional functionality (printing) to all elements of the hierarchy (in this example to OnlineUser and
// IntranetUser without changing the classes itself (OCP and Single Responsibility)

// therefor we add an accept-method to the abstract class
// this forces every element of the hierarchy to implement the accept method (this method must call visitor.visit(this)
// as a result visitor.visit(this) would force you to extend the interface UserVistor
// as a result the concrete Visitor would be forced to implement the visit() method
// so no element of the hierarchy will be forgotten

// interface which forces the concrete visitors to handle each element of the hierarchy
interface UserVisitor {
    void visit(OnlineUser user);
    void visit(IntranetUser user);
}

// this concrete implementation of a UserVisitor extends the functionality of each element
// of the hierarchy
class UserPrinter implements UserVisitor {

    @Override
    public void visit(OnlineUser user) {
        System.out.println("Online");
    }

    @Override
    public void visit(IntranetUser user) {
        System.out.println("Intranet");
    }
}

// this is the small example hierarchy
abstract class User {

    // the upside is that this method only needs to be implemented once
    // once it is there, the actual visitor or the additional behaviour can be changed
    public abstract void accept(UserVisitor visitor);
}

class OnlineUser extends User {
    private String username, password;

    public OnlineUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void accept(UserVisitor visitor) {
        visitor.visit(this);
    }
}

class IntranetUser extends User {
    private String ip;

    public IntranetUser(String ip) {
        this.ip = ip;
    }

    @Override
    public void accept(UserVisitor visitor) {
        visitor.visit(this);
    }

}
