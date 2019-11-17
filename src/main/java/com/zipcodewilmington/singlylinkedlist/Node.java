package com.zipcodewilmington.singlylinkedlist;

public class Node {

    private Object data;
    private Node prevNode;
    private Node nextNode;

    public Node(Object dataValue, Node nextValue, Node previousValue){
        this.data = dataValue;
        this.nextNode = nextValue;
        this.prevNode = previousValue;
    }

    public Node(Object dataValue, Node nextValue){
        this.nextNode = nextValue;
        this.prevNode = null;
        this.data = dataValue;
    }

    public Node(Object dataValue){
        this.nextNode = null;
        this.prevNode = null;
        this.data = dataValue;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object dataValue) {
        this.data = dataValue;
    }

    public Node getPrev() {
        return prevNode;
    }

    public void setPrev(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNext() {
        return nextNode;
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }
}
