package com.github.beisser.aud.data_structures.stack;

/**
 * Example custom implementation of a stack
 */
public class Stack {

    private int maxSize;
    // array to represent the stack
    private long[] stackArray;
    // index of the top element of the stack
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new long[this.maxSize];
        this.top = -1;
    }

    public void push(long element) {
        if(!isFull()) {
            this.top++;
            this.stackArray[this.top] = element;
        }
    }

    public long pop() {
        if(!isEmpty()) {
            int oldTop = this.top;
            this.top--;
            return this.stackArray[oldTop];
        } else {
            return -1;
        }
    }

    public long peak() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top < 0;
    }

    public boolean isFull() {
        return (this.maxSize -1 == this.top);
    }
}
