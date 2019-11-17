package com.zipcodewilmington.singlylinkedlist;

public class Node<E> {

    private E data;
    private Node<E> prevNode;
    private Node<E> nextNode;

    public Node(E dataValue, Node<E> nextValue, Node<E> previousValue){
        this.data = dataValue;
        this.nextNode = nextValue;
        this.prevNode = previousValue;
    }

    public Node(E dataValue, Node<E> nextValue){
        this.nextNode = nextValue;
        this.prevNode = null;
        this.data = dataValue;
    }

    public Node(E dataValue){
        this.nextNode = null;
        this.prevNode = null;
        this.data = dataValue;
    }

    public boolean compareTo(Node<E> next){
        return (this.getData().toString().compareToIgnoreCase(nextNode.getData().toString()) >0);
    }

    public void swapNext(){
        E data = this.getData();
        this.setData(nextNode.getData()).getNext().setData(data);
    }

    public E getData() {
        return this.data;
    }

    public Node<E> setData(E dataValue) {
        this.data = dataValue;
        return this;
    }

    public Node<E> getPrev() {
        return this.prevNode;
    }

    public Node<E> setPrev(Node prevNode) {
        this.prevNode = prevNode;
        return this.prevNode;
    }

    public Node<E> getNext() {
        return this.nextNode;
    }

    public Node<E> setNext(Node<E> nextNode) {
        this.nextNode = nextNode;
        return this.nextNode;
    }

    public boolean hasNext(){
        return (nextNode != null);
    }
}
