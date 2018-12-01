package com.github.beisser.challenges.tree;

// Ziel: in einem Baum den Weg nach oben zum Root bzw. runter zu den Leafs finden der die maximale Summe ergibt
class MaxPathSum {

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

        System.out.println(maxSum(root));

    }

    public static int maxSum(Node node) {

        if(node == null) {
            return 0;
        }

        int left = maxSum(node.left);
        int right = maxSum(node.right);

        System.out.println(left + " + " + right + " + " + node.value + " = " + (Math.max(left,right) + node.value));
        return Math.max(left, right) + node.value;
    }

}

