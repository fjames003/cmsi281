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

    public static void main(String[] args) {
        Node<String> first = new Node<String>("Mike");
        Node<String> second = new Node<String>("Megally");
        Node<String> third = new Node<String>("Class");
        Node<String> fourth = new Node<String>("value");

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        printLinkedList(first);
    }

    private static void printLinkedList(Node<String> head) {
        Node<String> current = head;
        while(current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}