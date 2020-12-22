import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DownToZeroII
{
    public static int[] findPrimes() 
    {
        int MAX = 1000001;
        int[] primes = new int[MAX];
        int prime = 2;
        while(prime * prime <= MAX - 1) 
        {
            for(int i=2;prime*i <= MAX - 1;i++) 
            {
                primes[i * prime] = 1;    
            }
            
            prime = prime + 1;
            while(primes[prime] != 0)
            {
                prime++;
            }
        }
        return primes;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] primes = findPrimes();
        int[] down_to_zero = new int[1000001];
        down_to_zero[1] = 1;
        for(int i=2;i<down_to_zero.length;i++) 
        {
            if(primes[i] == 0) 
            {
                down_to_zero[i] = down_to_zero[i-1] + 1;
            }
            else
            {
                int min = Integer.MAX_VALUE;
                for(int j=2;j*j<=i;j++)
                {
                    if(i % j == 0)
                    {
                        min = Math.min(min, down_to_zero[i/j] + 1);
                    }
                }
                min = Math.min(min, down_to_zero[i-1] + 1);
                down_to_zero[i] = min;
            }
        }
        
        
        int n = in.nextInt();
        for(int i=0;i<n;i++) 
        {
            int data = in.nextInt();
            System.out.println(down_to_zero[data]);
        }
        
    }
}
/*Output::
Input (stdin)

2
3
4
Your Output (stdout)

3
3
Expected Output

3
3
*/
