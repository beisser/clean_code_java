package com.github.beisser.aud.data_structures.heap;

import java.util.Arrays;

class HeapExample {

    public static void main(String[] args) {

        Heap heap = new Heap(20);

        heap.insert(17);
        heap.insert(15);
        heap.insert(9);
        heap.insert(12);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);

        System.out.println("AFTER INSERT");
        heap.printHeap();

        heap.remove();

        System.out.println("AFTER REMOVE");
        heap.printHeap();

    }

}

class Heap {

    private Node[] heapArray;
    private int maxSize;

    // Index des nächsten verfügbaren Slots im Array
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {

        if(currentSize >= maxSize) {
            return false;
        }

        Node newNode = new Node(key);

        // neuen Node an nächstem Slot einfügen
        heapArray[currentSize] = newNode;

        // neuen Node richtig einsortieren
        swapUp(currentSize);

        // neuen nächsten freien Slot setzen
        currentSize++;

        return true;
    }

    // Geht den Max Heap nach oben indem der Wert an Position currentIndex
    // mit dem Wert des Parent verglichen wird
    // ist der aktuelle Wert größer als der Parent, werden die Positionen von aktueller Wert und Parent getauscht
    // das Procedere wird so lange durchgezogen bis der aktuelle Wert nicht mehr größer als der Parent ist oder
    // der Root Node erreicht ist
    private void swapUp(int currentIndex) {

        int parentIndex = (currentIndex - 1) / 2;
        Node currentNode = heapArray[currentIndex];

        // currentIndex darf nicht 0  sein -> wäre der Root Node
        // zudem nur solange loopen solange Parent kleiner dem Current Node ist
        while(currentIndex > 0 &&  heapArray[parentIndex].getKey() < currentNode.getKey()) {

            // parent hinunterschieben
            heapArray[currentIndex] = heapArray[parentIndex];

            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;

        }

        // wenn alle kleineren Werte nach unten geschoben wurden kann der Current Node gesetzt werden
        heapArray[currentIndex] = currentNode;

    }

    // Beim Löschen wird zunächst der Root Node mit dem letzten Element im Heap ersetzt
    // Das letzte Element (welches nun am Root ist) wird mit den Children verglichen und falls kleiner nach unten
    // vertauscht
    // der gelöschte Node soll zurückgegeben werden
    public Node remove() {
        Node root = heapArray[0];

        // letztes Element als Root setzen
        heapArray[0] = heapArray[--currentSize];

        swapDown(0);

        return root;
    }

    private void swapDown(int index) {

        int largerChildIndex;

        // Node welcher nach unten geswapped werden soll (ehemals letzter Node)
        Node currentNode = heapArray[index];

        // solange mindestens 1 Children vorhanden ist
        while(index < currentSize / 2) {

            int indexLeftChild = 2 * index + 1;
            int indexRightChild = 2* index + 2;

            // welcher von beiden Children ist größer
            if(indexRightChild < currentSize && heapArray[indexLeftChild].getKey() < heapArray[indexRightChild].getKey()) {
                largerChildIndex = indexRightChild;
            } else {
                largerChildIndex = indexLeftChild;
            }

            if(currentNode.getKey() >= heapArray[largerChildIndex].getKey()) {
                break;
            }

            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;

        }

        heapArray[index] = currentNode;


    }

    public void printHeap() {
        Arrays.stream(heapArray)
                .filter(node -> node != null)
                .forEach(node -> System.out.println(node.getKey()));
    }
}
