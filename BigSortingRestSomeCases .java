import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String[] bigSorting(String[] unsorted) 
    {   
        for (int i = 0; i < unsorted.length ; i++)
        {
            for (int j = 0; j < i; j++)
             {
                if(compare(unsorted[i],unsorted[j])<0)
                {
                    String temp=unsorted[i];
                    unsorted[i]=unsorted[j];
                    unsorted[j]=temp;
                }
             }
        }
        return unsorted;
    }
    public static int compare(String first, String second) 
    {
            if (first.length() < second.length())
            {
                return -1;
            } 
            else if (first.length() == second.length())
            {
                return first.compareTo(second);
            } 
            else 
            {
                return 1;
            }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*Output:
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
