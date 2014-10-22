package edu.lmu.cmsi281.assignment4.core;
import java.util.Iterator;
import edu.lmu.cmsi281.assignment4.core.Node;

public class MostRecentListIterator<E> implements Iterator<E> {
    private Node<E> head;
    private Node<E> currentObject;

    public MostRecentListIterator(Node<E> start) {
        this.head = start;
        this.currentObject = this.head;
    }

    public E next() {
        return this.currentObject.getValue();
    }
    public boolean hasNext() {
        this.currentObject = this.currentObject.getNext();

        return this.currentObject == null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not allowed...");
    }
}