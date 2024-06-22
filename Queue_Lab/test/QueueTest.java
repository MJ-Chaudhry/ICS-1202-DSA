package test;

import DSA.*;

public class QueueTest {
    public static void main(String[] args) {
        // Question7: Create a queue with a size of 10.
        QueueX queue = new QueueX(10);

        // Question 8: Print out the queue front and rear indexes.
        System.out.printf("Front: %d\n", queue.front);
        System.out.printf("Rear: %d\n", queue.rear);

        // Question 9: Insert 10 elements into the queue.
        try {
            for (long j = 0; j < 10; j++) {
                queue.insert(j);
            }
        } catch (Exception e) {
            // Ignore exception for now...
        }

        // Question 10: Print out the contents of the queue and identify the front and
        // rear elements
        int i = queue.front;
        do {
            System.out.printf("%d, ", queue.queArray[i]);
            i++;
            i %= queue.queArray.length;
        } while (i % queue.queArray.length != (queue.rear + 1) % queue.queArray.length);
        System.out.println("");
        System.out.printf("Front element: %d\n", queue.queArray[queue.front]);
        System.out.printf("Rear element: %d\n", queue.queArray[queue.rear]);

        // Question 11: Print out the indexes of the front and rear.
        System.out.printf("Front index: %d\n", queue.front);
        System.out.printf("Rear index: %d\n", queue.rear);

        // Question 12: Dequeue 3 elements.
        try {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Dequeued %d\n", queue.remove());
            }
        } catch (Exception e) {
            // Ignore exception for now...
        }
        
        // Question 13: Enqueue 2 elements.
        try {
            queue.insert(10);
            System.out.println("Enqueued 10");
            queue.insert(11);
            System.out.println("Enqueued 11");
        } catch (Exception e) {
            // Ignore exception for now...
        }

        // Question 14: Dequeue 2 elements.
        try {
            System.out.printf("Dequeued %d\n", queue.remove());
            System.out.printf("Dequeued %d\n", queue.remove());
        } catch (Exception e) {
            // Ignore exception for now...
        }

        // Question 15: Print out the contents of the queue.
        System.out.println("Outputing queue");
        i = queue.front;
        do {
            System.out.printf("%d, ", queue.queArray[i]);
            i++;
            i %= queue.queArray.length;
        } while (i % queue.queArray.length != (queue.rear + 1) % queue.queArray.length);
        System.out.println("");

        // Question 16: Print out the indexes of the front and rear.
        System.out.printf("Front index: %d\n", queue.front);
        System.out.printf("Rear index: %d\n", queue.rear);

        // Question 17: Enqueue 6 elements and handle any errors.
        try {
            for (int j = 0; j < 6; j++) {
                queue.insert(j+12);
            }
        } catch (Exception e) {
            System.err.println("Queue is full!");
        }

        // Question 18: Dequeue 11 elements and handle any errors.
        try {
            for (int j = 0; j < 11; j++) {
                System.out.printf("Dequeued %d\n", queue.remove());
            }
        } catch (Exception e) {
            System.err.println("Queue is empty!");
        }
    }
}
