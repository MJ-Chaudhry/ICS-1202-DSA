// stack.java
// demonstrates stacks
////////////////////////////////////////////////////////////////

package DSA;

import java.util.EmptyStackException;

public class StackX {
    private int maxSize; // size of stack array
    public long[] stackArray;
    public int top; // top of stack
    // --------------------------------------------------------------

    public StackX(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        top = -1; // no items yet
    }

    // --------------------------------------------------------------
    public void push(long j) throws StackOverflowError // put item on top of stack
    {
        // Question 10: add error detection to push method.
        if (isFull()) {
            throw new StackOverflowError("Stack is full!");
        }
        stackArray[++top] = j; // increment top, insert item
    }

    // --------------------------------------------------------------
    public long pop() throws EmptyStackException // take item from top of stack
    {
        // Question 15: add error detction to pop method
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--]; // access item, decrement top
    }

    // --------------------------------------------------------------
    public long peek() // peek at top of stack
    {
        return stackArray[top];
    }

    // --------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }

    // --------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1);
    }

    // PART 2: Create a function to check if a string is a palindrome.
    public static boolean isPalindrome(String s) {
        // Create a new stack object with half the size of the string
        int half = s.length()/2;

        StackX stack = new StackX(half+1);

        for (int i = half; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < half; i++) {
            if (s.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
    // --------------------------------------------------------------
} // end class StackX