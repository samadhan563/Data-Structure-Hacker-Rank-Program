boolean checkBST(Node root) 
   {
        int min = Integer.MIN_VALUE;
        if(root == null) return true;
        Stack<Node> st = new Stack<Node>();
        Node tmp = root;
        while(!st.isEmpty() || tmp!=null) 
        {
            if(tmp!=null) 
            {
                st.push(tmp);
                tmp = tmp.left;
            }
            else 
            {
                tmp = st.pop();
                if(tmp.data<=min)
                {
                    return false;
                }
                min = tmp.data;
                tmp = tmp.right;
            }
        }
        return true;
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
