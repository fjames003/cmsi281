package edu.lmu.cmsi281.assignment4.core;

public class Node<T> {
    private T value = null;
    private Node<T> next = null;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}