package com.github.beisser.design_patterns.strategy;

/**
 * Strategy
 *
 * enables to select and change different strategies inside an object e.g. the use of different rendereres
 */

// different strategy options (UsernameRenderer and EmailRenderer)
enum Renderers {
    USERNAME,
    EMAIL
}

interface UserRenderer {
    public void render(User user);
}

class UsernameRenderer implements UserRenderer {

    @Override
    public void render(User user) {
        System.out.println(user.getUsername());
    }
}

class EmailRenderer implements UserRenderer {

    @Override
    public void render(User user) {
        System.out.println(user.getEmail());
    }
}

class User {
    private String username;
    private String email;
    private UserRenderer renderer;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserRenderer getRenderer() {
        return renderer;
    }

    // this is the strategy pattern it allowes to change from one strategy to another
    public void setRenderer(Renderers renderer) {
        switch (renderer) {
            case USERNAME:
                this.renderer = new UsernameRenderer();
                break;
            default:
                this.renderer = new EmailRenderer();
                break;
        }
    }

    public void renderUser() {
        this.renderer.render(this);
    }

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

class StrategyDemo {
    public static void main(String[] args) {
        User user = new User("john.doe", "john.doe@doe.de");
        user.setRenderer(Renderers.USERNAME);
        user.renderUser();

        user.setRenderer(Renderers.EMAIL);
        user.renderUser();

    }
}