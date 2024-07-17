package test;

import DSA.*;

public class Test {
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        // inserting data to the tree
        tree.insert(48);
        tree.insert(31);
        tree.insert(78);
        tree.insert(20);
        tree.insert(34);
        tree.insert(54);
        tree.insert(92);
        tree.insert(50);

        tree.preorder(); // Root -> Left -> Right
        tree.postorder(); // Left-> Right -> Root
        tree.inorder(); // Left -> Root -> Right

        System.out.println("Searching for 50...");
        if (tree.search(50)) {
            System.out.println("50 Found!");
        } else {
            System.out.println("50 Not found!");
        }
        System.out.println("Max number:");
        tree.max();
        System.out.println("Min number:");
        tree.min();

        tree.preorderIterative();
        tree.postorderIterative();
        tree.inorderIterative();

        tree.delete(48);
        tree.inorder();
    }
}
