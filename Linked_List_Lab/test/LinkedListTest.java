package test;

import DSA.*;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Question 6
        // Adding 5 elements to the list.
        list.add("Value");
        list.add(5);
        list.add(true);
        list.add('x');
        list.add(4.90);

        // Question 7
        // Add a new node to the head of the list
        list.addToHead("Head");

        // Question 8
        // Use the add() method to add 5 more items
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        // Question 9
        // Print out the contents of the linked list using the traverse() method
        System.out.println("Traversing list:");
        list.traverse();

        // Question 11
        // Delete the first and second item
        list.remove(0);  // delete the first (0th) element
        list.remove(0);  // delete the second element (0th index since the firts was removed)

        // Question 12
        // Add an item to index 5 of the list
        list.add("some item", 5);

        // Question 13
        // Print out the contents of the list.
        System.out.println("Traversing list:");
        list.traverse();

        // Question 15
        // Test get method.
        System.out.println(list.get(2));
        
    }
}
