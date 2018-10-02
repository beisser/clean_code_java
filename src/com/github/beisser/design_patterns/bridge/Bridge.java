package com.github.beisser.design_patterns.bridge;

/**
 * Bridge
 *
 * Connecting components through abstraction
 * this results in the use of interfaces/ abstract classes instead of concrete implementations
 */

// example
// a user should be rendered in different ways
// bad approach: a renderer per user: UserHtmlRenderer, UserStringRenderer etc.
// in this approach for each new object to be rendered or for each renderer we need new Render classes
// components are therefore coupled too tight
//
// better: using an interface renderer and the possibility to inject a renderer into an object which
// needs to be rendered
// so the components are a bit more decoupled
interface Renderer {
    public void render();
}

class StringRenderer implements Renderer {
    @Override
    public void render() {
        System.out.println("Rendering data as String");
    }
}

class HtmlRenderer implements Renderer {
    @Override
    public void render() {
        System.out.println("Rendering data as HTML");
    }
}

abstract class RenderObject {

    protected Renderer renderer;

    public RenderObject(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void renderCurrentObject();
}

class User extends RenderObject {

    public User(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void renderCurrentObject() {
        this.renderer.render();
    }
}

class BridgeDemo {
    public static void main(String[] args) {
        HtmlRenderer htmlRenderer = new HtmlRenderer();
        User user = new User(htmlRenderer);
        user.renderCurrentObject();
    }
}
