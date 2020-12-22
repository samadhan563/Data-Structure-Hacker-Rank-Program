import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class TopViewOfTree {
    static void topView(Node root)
    {
        print_left(root.left);
        System.out.print(root.data + " ");
        print_right(root.right);
    }

    static void print_left(Node root)
    {
        if(root == null)
            return;
        print_left(root.left);
        System.out.print(root.data + " ");
    }

    static void print_right(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        print_right(root.right);
    }
    	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
/**
OUTPUT::
Input (stdin)

6
1 2 5 3 6 4
Your Output (stdout)

1 2 5 6 
Expected Output

1 2 5 6
*/
    
    
