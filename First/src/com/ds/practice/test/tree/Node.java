package com.ds.practice.test.tree;

public class Node {
    private Object data;
    private Node next;

    public Node(Object data) {
        this.data = data;
        this.setNext(null);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "-" + (getNext() == null ? "null" : getNext());
    }
}
