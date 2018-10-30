package it.sevenbits.formatter;

public class Formatter {
    private Context context;
    private StringBuilder result;

    public Formatter(Context context) {
        this.context = context;
        result = new StringBuilder();
    }

    public void format(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!context.isInit()) {

            }
        }

    }
}
