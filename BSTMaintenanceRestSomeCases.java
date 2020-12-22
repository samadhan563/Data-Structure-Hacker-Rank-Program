import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static class Node {
        int val;
        Node left;
        Node right;
        long distChildren;
        long distPairs;
        int count;
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.count = 1;
            return node;
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        int cl = root.left != null ? root.left.count : 0;
        int cr = root.right != null ? root.right.count : 0;
        root.count = 1 + cl + cr;
        root.distChildren = 0;
        root.distPairs = 0;
        if (root.left != null) {
            root.distChildren += cl + root.left.distChildren;
            root.distPairs += root.left.distPairs 
                    + (1 + cr) * (cl + root.left.distChildren);
        }
        if (root.right != null) {
            root.distChildren += cr + root.right.distChildren;
            root.distPairs += root.right.distPairs 
                    + (1 + cl) * (cr + root.right.distChildren);
        }
        return root;
    }

    // Complete the solve function below.
    static long[] solve(int[] arr) {
        long[] ans = new long[arr.length];
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
            ans[i] = root.distPairs;
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long[] result = solve(arr);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


