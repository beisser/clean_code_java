package com.github.beisser.challenges.string;

import java.util.Arrays;

/**
 * Challenge: Extract categories from a given string
 *  - categories are marked with category:categoryName
 *  - print out all categories
 */
class ExtractAndPrint {

    public static void main(String[] args) {

        String str = "We have a large inventory of things in out warehouse falling in the "
                + "the category:apperal and the slightly "
                + "more in demand category:makeup along with the category:furniture and ...";

        printCategories(str);

    }

    public static void printCategories(String str) {

        String[] splitted = str.split(" ");
        Arrays.stream(splitted)
                .filter(subString -> subString.startsWith("category:"))
                .forEach(subString -> {

                    int index = subString.indexOf(":");
                    String category = subString.substring(index + 1);

                    System.out.println(category);
                });

    }

}
