package it.sevenbits.formatter;

public class Formatter {
    private StringBuilder result;
    private char cur;
    private char prev;
    String alphabet;
    private int tabCount;
    boolean isNewLine;

    public Formatter() {
        this.result = new StringBuilder();
        this.alphabet = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM.=(),\'\"+\\/<>[]";
        this.tabCount = 0;
        this.isNewLine = false;
    }

    public String format(String input) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prev = input.charAt(i);
            } else {
                cur = input.charAt(i);
                action();
                prev = cur;
            }
        }
        action();
        return result.toString();
    }

    /*################################*/
    /*  Переход на новую строку только, когда встречается символы "\n".
    /*  Минусы: не обрабатываются "{{}}"
    /*###############################*/
//    private void action() {
//        if (prev == ' ' && cur == ' ') {
//            ; // pass
//        }
//        else if (isNewLine && isAlpha(cur)) {
//            addTab();
//            isNewLine = false;
//        }
//        else if (isNewLine && cur == '}') {
//            tabCount--;
//            addTab();
//            isNewLine = false;
//        }
//        else if (isAlpha(prev) && cur == ' ') {
//            result.append(prev).append(cur);
//        }
//
//        else if (isAlpha(prev)) {
//            result.append(prev);
//        }
//        else if (prev == '{') {
//            isNewLine = true;
//            result.append(prev);
//            tabCount++;
//        }
//        else if (prev ==';' && cur != '\n') {
//            result.append(prev);
//        }
//        else if (prev ==';') {
//            result.append(prev);
//        }
//        else if (prev == '\n' && cur == '}') {
//            isNewLine = true;
//            result.append(prev).append(cur);
//        }
//        else if (prev == '\n' && cur == ' ') {
//            isNewLine = true;
//            result.append(prev);
//        }
//        else if (prev == '}') {
//            result.append(prev);
//        }
//    }





    /*################################*/
    /*  Переход на новую строку только, когда встречаются символы "{" и ";"
    /*  Попытка сделать нормальные переносы, когда встречаются "{" и "}"
    /*  Минусы: некорректно обрабатываются циклы
    /*###############################*/
    private void action() {
        if (prev == ' ' && cur == ' ') {
            ; // pass
        }
        else if (isNewLine && isAlpha(cur)) {
            addTab();
            isNewLine = false;
        }
        else if (isNewLine && cur == '}') {
            tabCount--;
            addTab();
            isNewLine = false;
        }
        else if (isAlpha(prev) && cur == ' ') {
            result.append(prev).append(cur);
        }
        else if (isAlpha(prev) && cur == '{') {
            result.append(prev).append(' ');
        }

        else if (isAlpha(prev)) {
            result.append(prev);
        }
        else if (prev == '{' && cur != '\n') {
            result.append(prev).append('\n');
            tabCount++;
            addTab();
            isNewLine = false;
        }
        else if (prev == '{') {
            isNewLine = true;
            result.append(prev);
            tabCount++;
        }
        else if (prev ==';' && cur != '\n') {
            result.append(prev);

            result.append('\n');
            addTab();
        }
        else if (prev ==';') {
            result.append(prev);
        }
        else if (prev == '\n' && cur == '}') {
            isNewLine = true;
            result.append(prev).append(cur);
        }
        else if (prev == '\n' && cur == ' ') {
            isNewLine = true;
            result.append(prev);
        }
        else if (prev == '}' && cur != '\n') {
            tabCount--;
            result.append('\n');
            addTab();
            result.append(prev);
        }
        else if (prev == '}') {
            result.append(prev);
        }
    }

    private boolean isAlpha(char symb) {
        String buff = "" + symb;
        return alphabet.contains(buff);
    }

    private void addTab() {
        for (int i = 0; i < tabCount; i++) {
            result.append("    ");
        }
    }
}
