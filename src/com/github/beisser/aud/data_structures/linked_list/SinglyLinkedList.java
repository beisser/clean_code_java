package com.github.beisser.aud.data_structures.linked_list;

public class SinglyLinkedList {

    // only needs access to the first node
    // the node knows about its next node and so on
    private Node first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node singlyNode = new Node();
        singlyNode.data = data;

        // the existing first will be moved
        singlyNode.next = this.first;

        // make the new node the first
        this.first = singlyNode;
    }

    public void insertLast(int data) {
        Node current = this.first;

        // the last node will have null as next attribute
        while(current != null) {
            current = current.next;
        }

        Node singlyNode = new Node();
        singlyNode.data = data;

        current.next = singlyNode;

    }

    public Node deleteFirst() {
        Node currentNode = this.first;
        this.first = currentNode.next;
        return currentNode;
    }
}
