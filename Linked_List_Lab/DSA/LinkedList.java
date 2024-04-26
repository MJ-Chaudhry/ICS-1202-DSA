/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA;

public class LinkedList {

    // reference to the head node.
    private Node head;

    private int listCount;

    // LinkedList constructor
    public LinkedList() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        // head = new Node(null);
        head = null;
        listCount = 0;
    }

    public void addToHead(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        listCount++;
    }

    /** appends the specified element to the end of this list. */
    public void add(Object data) {
        Node Temp = new Node(data);

        // adding a head node
        if (head == null) {
            head = Temp;
        }

        // adding to end of linked list
        else {
            Node Current = head; // traverse from head node
            while (Current.getNext() != null) {
                Current = Current.getNext();
            }

            Current.setNext(Temp);
        }

        // the last node's "next" reference set to our new node

        listCount++;// increment the number of elements variable
    }

    // Question 10 (already completed by the lecturer)
    /** inserts the specified element at the specified position in this list */
    public void add(Object data, int index) {
        Node Temp = new Node(data);
        Node Current = head;

        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index || Current.getNext() != null; i++) {
            Current = Current.getNext();
        }
        // set the new node's next-node reference to this node's next-node
        // reference
        Temp.setNext(Current.getNext());
        // now set this node's next-node reference to the new node
        Current.setNext(Temp);
        listCount++;// increment the number of elements variable
    }

    // returns the element at the specified position in this list.
    public Object get(int index) {
        // Question 15
        // Correct the get method

        // index must be 0 or higher
        if (index < 0 || index >= listCount)
            return null;

        Node Current = head;

        for (int i = 1; i <= index; i++) {
            if (Current.getNext() == null)
                return null;
            // System.out.println("Value of i: " + i);
            System.out.println("At index: " + i + " the data is: " + Current.getData());
            Current = Current.getNext();
        }
        return Current.getData();
    }

    public void traverse() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {
        // Question 14
        // Correct the remove method as it is deleting the wrong node

        // if the index is out of range, exit
        if (index < 0 || index >= size())
            return false;

        // Check if the index points to the head of the node.
        if (index == 0) {
            head = head.getNext();
        } else {
            Node Current = head;
            for (int i = 1; i < index; i++) {
                if (Current.getNext() == null)
                    return false;

                Current = Current.getNext();
            }
            Current.setNext(Current.getNext().getNext());
        }

        listCount--; // decrement the number of elements variable
        return true;
    }

    // returns the number of elements in this list.
    public int size() {
        return listCount;
    }

    public String toString() {
        Node Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

    private class Node {
        // reference to the next node in the chain,
        // or null if there isn't one.
        public Node next;
        // data carried by this node.
        // could be of any type you need.
        public Object data;

        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to
        // specify the node to point to.
        // public Node(Object dataValue, Node nextValue)
        // {
        // next = nextValue;
        // data = dataValue;
        // }

        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }

        // public void setData(Object dataValue)
        // {
        // data = dataValue;
        // }

        /** returns reference to next node */
        public Node getNext() {
            return next;

        }

        /** set node's next reference */
        public void setNext(Node nextValue) {
            next = nextValue;
            // System.out.println(" Value of next" + next.getData());

        }
    }
}
