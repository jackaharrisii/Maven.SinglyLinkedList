package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private Node head;
    private static int listCount;

    public SinglyLinkedList(){
        head = new Node(null);
        listCount = 0;
    }

    // adding a new node to the end of the list
    public void add (Object data){
        if (head == null){                             //if adding the first element to the list
            head = new Node(data);
        }
        Node tempNode = new Node(data);                // saves the new node to be added later
        Node currentNode = head;                       // starts at the beginning

        if (currentNode != null) {                     // in case of null pointer exceptions
            while (currentNode.getNext() != null) {    // as long as the next node exists
                currentNode = currentNode.getNext();   // make the current node equal the next node
            }
            currentNode.setNext(tempNode);             // saves the new node as the last element in the list
        }
        incrementCounter();                            // increment the count of nodes in the list
    }

    // adding a new node to a specific index in the list
    public void add (Object data, int index){
        Node tempNode = new Node(data);                // saves the new node to be added later
        Node currentNode = head;                       // starts at the beginning

        if (currentNode != null) {                     // in case of null pointer exceptions
            for (int i = 0; i < index && currentNode.getNext() != null; i++){    // find the directed index, or the end if larger than the current size
                currentNode = currentNode.getNext();
            }
        }
        tempNode.setNext(currentNode.getNext());      // sets the next node to now be after the node being inserted
        currentNode.setNext(tempNode);                // sets the node being inserted as next after the current node
        incrementCounter();                           // increment the count of nodes in the list
    }

    public Object get(int index){
        if (index < 0){ return null; }                // prevents out of bounds exception
        Node currentNode = null;
        if (head != null){                            // prevents null pointer exception
            currentNode = head.getNext();             // starts at index 0 (NOTE - HEAD IS NOT PART OF THE LIST, HEAD.GETNEXT IS INDEX 0)
            for (int i = 0; i < index; i++) {         // iterates through the list if index is greater than 0 (if index = 0, skips the loop)
                if (currentNode.getNext() == null) {  // returns null if it hasn't found it in the list
                    return null;
                }
                currentNode = currentNode.getNext();  // sets the current to the next item
            }
            return currentNode.getData();             // returns the found node data
        }
        return currentNode;                           // returns current
    }

    public boolean remove (int index) {
        if (index < 1 || index > size()) { return false; }        // ensures the index exists
        Node currentNode = head;                                          // starts at the head
        if (head != null) {                                               // avoids NPE
            for (int i = 0; i < index; i++) {                             // iterates through the nodes
                if (currentNode.getNext() == null) {                      // if it hasn't found it, returns false (i.e., nothing was removed)
                    return false;
                }
                currentNode = currentNode.getNext();                      // if it's not at the directed index yet, keep going
            }
            currentNode.setNext((currentNode.getNext().getNext()));       // sets the current node to skip the removed node
                                                                          // do I also need to set the next nodes previous to the current node?
            decrementCounter();                                           // adjust the list size
            return true;                                                  // lets us know that a node was successfully removed
        }
        return false;
    }

    public String toString() {
        String output = "";
        if (head != null) {
            Node currentNode = head.getNext();
            while (currentNode != null) {
                output += "[" + currentNode.getData().toString() + "]";
                currentNode = currentNode.getNext();
            }
        }
        return output;

    }
    public int size(){
        return listCount;
    }

    private static void incrementCounter(){
        listCount++;
    }

    private static void decrementCounter(){
        listCount--;
    }

}
