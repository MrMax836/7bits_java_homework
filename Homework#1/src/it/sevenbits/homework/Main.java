package it.sevenbits.homework;

import it.sevenbits.homework.formatter.Formatter;

public class Main {

    public static void main(String[] args) {
        String pattern = "([a-z,A-Z,(,),.,,+,=,', ]+\\{)|" +
                "([a-z,A-Z,(,),.,,+,=,', ]+;" +
                "|}|\\{)";

        Formatter formatter = new Formatter(pattern);
        String test2 = formatter.format("aaa { bbbb; ccc;}");
        System.out.println("TEST_1:");
        System.out.println(test2);

        formatter = new Formatter(pattern);
        String test1 = formatter.format("aaa() { bbbb; aaa(args) { bbbb; ccc; { } } ccc;}");
        System.out.println("TEST_2:");
        System.out.println(test1);

        formatter = new Formatter(pattern);
        String test3 = formatter.format("aaa() {{{ bbbb; aaa(args) { bbbb; ccc; {{{}}} } ccc;}}}");
        System.out.println("TEST_3:");
        System.out.println(test3);

        formatter = new Formatter(pattern);
        String t = "while (inputStream.hasNext()) {\n" +
                "   char symbol = inputStream.read();\n" +
                "   if (symbol == ' ') {\n" +
                "       whiteSpaceCount++;\n" +
                "   }\n" +
                "}";
        String test4 = formatter.format(t);
        System.out.println("TEST_4:");
        System.out.println(test4);
    }
}
