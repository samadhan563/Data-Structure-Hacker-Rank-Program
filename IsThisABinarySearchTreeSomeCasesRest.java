   public boolean checkBST(Node root) 
   {
        boolean flag=true;
        if(root.left!=null)
        {
            if(root.left.data<root.data)
                flag=checkBST(root.left);
            else
                return false;
        }
        if(root.right!=null && flag!=false)
        {
        if(root.right.data>root.data)
            flag=checkBST(root.right);
        else
            return false;
        }
        return flag;
    }
/*Output:
Input (stdin)
2
1 2 3 4 5 6 7
Your Output (stdout)
Yes
Expected Output
Yes
*/
