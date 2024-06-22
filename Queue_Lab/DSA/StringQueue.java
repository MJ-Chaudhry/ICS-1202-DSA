package DSA;

/**
 * Modified version of QueueX to use strings instead of longs.
 */
public class StringQueue {
    private int maxSize;
    public String[] queArray;
    public int front, rear, nItems;

    public StringQueue(int s) {
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String j) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is full!");
        }
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public String remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        String temp = queArray[front++];

        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public String peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}
