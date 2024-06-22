package DSA;

public class QueueX {
    private int maxSize;
    public long[] queArray;             // reference to an array of longs.
    public int front, rear, nItems;

    public QueueX(int s) {               // constructor. Note: size and structure of queue determined here. User does not see (or care) how queue is implemented.
        maxSize = s;
        queArray = new long[maxSize];   // Note: Constructor is passed desired queue size from client.
        front = 0;                      // Note: See instance and local variables??
        rear = -1;                      // Note: Here's the queue; implemented as an array; front and rear
        nItems = 0;                     // and number of Items setup and initialized.
    } // end Constructor

    // Question 17: Modify insert function to throw an error if the queue is full.
    public void insert(long j) throws Exception {        // put item at rear of queue
        if (isFull()) {                 // Check if the queue is full.
            throw new Exception("Queue is full!");
        }
        if (rear == maxSize - 1)        // deals with wraparound //Note: insert() FIRST checks to see if there's room for an insert.
            rear = -1;                  // if rear is at maxSize-1, then we need to wrap to 0.
        queArray[++rear] = j;           // increment rear and insert So rear is set to -1 and it is set to 0 in this statement.
        nItems++;                       // one more item. Note: number of items in queue is incremented.
        
        // Question 5: Print the position of the new item in the queue
        System.out.println(rear);
    } // end insert()

    // Question 18: Modify remove function to throw an error if the queue is empty
    public long remove() throws Exception {              // take item from front of queue
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        long temp = queArray[front++];  // get value and increments front //Note: creates a temp variable, temp, and moves
        if (front == maxSize)           // deal with wraparound the queue item into it and increments front pointer.
            front = 0;                  // it then checks to see if the new value causes wrap.
        nItems--;                       // one less item Lastly, it decrements the queue size; returns temp.
        return temp;
    } // end remove()

    public long peekFront() { // peek at front of queue
        return queArray[front];
    } // end peek()

    public boolean isEmpty() { // true if queue is empty // Do you see a problem with insert() ?
        return (nItems == 0);
    } // end isEmpty()

    public boolean isFull() {
        return (nItems == maxSize); // true if queue is full
    } // end isFull()

    public int size() { // number of items in queue
        return nItems;
    } // end size()
} // end class Queue
