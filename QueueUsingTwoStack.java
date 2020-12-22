import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
      
      Stack s1=new Stack();
      Stack s2=new Stack();
        
       int n=sc.nextInt(); 
        for(int i=0;i<n;i++)
        {
            switch(sc.nextInt())
            {
                case 1:
                     s1.push(sc.nextInt());
                    break;
                case 2:
                     s2.pop();
                    break;
                case 3:
                    System.out.println(s2.peek());
                      break;
            }
            if(s2.isEmpty())
            {
                while(!s1.isEmpty())
                {                        
                    s2.push(s1.pop());
                }      
            }
            
        }
    }
}/*
class Stack
{
    int[] stack=new int [20];
    int top;
    
    Stack()
    {
        top=-1;
    }
    
     boolean isEmpty()
    {
        return top==-1;
    }
    
    boolean push(int data)
    {
        stack[++top]=data;
        return true;
    }
    
    int pop()
    {
       if(isEmpty())
         return -999;
        return stack[top--];      
    }
    int peek()
    {
       if(isEmpty())
         return -999;
        return stack[top];      
    }
}*/

/* OutPut:
Input (stdin)

10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
Your Output (stdout)

14
14
Expected Output

14
14
*/

