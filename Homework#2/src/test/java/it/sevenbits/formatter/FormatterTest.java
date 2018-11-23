package it.sevenbits.formatter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private Formatter formatter;
    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void testOne() {
        String original = "aaa    {\n" +
                "    bbbb;\n" +
                "    ccc;\n" +
                "}";
        String result = formatter.format(original);
        String ideal =  "aaa {\n" +
                "    bbbb;\n" +
                "    ccc;\n" +
                "}";
        assertEquals("wrong formatter",
                ideal, result);
    }

    @Test
    public void testTwo() {
        String original = "while    (inputStream.hasNext())  {\n" +
                "   char symbol = inputStream.read();\n" +
                "   if  (symbol == ' ') {\n" +
                "       whiteSpaceCount++;\n" +
                "    }\n" +
                "}";
        String result = formatter.format(original);
        String ideal =  "while (inputStream.hasNext()) {\n" +
                        "    char symbol = inputStream.read();\n" +
                        "    if (symbol == ' ') {\n" +
                        "        whiteSpaceCount++;\n" +
                        "    }\n" +
                        "}";
        assertEquals("wrong formatter",
                ideal, result);
    }

    @Test
    public void testThree() {
        String original = "while   (inputStream.hasNext())  {\n" +
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
        String result = formatter.format(original);
        String ideal =  "while (inputStream.hasNext()) {\n" +
            "    char symbol = inputStream.read();\n" +
            "    if (symbol == ' ') {\n" +
            "        whiteSpaceCount++;\n" +
            "        if (symbol == ' ') {\n" +
            "            whiteSpaceCount++;\n" +
            "            whiteSpaceCount++;\n" +
            "            whiteSpaceCount++;\n" +
            "        }\n" +
            "    }\n" +
            "}";
        assertEquals("wrong formatter",
                ideal, result);
    }

    @Test
    public void testFour() {
        String original = "{{{}}}";
        String result = formatter.format(original);
        String ideal =  "{\n"+
                        "   {\n"+
                        "       {\n"+
                        "       }\n"+
                        "   }\n"+
                        "}";
        assertEquals("wrong formatter",
                ideal, result);
    }


    /* Неккоректный тест - в условии ошибка, которая даёт понять в чём проблема*/
    @Test
    public void testFive() {
        String original = "aaa{bbbb;ccc;}";
        String result = formatter.format(original);
        String ideal =  "aaa {\n"+
                        "    bbbb;\n"+
                        "    ccc;\n"+
                        "    \n"+
                        "}";
        assertEquals("wrong formatter",
                ideal, result);
    }

}
//    String test6 = "aaa { bbbb; ccc; }";
//
//    String test7 = "aaa { bbbb;ccc; }";