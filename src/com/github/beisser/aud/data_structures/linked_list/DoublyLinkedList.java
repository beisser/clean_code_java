package com.github.beisser.aud.data_structures.linked_list;

public class DoublyLinkedList {

    private Node first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()) {
            this.last = newNode;
        } else {
            this.first.prev = newNode;  // set previous of existing first to new node
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
            this.last.next = newNode;
            newNode.prev = this.last;
        }

        this.last = newNode;
    }

    public Node deleteFirst() {
        Node currentNode = this.first;

        if(this.first.next == null) {   // only one item in the list
            this.last = null;
        } else {
            this.first.next.prev = null;
        }

        this.first = currentNode.next;

        return currentNode;
    }

    public Node deleteLast() {
        Node currentNode = this.last;

        if(this.last.prev == null) {
            this.first = null;
        } else {
            this.last.prev.next = null;
        }

        this.last = this.last.prev;

        return currentNode;
    }

    public boolean insertAfter(int key, int data) {
        Node currentNode = this.first;

        while(currentNode.data != key) {
            currentNode = currentNode.next;

            if(currentNode == null) {
                return false;
            }
        }

        Node newNode = new Node();
        newNode.data = data;

        if(currentNode == this.last) {
            this.last = newNode;
        } else {
            Node formerNext = currentNode.next;
            newNode.next = formerNext;
            formerNext.prev = newNode;
        }

        newNode.prev = currentNode;
        currentNode.next = newNode;

        return true;

    }

    public Node deleteKey(int key) {

        Node currentNode = this.first;

        while(currentNode.data != key) {

            currentNode = currentNode.next;
            if(currentNode == null) {
                return null;
            }
        }

        if(currentNode == this.first) {
            this.first = currentNode.next;
        }

        if(currentNode == this.last) {
            this.last = currentNode.prev;
        }

        currentNode.next.prev = currentNode.prev;
        currentNode.prev.next = currentNode.next;

        return currentNode;
    }
}
