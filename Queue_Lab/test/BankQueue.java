/**
 * Part 2 of the lab: make a basic bank queueing system that allows people
 * to be queued, servered, and dequeued.
 */

package test;

import java.util.Scanner;

import DSA.StringQueue;

public class BankQueue {
    static StringQueue queue = new StringQueue(10); // Create a new queue that can hold 10 people.
    static Scanner input = new Scanner(System.in);
    static int id = 0;

    /** Used to print out the option message pane. */
    public static void printMessage() {
        System.out.println("\nWelcome to the bank! What would you like to do?");
        System.out.println("  1. Add someone to the queue,");
        System.out.println("  2. Serve the first person in the queue,");
        System.out.println("  3. Show queue,");
        System.out.println("  4. Exit\n");
    }

    /** Used to add a person to the queue. */
    public static void addPerson() {
        System.out.printf("Input person's name: ");
        String name = input.nextLine();
        id++;
        try {
            queue.insert(String.valueOf(id));
        } catch (Exception e) {
            System.out.printf("Could not add %s to queue as it is full!\n", name);
            return;
        }
        System.out.printf("%s has been added to the queue with the id: %d\n", name, id);
    }

    /**
     * Used to serve the person at the front of the queue and output the next person
     * to be served.
     */
    public static void servePerson() {
        try {
            String serverId = queue.remove();
            System.out.printf("Serving %s.\n", serverId);
            if (!queue.isEmpty()) {
                System.out.printf("%s is next to be served!\n", queue.peekFront());
            }
        } catch (Exception e) {
            System.out.println("No one left in the queue!");
            return;
        }
    }

    /** Used to show all the ID's in the queue. */
    public static void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        int i = queue.front;
        do {
            System.out.printf("%s,\n", queue.queArray[i]);
            i++;
            i %= queue.queArray.length;
        } while (i % queue.queArray.length != (queue.rear + 1) % queue.queArray.length);
    }

    public static void main(String[] args) {
        boolean exitProgram = false;

        // Infinite loop to keep system running until the exit option is selected.
        while (!exitProgram) {
            printMessage();

            int option = -1;
            // Input an option and validate the input before proceeding.
            do {
                System.out.printf("Option: ");
                try {
                    option = input.nextInt();
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Invalid option selected! Please choose either 1, 2, 3, 4.");
                    continue;
                }
                if (option < 1 || option > 4) {
                    System.out.println("Invalid option selected! Please choose either 1, 2, 3, 4.");
                }
            } while (option < 1 || option > 4);
            input.nextLine();

            // Switch through the available options.
            switch (option) {
                case 1:
                    addPerson();
                    break;

                case 2:
                    servePerson();
                    break;

                case 3:
                    showQueue();
                    break;

                case 4:
                    exitProgram = true;
                    System.out.println("Exiting system...");
                    break;

                default:
                    break;
            }
        }
    }
}
