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
                "   if (symbol == ' ') {\n" +
                "       whiteSpaceCount++;\n" +
                "       if (symbol == ' ') {\n" +
                "           whiteSpaceCount++;\n" +
                "           whiteSpaceCount++;\n" +
                "           whiteSpaceCount++;\n" +
                "       }\n" +
                "   }\n" +
                "}";
        System.out.println(formatter.format(test1));
        formatter = new Formatter();
        System.out.println(formatter.format(test2));
        formatter = new Formatter();
        System.out.println(formatter.format(test3));
    }
}
