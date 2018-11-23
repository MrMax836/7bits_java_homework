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
                act2();
                prev = cur;
            }
        }
        act2();
        return result.toString();
    }
//    public String format(String input) {
//        int len = input.length();
//        for (int i = 0; i < len; i++) {
//            if (i == 0) {
//                prev = input.charAt(i);
//            } else {
//                cur = input.charAt(i);
//                act();
//                prev = cur;
//            }
//            if (isNewLine) {
//                addTab();
//                isNewLine = false;
//            }
//        }
//        act();
//        return result.toString();
//    }

    private void action() {
        if (isAlpha(prev) && isAlpha(cur)) {
            result.append(prev);
        }
        else if (isAlpha(prev) && cur == ' ') {
            result.append(prev);
        }
        else if (isAlpha(prev) && cur == ';') {
            result.append(prev);
        }
        else if (prev == ' ' && isAlpha(cur)) {
            result.append(prev);
        }
        else if (prev == ' ' && cur == ' ') {
            ;
        }
        else if (prev == ' ' && cur == '{') {
            result.append(prev);
//            addTab();
        }
        else if (prev == ' ' && cur == '\n') {
            ;
        }
        else if (prev == '{' && isAlpha(cur)) {
            tabCount++;
            result.append(prev).append('\n');
            addTab();
        }
        else if (prev == '{' && (cur == ' ' || cur == '\n')) {
            tabCount++;
            result.append(prev).append('\n');
            addTab();
        }
        else if (prev == '}' && cur == '\n') {
            tabCount--;
            addTab();
            result.append(prev);
        }
        else if (prev == ';' && isAlpha(cur)) {
            result.append(prev).append('\n');   // \n ?
            addTab();
        }
        else if (prev == ';' && cur == ' ') {
            result.append(prev);
        }
        else if (prev == ';' && cur == '\n') {
            result.append(prev).append('\n');
            addTab();
        }
//        else if (prev == '\n' && isAlpha(cur)) {
//            result.append('\n');
//            addTab();
//        }
        else if (prev == '\n' && cur == '}') {
//            addTab();
            result.append('\n');
        }
        else if (prev == '}') {
            tabCount--;
            addTab();
            result.append(prev);
        }
    }

//    private void act() {
//        if (prev == ' ' && cur == ' ') {
//            ; // pass
//        }
//        else if (prev == ' ' && cur == '}') {
//            tabCount--;
//            ; // pass
//        }
//        else if (isAlpha(prev) && cur == ' ') {
//            result.append(prev).append(cur);
//        }
//
//        else if (isAlpha(prev)) {
//            result.append(prev);
//        }
//        else if (prev == '{') {
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
//            tabCount--;
////            result.setLength(result.length() - 1);  // delete tabulate(костыль)
////            addTab();
//            result.append(prev);
//        }
//        else if (prev == '\n' && cur == ' ') {
//            result.append(prev);
//            isNewLine = true;
////            addTab();
//        }
//        else if (prev == '}') {
////            tabCount--;
//            result.append(prev);
//        }
//    }

    private void act2() {
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

        else if (isAlpha(prev)) {
            result.append(prev);
        }
        else if (prev == '{') {
            result.append(prev);
            tabCount++;
        }
        else if (prev ==';' && cur != '\n') {
            result.append(prev);
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
