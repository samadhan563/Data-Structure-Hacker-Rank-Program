import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSort1 {

    
    static void insertionSort1(int n, int[] arr) 
    {
        int val = arr[n -1];
        for (int i = n - 1; i > 0; i--)
        {
           if (val < arr[i -1])
            {
                arr[i] = arr[i - 1];
                System.out.println(((Arrays.toString(arr)).replace("[","")).replaceAll(",","").replace("]",""));
           } 
            else
            {
               arr[i] = val;
                System.out.println(((Arrays.toString(arr)).replace("[","")).replaceAll(",","").replace("]",""));
               break;
            }

                if (i == 1) 
                {
                  arr[0] = val;
                    System.out.println(((Arrays.toString(arr)).replace("[","")).replaceAll(",","").replace("]",""));
                }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
