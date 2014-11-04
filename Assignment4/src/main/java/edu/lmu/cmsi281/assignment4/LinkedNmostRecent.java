package edu.lmu.cmsi281.assignment4;

import edu.lmu.cmsi281.assignment4.core.Node;
import edu.lmu.cmsi281.assignment4.core.iterators.MostRecentListIterator;
import edu.lmu.cmsi281.assignment4.core.NmostRecent;
import java.util.Iterator;

public class LinkedNmostRecent<E> extends NmostRecent<E> {  
    private Node<E> head;
    private Node<E> end;
    private int currentItem = 0;

    public LinkedNmostRecent(int size) {
        super(size);
    }

    @Override
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null items");
        }
        Node<E> tempItem = new Node<E>(item);
        if (this.currentItem == 0) {
            this.head = tempItem;
            this.end = this.head;
            this.currentItem++;
        } else if (this.currentItem > 0 && this.currentItem < this.size){
            Node<E> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            this.currentItem++;
            current.setNext(tempItem);
            this.end = tempItem;
        } else {
            Node<E> frontTemp = this.head.getNext();
            this.head = frontTemp;
            Node<E> endTemp = this.end;
            endTemp.setNext(tempItem);
            this.end = tempItem;
        }
    }

    @Override
    public E getOldest() {
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }
        return this.head.getValue();
    }

    @Override
    public E getRecent() {
        if (this.end == null) {
            throw new IllegalStateException("List is empty");
        }
        return this.end.getValue();
    }

    @Override
    public int getSize() {
        return this.currentItem;
    }

    @Override
    public void reset() {
        if (this.head != null) {
            Node<E> temp = this.head.getNext();
            Node<E> temp2 = temp;
            this.head = null;
            while (temp != null ) {
                temp = temp2.getNext();
                temp2 = null;
                temp2 = temp;
            }
            this.currentItem = 0;
        }
    }
   
    @Override
    public Iterator<E> iterator() {
        return new MostRecentListIterator<E>(this.head);
    } 
}