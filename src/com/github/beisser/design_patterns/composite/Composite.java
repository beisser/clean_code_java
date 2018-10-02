package com.github.beisser.design_patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 *
 * provide a way to treat single and composite objects (collections) in the same way
 * e.g. Foo and List<Foo> have common APIs
 *
 * imaging a drawing program where shapes (circles, rectangles etc.) can be drawn, dragged etc.
 * if we have a shape we can mark it and drag them to another place
 * but we can also mark several shapes and drag them as a group
 */

// create an object which can be a single object OR can represent a group of the same object using
// the children
// therefore this class has children of its own, is not abstract and has its own constructor
// this is the core of the composite pattern: treating single or group objects in the same way
class GraphicObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphicObject> children = new ArrayList<>();

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this.children.isEmpty()) {
            System.out.println("Print a single object");
        } else {
            System.out.println("Print a group of objects");
        }
    }
}

class Circle extends GraphicObject {
    public Circle(String name) {
        this.name = name;
    }
}

class CompositeDemo {

    public static void main(String[] args) {

        // single object use
        Circle circle = new Circle("circle");
        circle.print();

        // group objects use
        GraphicObject graphicObject = new GraphicObject();
        graphicObject.children.add(circle);
        graphicObject.children.add(new GraphicObject());
        graphicObject.print();

    }

}
