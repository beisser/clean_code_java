package com.github.beisser.design_patterns.template_method;

/**
 * TemplateMethod
 *
 * generally the same as the strategy pattern
 * Provide a skeleton algorithm, where the details can be changed
 *
 * Difference: Strategy pattern uses composition, TemplateMethod uses inheritance
 *
 */

// this is the skeleton algorithm
abstract class User {

    private String username, email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void renderUser() {
        render();
    }

    // this is where the details can be changed through inheritance
    // for the usage of this algorithm the abstract class must be inherited
    // after that the render method needs to be implemented and therefore the details are
    // set through inheritance
    abstract void render();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class HtmlRenderedUser extends User {

    public HtmlRenderedUser(String username, String email) {
        super(username, email);
    }

    @Override
    void render() {
        System.out.println("<h1>" + this.getUsername() + "</h1>");
    }
}

class TemplateMethodDemo {

    public static void main(String[] args) {
        HtmlRenderedUser htmlRenderedUser = new HtmlRenderedUser("john.doe", "john.doe@test.de");
        htmlRenderedUser.renderUser();
    }

}
