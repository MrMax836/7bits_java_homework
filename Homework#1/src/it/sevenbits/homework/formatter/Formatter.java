package it.sevenbits.homework.formatter;

import it.sevenbits.homework.splitter.Splitter;

import java.util.ArrayList;

public class Formatter {
    private final String OPEN_QUAD_BRACKET = "{";
    private final String CLOSE_QUAD_BRACKET = "}";
    private ArrayList<String> lines;
    private int bracketsCount;
    private StringBuilder sb;
    private Splitter splitter;

    public Formatter(String pattern) {
        this.lines = new ArrayList<>();
        this.bracketsCount = 0;
        this.sb = new StringBuilder();
        this.splitter = new Splitter(pattern);
    }
    // TODO
    // I wanted to make State Machine, but JAVA doesn't have function pointers and
    // it became difficult;
    public String format(String str) {
        splitter.split(str, lines);
        for(String elem : lines) {
            // TODO How to simplify?
            if(elem.contains(OPEN_QUAD_BRACKET)) {
                addLine(elem);
                bracketsCount++;

            }
            else if(elem.contains(CLOSE_QUAD_BRACKET)) {
                bracketsCount--;
                addLine(elem);
            }
            else {
                addLine(elem);
            }
        }
        return sb.toString();
    }

    private void addTab() {
        for(int i = 0; i < bracketsCount; i++) {
            sb.append("    ");
        }
    }

    private void addLine(String elem) {
        addTab();
        sb.append(elem).append("\n");
    }
}
