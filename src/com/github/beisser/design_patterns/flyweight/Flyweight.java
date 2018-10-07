package com.github.beisser.design_patterns.flyweight;

import java.util.Arrays;

/**
 * Flyweight
 *
 * use less memory by avoiding redundant data storage
 * e.g. common or similar data like a hobby is only stored once in a cache (map or something) and only referenced
 * by the objects which use it using indices
 *
 * e.g. textmarker
 */

// this approach is bad because it takes much memory
// for each character the info if it is marked or not is stored in an array
class Textmarker {

    private String text;
    private boolean[] marked;

    public Textmarker(String text) {
        this.text = text;
        this.marked = new boolean[text.length()];
    }

    public void mark(int start, int end) {
        for(int i = start; i <= end; i++) {
            this.marked[i] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);
            stringBuilder.append(this.marked[i] ? Character.toUpperCase(c) : c);
        }
        return stringBuilder.toString();
    }
}

// better approach
// only the start and the end of the marking are stored
// therefore less memory is used
class BetterTextmarker {

    private String text;
    private Marker marker;

    public BetterTextmarker(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);
            if(this.marker != null && marker.isMarked(i)) {
                stringBuilder.append(Character.toUpperCase(c));
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public void markText(int start, int end) {
        this.marker = new Marker(start, end);
    }

    public class Marker {

        private int start, end;

        public Marker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isMarked(int position) {
            return position >= this.start && position <= this.end;
        }

    }
}

class TextmarkerDemo {

    public static void main(String[] args) {
        BetterTextmarker text = new BetterTextmarker("Die ist ein Text");
        text.markText(1,4);
        System.out.println(text);
    }

}