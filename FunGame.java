import java.io.*;
import java.util.*;

public class FunGame 
{

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0)
            {
            int n=s.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=s.nextInt();
            for(int i=0;i<n;i++)
                b[i]=s.nextInt();
            boolean v[]=new boolean[n];
            int c=0,d=0;
            for(int m=1;m<=n;m++)
            {
                int max=0,pos=0;
                for(int i=0;i<n;i++)
                    {
                      if(v[i])
                          continue;
                      int x=a[i]+b[i];
                      if(x>max)
                       {
                          max=x;
                          pos=i;
                       }
                    }
                v[pos]=true;
                if(m%2==1)
                {
                    c+=a[pos];
                }
                else d+=b[pos];
            }
            if(c>d)
                System.out.println("First");
            else if(c==d)
                System.out.println("Tie");
            else
                System.out.println("Second");
        }
    }
}
/*OutPut:
Input (stdin)

3
3
1 3 4
5 3 1
2
1 1
1 1
2
2 2
3 3
Your Output (stdout)

First
Tie
Second
Expected Output

First
Tie
Second
*/
