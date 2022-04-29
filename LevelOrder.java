import java.util.*;
import java.io.*;

class LevelOrder {
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
    /*
     * 
     * class Node
     * int data;
     * Node left;
     * Node right;
     */
    public static void levelOrder(Node root) {
        int height = height(root);
        for( int level =0; level <= height; level++){
            printLevel(root, level);
        }
        
    }
    

    public static void printLevel(Node node, int level){
        if(node == null){
            return;
        }
        
        if(level == 0){
            System.out.print(node.data);
            System.out.print(" ");
        }else{
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
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
        levelOrder(root);
    }
}