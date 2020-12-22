import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RecursiveDigitSum
{

    // Complete the superDigit function below.
     static long getNum(String n)
     {
        long num = 0;
        for(char c : n.toCharArray())
            num += Character.digit(c, 10);
        return num;
    }
    static int superDigit(String n)
    {
        System.out.println(n);
        if(n.length() <= 1)
            return Integer.parseInt(n);
        return superDigit(String.valueOf(getNum(n))); 
    }
    static int superDigit(String n, int k) 
    {
        return superDigit(String.valueOf(k * getNum(n)));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
