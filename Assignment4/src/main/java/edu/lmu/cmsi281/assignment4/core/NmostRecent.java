package edu.lmu.cmsi281.assignment4.core;

import java.util.Iterator;

public abstract class NmostRecent<E> implements Iterable<E> {
    protected int size;

    public NmostRecent(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("List must have a size greater than 0");
        }
        this.size = size;
    }

    public abstract void add(E item);

    public abstract E getOldest();

    public abstract E getRecent();

    public abstract int getSize();

    public abstract void reset();

    public abstract Iterator<E> iterator();
}