import java.util.*;
import java.io.*;

class Solution {

    /*
     * class Node
     * int data;
     * Node left;
     * Node right;
     */
    public static int height(Node root) {
        // Write your code here.
        int height = -1;
        if (root == null) {
            return height;
        }
        int lHeight = 1 + height(root.left);
        int rHeight = 1 + height(root.right);
        if (lHeight > rHeight) {
            return lHeight;
        }
        return rHeight;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}