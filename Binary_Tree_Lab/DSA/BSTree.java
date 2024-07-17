/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA;

import java.util.Stack;

/* Class BST */
public class BSTree {
    public BSTNode root;

    /* Constructor */
    public BSTree() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(int data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    public BSTNode insert(BSTNode node, int data) {
        if (node == null) // Base case case
        {
            node = new BSTNode(data);
        } else {
            System.out.println(node.data);
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    /* Functions to delete data */
    /// `k` is the data to delete.
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    public BSTNode delete(BSTNode root, int k) {
        BSTNode smallestNode, rightNodeAfterRoot, n;
        if (root.getData() == k) {  // You're at the node you want to delete
            BSTNode leftNode, rightNode;
            leftNode = root.getLeft();
            rightNode = root.getRight();
            if (leftNode == null && rightNode == null)  // First case - leaf node
                return null;
            else if (leftNode == null) {  // Second case - one child
                smallestNode = rightNode;
                return smallestNode;
            } else if (rightNode == null) { // Second case - one child
                smallestNode = leftNode;
                return smallestNode;
            } else {  // Third case - two children
                rightNodeAfterRoot = rightNode;  // Get the right node from the node you want to delete
                smallestNode = rightNode;  // Smallest node after the right node

                // Get the smallest node from the current node
                while (smallestNode.getLeft() != null)
                    smallestNode = smallestNode.getLeft();
                    
                smallestNode.setLeft(leftNode);
                return rightNodeAfterRoot;
            }
        }
        if (k < root.getData()) {  
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    public boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public int max() throws NullPointerException {
        BSTNode r = root;
        if (r == null) {
            throw new NullPointerException("BST is empty!");
        }
        while (r.getRight() != null) {
            r = r.getRight();
        }
        System.out.println(r.getData());
        return r.getData();
    }

    public int min() throws NullPointerException {
        BSTNode r = root;
        if (r == null) {
            throw new NullPointerException("BST is empty!");
        }
        while (r.getLeft() != null) {
            r = r.getLeft();
        }
        System.out.println(r.getData());
        return r.getData();
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
        System.out.printf("\n");
    }

    public void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.printf("%d ", r.getData());
            inorder(r.getRight());
        }
    }

    public void inorderIterative() {
        if (root == null) {
            return;
        }

        Stack<BSTNode> stack = new Stack<BSTNode>();

        BSTNode currentNode = root;
        while (currentNode != null || stack.size() > 0) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            currentNode = stack.pop();
            System.out.printf("%d ", currentNode.getData());
            currentNode = currentNode.getRight();
        }
        System.out.printf("\n");
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
        System.out.printf("\n");
    }

    public void preorder(BSTNode r) {
        if (r != null) {
            System.out.printf("%d ", r.getData());
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void preorderIterative() { // root-left-right
        if (root == null) {
            return;
        }

        Stack<BSTNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            BSTNode current = stack.pop();
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            System.out.printf("%d ", current.getData());
        }

        System.out.printf("\n");
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
        System.out.printf("\n");
    }

    public void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.printf("%d ", r.getData());
        }
    }

    public void postorderIterative() {
        if (root == null) {
            return;
        }

        Stack<BSTNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            BSTNode current = stack1.pop();
            if (current.getLeft() != null) {
                stack1.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack1.push(current.getRight());
            }
            stack2.push(current);
        }

        while (!stack2.isEmpty()) {
            System.out.printf("%d ", stack2.pop().getData());
        }
        System.out.printf("\n");
    }
}
