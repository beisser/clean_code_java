package com.github.beisser.challenges.string;

class OneAway {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        isOneAway("abcde", "abcd");  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {

        // false wenn sich die Länge der Strings um mehr als 1 unterscheidet
        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }




        return false;
    }

    private static boolean isOneAwaySameLength(String s1, String s2) {

        boolean result = false;

        // wenn beide gleich lang sind
        // dürfen sie sich in einem char unterscheiden
        if(s1.length() == s2.length()) {
            int differentChars = 0;
            for (int i = 0; i < s1.length(); i++) {
                char char1 = s1.charAt(i);
                char char2  = s2.charAt(i);

                if(char1 != char2) {
                    differentChars++;
                }
            }

            if(differentChars <= 1) {
                result = true;
            }

        }

        return result;
    }

}
