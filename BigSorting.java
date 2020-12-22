import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static int com(String s1, String s2)
    {
        if(s1.length()==s2.length())
            {
            return s1.compareTo(s2);
            }
        if(s1.length() > s2.length())
        {
           return (1);    
        }
        else 
            {
            return (-1);
        }
    }    
  
   public static int partition(String arr[],int start,int end)
   {
        int i,piv=start,j=start+1;
        String k;
        for(i=start+1;i<=end;i++)
        {
          if(Solution.com(arr[i],arr[piv])<0)
          {
               k=arr[i];
               arr[i]=arr[j];
               arr[j]=k;
               j+=1;
          }
        }
        k = arr[piv];
        arr[piv] = arr[j-1];
        arr[j-1]=k;
        return (j-1);
   } 
    
   public static void quicksort(String[] arr,int start,int end)
  {
       int k,i;
       if(start<end)
       {    k = Solution.partition(arr,start,end);

        Solution.quicksort(arr,start,k-1);

        Solution.quicksort(arr,k+1,end);

       }
  }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++)
        {
            unsorted[unsorted_i] = in.next();
        }
        quicksort(unsorted,0,n-1);
        for(int i=0; i<n;i++)
        {
            System.out.println(unsorted[i]);    
        }
    }
}

/*Output:
Input (stdin)

6
31415926535897932384626433832795
1
3
10
3
5
Your Output (stdout)

1
3
3
5
10
31415926535897932384626433832795
Expected Output

1
3
3
5
10
31415926535897932384626433832795
*/

