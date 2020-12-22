import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) 
    {
            
        int res = (m + s -1) % n;
        return res == 0 ? n : res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
/*Output:
Input (stdin)

2
5 2 1
5 2 2
Your Output (stdout)

2
3
Expected Output

2
3
*/

static void topView(Node root)
{
    print_left(root.left);
    System.out.print(root.data + " ");
    print_right(root.right);
}

static void print_left(Node root)
{
    if(root == null)
        return;
    print_left(root.left);
    System.out.print(root.data + " ");
}

static void print_right(Node root)
{
    if(root == null)
        return;
    System.out.print(root.data + " ");
    print_right(root.right);
}
