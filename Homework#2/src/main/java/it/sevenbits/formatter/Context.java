package it.sevenbits.formatter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Context {
    private Queue<Character> arr;
    private int size;
    private int maxSize;
    private boolean isInit;

    public Context() {
        this.arr = new LinkedList<Character>();
        this.size = 0;
        this.isInit = false;
        this.maxSize = 2;
    }

    public void add(char symb) {
        if (arr.size() < maxSize) {
            arr.add(symb);
        }
    }

    public char pop() {
        return arr.poll();
    }

    public char getCur() {
        return this.arr[1];
    }

    public char getPrev() {
        return this.arr[0];
    }

    public boolean isInit() {
        return this.isInit;
    }
}
