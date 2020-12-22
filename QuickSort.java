import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QuickSort
{

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) 
    {
        int pivot=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            if(pivot>arr[i]){
                for(int j=i;j>0;j--)
                {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
               }
       }
} 
return arr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
/*Output:
Score: 0

Input (stdin)

5
4 5 3 7 2
Your Output (stdout)

2 3 4 5 7
Expected Output

3 2 4 5 7
Compiler Message

Success
*/
