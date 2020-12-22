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
