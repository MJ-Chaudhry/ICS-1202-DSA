package test;

import java.util.EmptyStackException;

import StackX.StackX;

/**
 * StackTest
 */
public class StackTest {

    public static void main(String[] args) {
        // PART 1
        // Question 6: create a new stack object with a size of 10 objects
        StackX stack = new StackX(10);

        // Question 7: add 10 items to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        // Question 8: print out the contents of the stack
        System.out.println("Printing items in the stack:");
        for (int i = 0; i <= stack.top; i++) {
            System.out.println(stack.stackArray[i]);
        }

        // Question 9: print out the top of the stack
        System.out.printf("Top of the stack: %d\n", stack.peek());

        // Question 10/11: push an item onto the stack and also add in error detection
        try {
            stack.push(11);
        } catch (StackOverflowError e) {
            System.err.println("Stack overflow error!");
        }

        // Question 12: pop 5 elements from the stack
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }

        // Question 13: print out the contents of the stack
        System.out.println("Printing items in the stack:");
        for (int i = 0; i <= stack.top; i++) {
            System.out.println(stack.stackArray[i]);
        }

        // Question 14: pop 6 items from the stack and check for an error
        for (int i = 0; i < 6; i++) {
            try {
                System.out.println(stack.pop());
            } catch (EmptyStackException e) {
                System.err.println("Stack is empty!");
            }
        }
    }
}