import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class MergeList
{

    // Complete the solve function below.
    static int solve(int n, int m)
    {

     BigInteger val = new BigInteger("1");
        int coun=1;
        for(int u=n+m; u>=m+1; u--)
        {
            val=val.multiply(new BigInteger(Integer.toString(u)));
            val=val.divide(new BigInteger(Integer.toString(coun)));
            coun++;
        }
        val=val.mod(new BigInteger("1000000007"));
        int a=val.intValue();
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = solve(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

/*Output:
1
2 2
Your Output (stdout)

6
Expected Output

6
*/
