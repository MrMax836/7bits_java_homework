package it.sevenbits.homework.splitter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private String pattern;

    public Splitter(String pattern) {
        this.pattern = pattern;
    }

    public ArrayList<String> split(String string, ArrayList<String> result) {
        Pattern p = Pattern.compile(this.pattern);
        Matcher m = p.matcher(string);

        while(m.find()) {
            result.add(string.substring(m.start(), m.end()));
        }
        return result;
    }
}
