package edu.lmu.cmsi281.assignment4;
import edu.lmu.cmsi281.assignment4.core.Node;
import edu.lmu.cmsi281.assignment4.core.MostRecentArrayIterator;
import java.util.Iterator;

public class ArrayNmostRecent<E> implements Iterable<E> {  
    private Node<E>[] list;
    private int currentItem = 0;
    private int size;

    public ArrayNmostRecent(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("List must have a size greater than 0");
        }
        this.size = size;
        this.list = new Node[this.size];
    }

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

    public E getOldest() {
        if (this.currentItem == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list[0].getValue();
    }

    public E getRecent() {
        if (this.currentItem == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.list[this.currentItem - 1].getValue();
    }

    public int getSize() {
        return this.currentItem;
    }

    public void reset() {
        if (this.currentItem != 0) {
            for (int i =0; i < currentItem; i++) {
                this.list[i] = null;
            }
            this.currentItem = 0;
        }
    }
   
    
    public Iterator<E> iterator() {
        return new MostRecentArrayIterator<E>(this.list);
    } 
}