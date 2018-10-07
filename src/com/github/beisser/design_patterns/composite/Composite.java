package com.github.beisser.design_patterns.composite;

import java.util.*;
import java.util.function.Consumer;

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

// the key is that both the single and the collection object implement a common
// interface which extends the iterable interface
// the common interface then can provide default methods for both the single and the collection object
interface CompositeObject extends Iterable<GraphicObject> {

    // default method for both the single and the collection object
    default void drag() {
        for(GraphicObject o : this) {
            System.out.println("drag " + o.name);
        }
    }
}

// for the single object the iterable interface must be implemented
class GraphicObject implements CompositeObject{

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // iterable methods should be implemented like this
    @Override
    public Iterator<GraphicObject> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super GraphicObject> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<GraphicObject> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}

// for the collection objects nothing needs to be done because arraylist implements iterable
class GraphicGroup extends ArrayList<GraphicObject> implements CompositeObject{

}

// create an example graphic object
class Circle extends GraphicObject {
    public Circle(String name) {
        this.name = name;
    }
}

class CompositeDemo {

    public static void main(String[] args) {

        // now both the single object and the collection can be treated as one

        // single object use
        Circle circle = new Circle("circle");
        circle.drag();

        // group objects use
        GraphicGroup graphicGroup = new GraphicGroup();
        graphicGroup.add(circle);
        graphicGroup.drag();

    }

}
