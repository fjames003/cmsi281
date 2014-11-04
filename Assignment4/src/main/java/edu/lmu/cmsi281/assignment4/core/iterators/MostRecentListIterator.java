package edu.lmu.cmsi281.assignment4.core.iterators;
import java.util.Iterator;
import edu.lmu.cmsi281.assignment4.core.Node;

public class MostRecentListIterator<E> implements Iterator<E> {
    private Node<E> head;

    public MostRecentListIterator(Node<E> start) {
        this.head = start;
    }

    public E next() {
        return this.head.getValue();
    }
    public boolean hasNext() {
        this.head = this.head.getNext();

        return this.head == null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not allowed...");
    }
}