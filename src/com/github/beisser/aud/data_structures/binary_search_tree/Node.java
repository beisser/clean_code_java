package com.github.beisser.aud.data_structures.binary_search_tree;

public class Node {

    int key;
    String value;
    Node left, right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
