import java.util.*;
import java.io.*;

class Node 
{
    Node left;
    Node right;
    int data;
    
    Node(int data) 
    {
        this.data = data;
        left = null;
        right = null;
    }
}
class SLevelOrderTraversal
{
  static LinkedList<Node> list = new LinkedList<Node>();
	public static void levelOrder(Node root) 
   {      
        if( root != null )
        {
            list.add(root);
        }
         while( !list.isEmpty() )
         {
            Node tree = list.remove();
            System.out.print(tree.data + " ");

            if( tree.left != null )
            {
                list.add( tree.left );
             }
            if( tree.right != null )
            {
                list.add( tree.right );
            }
       }
}

public static Node insert(Node root, int data)
{
        if(root == null) 
        {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) 
            {
                cur = insert(root.left, data);
                root.left = cur;
            } 
            else 
            {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) 
        {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
/*Output::
Input (stdin)

6
1 2 5 3 6 4
Your Output (stdout)

1 2 5 3 6 4 
Expected Output

1 2 5 3 6 4
*/
