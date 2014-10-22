package edu.lmu.cmsi281.assignment4.core;
import java.util.Iterator;
import edu.lmu.cmsi281.assignment4.core.Node;

public class MostRecentArrayIterator<E> implements Iterator<E> {
    private Node<E>[] list;
    private int currentObject;

    public MostRecentArrayIterator(Node<E>[] list) {
        this.list = list;
        this.currentObject = 0;
    }

    public E next() {
        return this.list[this.currentObject].getValue();
    }
    public boolean hasNext() {
        this.currentObject = this.currentObject + 1;
        return this.list[this.currentObject] == null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not allowed...");
    }
}