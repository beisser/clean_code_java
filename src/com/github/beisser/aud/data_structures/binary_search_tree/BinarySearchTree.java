package com.github.beisser.aud.data_structures.binary_search_tree;


class BinarySearchTreeExample {
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10, "Ten");
        binarySearchTree.insert(20, "Twenty");
        binarySearchTree.insert(50, "Fifty");

        System.out.println(binarySearchTree.findMax());
        System.out.println(binarySearchTree.remove(10));
        System.out.println(binarySearchTree.findMin());
    }
}

class BinarySearchTree {

    private Node root;  //rootnode

    public void insert(int key, String value) {

        Node newNode = new Node(key, value);

        // Wenn root node null ist gibt es noch keinen Tree
        // daher wird die Root Node erstellt
        if(root == null) {
            root = newNode;

        // Wenn bereits ein root existiert muss der neue Node korrekt in den bestehenden
        // Tree einsortiert werden
        } else {

            // Variablen für das Traversieren
            Node current = root;        // Aktueller Node
            Node parent;                // immer der Parent des Current Node

            while(true) {

                parent = current;

                if(key < current.key) {         // we need to go left
                    current = current.left;     // Ein Node nach unten

                    if(current == null) {       // wenn left null ist kann man hier den neuen Node einfügen
                        parent.left = newNode;
                        return;
                    }

                } else {                        // we need to go right
                    current = current.right;    // Ein Node nach unten

                    if(current == null) {       // wenn left null ist kann man hier den neuen Node einfügen
                        parent.right = newNode;
                        return;
                    }
                }
            }

        }

    }

    // find the smallest number
    public Node findMin() {
        Node current = root;        // Aktueller Node
        Node last = null;

        // man muss lediglich immer nur links traversieren
        // da man sicher gehen kann dass der kleinste Wert ganz links im Baum ist
        while(current != null) {
            last = current;
            current = current.left;
        }

        return last;
    }

    // find the largest number
    public Node findMax() {
        Node current = root;        // Aktueller Node
        Node last = null;

        // man muss lediglich immer nur rechts traversieren
        // da man sicher gehen kann dass der größte Wert ganz rechts im Baum ist
        while(current != null) {
            last = current;
            current = current.right;
        }

        return last;
    }

    public boolean remove(int key) {

        Node current = root;
        Node parent = root;

        boolean isLeftChild = false;

        // Nach dem zu löschenden Node suchen
        // Dabei wird den Baum runter traversiert und current immer auf den nächsten Node (links oder rechts je nach
        // Ergebnis)
        while(current.key != key) {

            parent = current;

            if(key < current.key) {         // we need to go left
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            // Wenn kein Node mit dem Wert gefunden wurde
            if(current == null) {
                return false;
            }
        }

        // Node zum löschen wurde gefunden
        Node nodeToDelete = current;

        // Wenn Leaf Node ist das Löschen einfach
        if(nodeToDelete.left == null && nodeToDelete.right == null) {
            if(nodeToDelete == root) {
                root = null;
            } else if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Wenn Node EINEN Child Node hat und dieser auf der linken Seite ist
        else if(nodeToDelete.right == null) {
            if(nodeToDelete == root) {
                root = nodeToDelete.left;
            } else if(isLeftChild) {
                parent.left = nodeToDelete.left;
            } else {
                parent.right = nodeToDelete.left;
            }
        }

        // Wenn Node EINEN Child Node hat und dieser auf der rechten Seite ist
        else if(nodeToDelete.left == null) {
            if(nodeToDelete == root) {
                root = nodeToDelete.right;
            } else if(isLeftChild) {
                parent.left = nodeToDelete.right;
            } else {
                parent.right = nodeToDelete.right;
            }
        }

        // Wenn Node zwei Child Nodes hat
        else {

            // Successor wird später an die Stelle des zu löschenden Nodes gepackt
            // auf diese Weise bleibt der Binary Search Tree valide
            Node successor = this.getSuccessor(nodeToDelete);

            if(nodeToDelete == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

            // eventuelle left nodes des zu löschenden Nodes werden nun auf die Linke Seite des Successors
            // angehängt
            successor.left = nodeToDelete.left;
        }

        return true;
    }

    // gibt den Node welcher ausgehend vom Node welcher gelöscht werden soll
    // ganz links im Subtree ist
    private Node getSuccessor(Node nodeToDelete) {

        // erst einmal nach rechts
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        Node current = nodeToDelete.right;

        // dann immer weiter nach links bis kein Child mehr
        // dieser Node ohne child ganz links ist der successor
        while(current != null) {

            successorParent = successor;
            successor = current;
            current = current.left;

        }

        if(successor != nodeToDelete.right) {
            successorParent.left = successor.right;
            successor.right = nodeToDelete.right;
        }

        return successor;

    }
}
