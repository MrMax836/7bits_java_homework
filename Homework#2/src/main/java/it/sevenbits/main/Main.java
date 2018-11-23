package it.sevenbits.main;

import it.sevenbits.formatter.Formatter;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        String test1 = "aaa {\n" +
                "    bbbb;\n" +
                "    ccc;\n" +
                "}";

        String test2 = "while   (inputStream.hasNext())  {\n" +
                "   char symbol = inputStream.read();\n" +
                "   if (symbol == ' ') {\n" +
                "       whiteSpaceCount++;\n" +
                "   }\n" +
                "}";

        String test3 = "while   (inputStream.hasNext())  {\n" +
                "   char symbol = inputStream.read();\n" +
                "   if (symbol      == ' ') {\n" +
                "       whiteSpaceCount++;\n" +
                "       if (symbol == ' ') {\n" +
                "           whiteSpaceCount++;\n" +
                "           whiteSpaceCount++;\n" +
                "           whiteSpaceCount++;\n" +
                "       }\n" +
                "   }\n" +
                "}";
        String test4 = "{{{}}}";
        System.out.println("Test 1:\n" + formatter.format(test1) + "\n");
        formatter = new Formatter();
        System.out.println("Test 2:\n" + formatter.format(test2) + "\n");
        formatter = new Formatter();
        System.out.println("Test 3:\n" + formatter.format(test3) + "\n");
        formatter = new Formatter();
        System.out.println("Test 4:\n" + formatter.format(test4) + "\n");
    }
}
