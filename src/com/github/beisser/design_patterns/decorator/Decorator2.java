package com.github.beisser.design_patterns.decorator;

/**
 * Decorator
 *
 * another example for a decorator
 */
interface Shape {
    public String info();
}

class Circle implements Shape {

    String name;

    public Circle(String name) {
        this.name = name;
    }

    @Override
    public String info() {
        return this.name;
    }
}

// its not allowed to alter the above because of the Open-Close-Principle
// if Circle should get additional functionality we need a decorator
class ColoredShapeDecorator implements Shape{
    private String color;
    private Shape shape;

    // as in example one the original class will be a member of the decorator class (more general here as shape)
    public ColoredShapeDecorator(String color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    @Override
    public String info() {
        return "Decorator!";
    }
}


