package com.github.beisser.aud.data_structures.hash_table;

class HashTableExample {

    public static void main(String[] args) {

    }

}

class HashTable {

    String[] hashArray;

    // muss eine Primzahl sein
    int arraySize;

    // Anzahl der Elemente im HashTable
    int size = 0;

    public HashTable(int arraySize) {

        // Die Größe muss eine Primzahl sein
        // Wenn sie das nicht ist, wird die nächste höhere Primzahl ermittelt
        if(!isPrime(arraySize)) {
            int nextPrime = getNextPrime(this.arraySize);
            this.arraySize = nextPrime;
        } else {
            this.arraySize = arraySize;
        }

        hashArray = new String[this.arraySize];
    }

    public void insert(String word) {

        // idealen Index und Schrittgröße errechnen
        int index = hashOne(word);
        int stepSize = hashTwo(word);

        // so lange suchen bis man eine freie Stelle im Array gefunden hat
        while(hashArray[index] != null) {

            // wenn Position besetzt ist wird der Index um eine Stepsize erhöht
            // und auf den Index Modulo Arraysize durchgeführt
            index += stepSize;
            index = index % arraySize;
        }

        hashArray[index] = word;
        size++;
    }

    public String find(String word) {

        // idealen Index und Schrittgröße errechnen
        int index = hashOne(word);
        int stepSize = hashTwo(word);

        // so lange suchen bis man eine freie Stelle im Array gefunden hat
        while(hashArray[index] != null) {

            if(hashArray[index].equals(word)) {
                return hashArray[index];
            }

            // wenn Position besetzt ist wird der Index um eine Stepsize erhöht
            // und auf den Index Modulo Arraysize durchgeführt
            index += stepSize;
            index = index % arraySize;
        }

        return hashArray[index];
    }

    // zunächst wird die ideale Position des Strings im Array errechnet
    // Java bringt hier schon eine Hashing-Funktion für Strings mit
    // und gibt ein Integer zurück, der allerdings negativ sein kann
    // wenn an der errechneten Position noch kein anderes Element ist
    // ist man schon fertig
    // andernfalls muss hashTwo aufgerufen werden
    private int hashOne(String word) {
        int hash = word.hashCode();
        hash = hash % arraySize;

        if(hash < 0) {
            hash += arraySize;
        }

        return hash;
    }

    // gibt die Stepsize an
    private int hashTwo(String word) {
        int hash = word.hashCode();
        hash = hash % arraySize;

        if(hash < 0) {
            hash += arraySize;
        }

        // Wert der hier gewählt wird (hier 3) ist beliebige Primzahl
        // welche jedoch kleiner als die arraySize sein muss
        return 3 - hash % 3;
    }

    // prüft ob es sich um eine Primzahl handelt
    private boolean isPrime(int number) {
        for(int i = 2; i * i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int number) {
        for(int i = number; true; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

}
