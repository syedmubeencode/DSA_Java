package com.dsa.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree4Oct {
    TreeNode root;

    // Insert a node in the binary tree (level order)
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        
        if (root == null) {
            root = newNode;
            return;
        }

        // Use a queue to insert node in level order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Insert in the left child if it is null
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.add(current.left);
            }

            // Insert in the right child if it is null
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    // In-order Traversal (Left, Root, Right)
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Pre-order Traversal (Root, Left, Right)
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order Traversal (Left, Right, Root)
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Search for a value in the tree
    public boolean search(TreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        // Recursively search in left or right subtree
        return search(node.left, value) || search(node.right, value);
    }

    public static void main(String[] args) {
    	BinaryTree4Oct tree = new BinaryTree4Oct();

        // Inserting nodes into the binary tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);

        System.out.println("In-order Traversal:");
        tree.inOrder(tree.root);  // Output: 40 20 50 10 60 30 70

        System.out.println("\nPre-order Traversal:");
        tree.preOrder(tree.root);  // Output: 10 20 40 50 30 60 70

        System.out.println("\nPost-order Traversal:");
        tree.postOrder(tree.root);  // Output: 40 50 20 60 70 30 10

        // Searching for a value in the binary tree
        System.out.println("\nSearch for 60: " + tree.search(tree.root, 60));  // Output: true
        System.out.println("Search for 100: " + tree.search(tree.root, 100));  // Output: false
    }
}
