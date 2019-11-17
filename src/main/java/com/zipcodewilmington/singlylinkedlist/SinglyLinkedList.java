package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private Node head;        // NOTE: HEAD IS NOT ITSELF A NODE IN THE LIST - THINK OF HEAD AS HAVING AN INDEX OF -1
    private int listCount;    // THE NUMBER OF NODES IN THE LIST

    public SinglyLinkedList(){
        listCount = 0;
    }

    // CLEARS ALL NODES FROM THE LIST
    public boolean clear (){
        if (head != null){                             // if the list exists
            head.setNext(null);                        // set the head to have no following node
            listCount = 0;                             // reset the list counter
            return true;                               // tell the user that clear was successful
        }
        return false;                                  //
    }

    // ADDING A NEW NODE TO THE END OF THE LIST
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

    // INSERTING A NEW NODE AT A SPECIFIED INDEX
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

    // REMOVES A NODE AT A SPECIFIED INDEX
    public boolean remove (int index) {
        if (index < 0 || index > size()) { return false; }                // ensures the index exists
        Node currentNode = head;                                          // starts at the head
        if (head != null) {                                               // avoids NPE
            for (int i = 0; i <= index; i++) {                            // iterates through the nodes
                if (currentNode.getNext() == null) {                      // if it hasn't found it, returns false (i.e., nothing was removed)
                    return false;
                }
                if (i == index){
                    currentNode.setNext((currentNode.getNext().getNext()));       // sets the current node (@ i-1) to skip the removed node
                    decrementCounter();                                           // adjust the list size
                    return true;                                                  // lets us know that a node was successfully removed
                }
                currentNode = currentNode.getNext();                      // if it's not at the directed index yet, keep going
            }
        }
        return false;
    }

    // CHECKS LIST TO SEE IF THE LIST CONTAINS A VALUE
    public boolean contains( Object searchData){
        int index = this.find(searchData);
        if (index >= 0) { return true; }
        else { return false; }
    }

    //RETURN INDEX OF SEARCH DATA, OR -1 IF DATA IS NOT IN THE LIST
    public int find(Object searchData){
        Node currentNode = null;
        if (head != null){                                  // prevents null pointer exception
            if (head.getNext() == null) { return -1;}       // returns -1 if the list is empty
            currentNode = head.getNext();                   // starts at index 0 (REMEMBER - HEAD IS NOT PART OF THE LIST, HEAD.GETNEXT IS INDEX 0)
            for (int i = 0; i < this.size(); i++) {         // iterates through the list if index is greater than 0 (if index = 0, skips the loop)
                if (currentNode.getData().equals(searchData)) {
                    return i;
                }
//                if (currentNode.getNext() == null) {      // returns null if it hasn't found it in the list
//                    return false;
//                }
                currentNode = currentNode.getNext();        // sets the current to the next item
            }
//            return currentNode.getData();                 // returns the found node data
        }
        return -1;                                          // returns -1 if data was not found
    }

    // RETURNS CURRENT SIZE OF THE LIST
    public int size(){
        return listCount;
    }

    // RETURNS OBJECT AT A SPECIFIED INDEX
    public Object get(int index){
        if (index < 0){ return null; }                // prevents out of bounds exception
        Node currentNode = null;
        if (head != null){                            // prevents null pointer exception
            if (head.getNext() == null) { return null;} //returns null if the list is empty
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

    // RETURNS A NEW LIST CONTAINING THE SAME VALUES AS THIS.LIST (DEEP OR SHALLOW COPY?)
    public SinglyLinkedList copy(){
        return null;
    }

    // SORTS THE LIST PER [TBD] CRITERIA
    public void sort(){

    }

    // OPTIONAL - REVERSES THE ORDER OF THE LIST
    public void reverse(){
        // optional
    }

    // OPTIONAL - RETURNS A SUBSET OF THIS.LIST
    public SinglyLinkedList slice(){
        // optional - but if completed, reference this when doing the copy
        return null;
    }

    // NOT IN DIRECTIONS, BUT I WANTED TO DO IT ANYWAY
    public String toString() {
        String output = "";
        if (head == null) { return "list has not been instantiated"; }
        if (head != null) {
            if (head.getNext() == null){ return "list is empty"; }
            Node currentNode = head.getNext();
            while (currentNode != null) {
                output += "[" + currentNode.getData().toString() + "]";
                currentNode = currentNode.getNext();
            }
        }
        return output;
    }

    private void incrementCounter(){
        listCount++;
    }

    private void decrementCounter(){
        listCount--;
    }

}
