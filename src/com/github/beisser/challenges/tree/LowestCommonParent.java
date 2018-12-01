package com.github.beisser.challenges.tree;

import java.util.Stack;

public class LowestCommonParent {

    public static void main(String[] args) {

        Node root = new Node(5);
        Node left1 = new Node(4);
        Node right1 = new Node(8);

        Node left1left = new Node(11);
        left1.left = left1left;

        Node right1left = new Node(13);
        Node right1Right = new Node(4);

        right1.left = right1left;
        right1.right = right1Right;

        root.left = left1;
        root.right = right1;


    }


    private static Stack<Node> findPathTo(Node node, int x) {

        if(node == null) {
            return null;
        }

        // Wert im Baum gefunden
        // niedrigster Punkt im Baum daher hier den Stack erstellen
        if(node.value == x) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            return stack;
        }

        Stack<Node> left = findPathTo(node.left,x);
        if(left != null) {
            left.push(node);
            return left;
        }

        Stack<Node> right = findPathTo(node.right,x);
        if(right != null) {
            right.push(node);
            return right;
        }

        return null;

    }

}
