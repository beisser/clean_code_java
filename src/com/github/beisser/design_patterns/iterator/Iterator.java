package com.github.beisser.design_patterns.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Iterator
 *
 * object to walk over a each element of an data structure
 *
 * Java has interfaces:
 *  - Iterator: interface which needs to be implemented to define how an object is walked through; sometimes there
 *    are more than one ways to walk through an object (e.g.); in this case multiple Iterators are needed
 *    -> required methods are hasNext() and next()
 *
 *
 *  - Iterable: interface to support using an object in a loop; requires an Iterator which should be used
 *    to walk through
 */


// represents a creature in a video game which currently has three stats
// there should be several methods using this stats e.g. sum() (problem with an default approach is that if we add
// another stat we must edit the methods using this stats
// by implementing Iterable this can be done much easier, because only the array must be changed but not
// the methods using the stats
class Creature implements Iterable<Integer> {

    private int[] stats = new int[3];

    // must not be changed using iterable
    // Streaming API can be used
    public int sum() {
        return IntStream.of(this.stats).sum();
    }

    public Creature(int one, int two, int three) {
        this.stats[0] = one;
        this.stats[1] = two;
        this.stats[2] = three;
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(this.stats).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for(int x: this.stats) {
            action.accept(x);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntStream.of(this.stats).spliterator();
    }
}

class IteratorDemo {

    public static void main(String[] args) {
        Creature integers = new Creature(1, 2, 3);
        for(int test: integers) {
            System.out.println(test);
        }
    }

}
