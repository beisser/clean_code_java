package com.github.beisser.design_patterns.solid.singleResponsiblity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * OpenClose
 *
 * open for extension but closed for modification
 *
 * code snippets should be easily able to extend while not touching the code
 * that has already been written an tested
 *
 * with this pattern you don't change existing classes you just extend the functionality
 * with inheritance and implementation of interfaces
 */
enum Color
{
    RED, GREEN, BLUE
}

enum Size
{
    SMALL, MEDIUM, LARGE
}

class Product
{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

// bad because a new method needs to be created for each new product criteria to be filtered
class BadFilter {

    public Stream<Product> filterByColor(List<Product> products, Color color)
    {
        return products.stream().filter(p -> p.color == color);
    }

}

// better approach
// complete the task by using interfaces

// can be implemented for new criterias
interface Specification<T>
{
    boolean isSatisfied(T item);
}

// filter using just specifications
interface Filter<T>
{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

// for each new criteria we can create a new specification
// the logic if a criteria is satisfied is hidden in the specification
class ColorSpecification implements Specification<Product>
{
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

// We can now easily implement new filters just by implementing new specifications
// the filter itself does not need to be modified
class BetterFilter implements Filter<Product>
{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(tree);
        products.add(house);

        BetterFilter bf = new BetterFilter();
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));
    }
}
