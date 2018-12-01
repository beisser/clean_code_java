package com.github.beisser.challenges.tree;

// Voraussetzung: Gegeben ist ein BinaryTree und eine Zahl
// Ziel: Herausfinden wie viele Pfade es von oben nach unten gibt (muss nicht von root beginnen) deren Summe von Nodes
// die übergebene Summe ergibt
class PathSum2 {

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

}

