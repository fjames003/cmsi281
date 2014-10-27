package edu.lmu.cmsi281.assignment4;
import edu.lmu.cmsi281.assignment4.core.Node;
import edu.lmu.cmsi281.assignment4.core.iterators.MostRecentArrayIterator;
import edu.lmu.cmsi281.assignment4.core.NmostRecent;
import java.util.Iterator;

public class ArrayNmostRecent<E> extends NmostRecent<E> {  
    private Node<E>[] list;
    private int currentItem = 0;

    public ArrayNmostRecent(int size) {
        super(size);
        this.list = new Node[this.size];
    }

    @Override
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null items");
        } 
        if (this.currentItem < this.size) {
            this.list[this.currentItem] = new Node<E>(item);
            this.currentItem++;
        } else {
            Node<E>[] temp = new Node[this.size];
            for (int i = 0; i < this.size - 1; i++) {
                temp[i] = this.list[i + 1];
            }
            temp[this.size - 1] = new Node<E>(item);
            this.list = temp;
        }
    }

    @Override
    public E getOldest() {
        if (this.currentItem == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list[0].getValue();
    }

    @Override
    public E getRecent() {
        if (this.currentItem == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list[this.currentItem - 1].getValue();
    }

    @Override
    public int getSize() {
        return this.currentItem;
    }

    @Override
    public void reset() {
        if (this.currentItem != 0) {
            for (int i =0; i < currentItem; i++) {
                this.list[i] = null;
            }
            this.currentItem = 0;
        }

    }
    
    @Override
    public Iterator<E> iterator() {
        return new MostRecentArrayIterator<E>(this.list);
    } 
}