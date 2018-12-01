package com.github.beisser.challenges.linked_list;

import java.util.Stack;

public class NthElement {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        // nthFromLast(head, 1) should return 1.
        System.out.println(nthFromLast(head,1));

        // nthFromLast(head, 5) should return 5.
        System.out.println(nthFromLast(head,5));

        // nthFromLast(head2, 2) should return 3.
        System.out.println(nthFromLast(head2, 2));

        // nthFromLast(head2, 4) should return 1.
        System.out.println(nthFromLast(head2, 4));

        // nthFromLast(head2, 5) should return null.
        System.out.println(nthFromLast(head2, 5));

        // nthFromLast(null, 1) should return null.
        System.out.println(nthFromLast(null, 1));
    }

    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        Stack<Node> nodeStack = new Stack<>();
        Node resultNode = null;

        if(head == null) {
            return null;
        }

        while(head != null) {
            nodeStack.push(head);
            head = head.child;
        }

        for(int i = 0; i < n; i++) {

            if(nodeStack.size() > 0) {
                resultNode = nodeStack.pop();
            } else {
                return null;
            }
        }

        return resultNode;
    }
}
