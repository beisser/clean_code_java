package com.github.beisser.aud.data_structures.linked_list;

public class CircularLinkedList {

    private Node first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()) {
            this.last = newNode;
        }

        newNode.next = this.first;  // move old first
        this.first = newNode;   // set new node first
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()) {
            this.first = newNode;
        } else {
            this.last.next = newNode;   // link current last node to the new one
            this.last = newNode;    // make new node the new last
        }
    }

    public Node deleteFirst() {
        Node currentNode = this.first;

        if(this.first.next == null) {
            this.last = null;
        } else {
            this.first = this.first.next;
        }

        return currentNode;
    }

}
