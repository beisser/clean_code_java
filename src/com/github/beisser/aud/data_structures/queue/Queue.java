package com.github.beisser.aud.data_structures.queue;

public class Queue {

    private int maxSize;
    // array to represent the queue
    private long[] queueArray;
    // index of the first and last element of the queue
    private int first;
    private int last;
    private int counter;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[this.maxSize];
        this.first = 0;
        this.last = -1;
        this.counter = 0;
    }

    public void insert(long element) {
        // new elements are added to the end
        this.last++;
        this.queueArray[this.last] = element;
        this.counter++;
    }

    public long remove () {
        long valueToReturn = this.queueArray[this.first];
        this.first++;
        if(this.first == this.maxSize) {
            this.first = 0;
        }
        this.counter--;

        return valueToReturn;
    }

    public long peak() {
        return this.queueArray[this.first];
    }

    public boolean isEmpty() {
        return this.counter == 0;
    }

    public boolean isFull() {
        return (this.counter == maxSize);
    }

}
