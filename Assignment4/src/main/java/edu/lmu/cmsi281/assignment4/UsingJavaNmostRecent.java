package edu.lmu.cmsi281.assignment4;

import edu.lmu.cmsi281.assignment4.core.NmostRecent;
import java.util.LinkedList;
import java.util.Iterator;

public class UsingJavaNmostRecent<E> extends NmostRecent<E> {
    private LinkedList<E> list;

    public UsingJavaNmostRecent(int size) {
       super(size);
        this.list = new LinkedList();
    }

    @Override
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null items");
        } else if (this.list.size() >= this.size) {
            this.list.removeFirst();
        } 
        this.list.add(item);
    }

    @Override
    public E getOldest() {
        if (this.list.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list.getFirst();
    }

    @Override
    public E getRecent() {
        if (this.list.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list.getLast();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public void reset() {
        this.list.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.listIterator(0);
    }
}