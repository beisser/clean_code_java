package com.github.beisser.design_patterns.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Interpreter
 *
 * converting text input into objects e.g.
 *  - HTML-, XML- or JSON-Strings to object
 *  - text input from a form to an object
 *
 *  is done in two steps:
 *  - lexing -> split the text in appropriate tokens
 *  - parsing -> parse the single tokens
 */

// class to represent each single token
class Token {

    private Type type;
    public String text;

    public enum Type {
        STRING,
        PIPE
    }

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", text='" + text + '\'' +
                '}';
    }

    public Type getType() {
        return type;
    }
}

class TokenLexer {

    // turns a given string into a list of tokens
    public static List<Token> lex(String input) {

        ArrayList<Token> tokenArrayList = new ArrayList<Token>();
        for(int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                // easy case: create a pipe token
                case '|':
                    tokenArrayList.add(new Token(Token.Type.PIPE, "|"));
                    break;
                default:
                    // if the char is not a pipe take all following chars until a pipe is reached
                    StringBuilder stringBuilder = new StringBuilder("" + input.charAt(i));

                    // loop the char after the current char
                    for(int j = i + 1; j < input.length(); j++) {

                        // check if following char is not a pipe then append it
                        if(input.charAt(j) != '|') {
                            stringBuilder.append(input.charAt(j));
                            i++;
                        // otherwise add a token
                        } else {
                            tokenArrayList.add(new Token(Token.Type.STRING, stringBuilder.toString()));
                            break;
                        }

                    }
                    break;
            }
        }

        return tokenArrayList;
    }

}

// OOP-Element in which the string is converted to
// very simple approach here
interface Element {
    public String eval();
}

// implementation of OOP-Element
class StringToken implements Element {

    private String text;

    @Override
    public String eval() {
        return text;
    }

    public StringToken(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StringToken{" +
                "text='" + text + '\'' +
                '}';
    }
}

class TokenParser {
    public static Element parse(List<Token> tokens) {
        StringBuilder stringBuilder = new StringBuilder();
        tokens.stream()
                .filter(token -> token.getType().equals(Token.Type.STRING))
                .forEach(token -> stringBuilder.append(token.text));

        return new StringToken(stringBuilder.toString());

    }
}

class InterpreterDemo {

    public static void main(String[] args) {

        String input = "eins|zwei|drei";
        List<Token> tokens = TokenLexer.lex(input);

        tokens.stream().forEach( token -> {
            System.out.println(token);
        });

        System.out.println(TokenParser.parse(tokens));
    }

}


