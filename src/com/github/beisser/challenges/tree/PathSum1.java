package com.github.beisser.challenges.tree;

// Voraussetzung: Gegeben ist ein BinaryTree und eine Zahl
// Ziel: Herausfinden ob es vom Root zu einem Leaf einen Pfad im Baum bei dem die Summe der Nodes diese Zahl ergeben
class PathSum1 {

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

        System.out.println(hasSum(root, 454));
    }

    public static boolean hasSum(Node node, int sum) {

        if(node == null) {
            return false;
        }

        // summe reduzieren um Node value
        // um an Rekursion weiterzugeben
        sum -= node.value;

        // wenn es sich um einen Leaf handelt, also der aktuelle Node keine
        // children mehr hat dann vergleichen ob bei 0 angekommen
        if(node.left == null && node.right == null) {
            return sum == 0;
        }

        return hasSum(node.right, sum) || hasSum(node.left, sum);

    }

}

