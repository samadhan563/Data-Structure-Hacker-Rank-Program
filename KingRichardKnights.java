import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KingRichardKnights
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        long[] smallest = new long[q+1];
        long[] a = new long[q+1];
        long[] b = new long[q+1];
        long[] d = new long[q+1];
        int l=0,h=q,m,w;
        long num,x,y;
        StringBuffer strBuffer = new StringBuffer();
        String[] splitArr;
        smallest[0] = 0;
        a[0] = 1;
        b[0] = 1;
        d[0] = n-1;
//        scan.useDelimiter(System.lineSeparator());
        for(int i=1;i<=q;i++) {
//            splitArr = scan.next().split(" ");
//            a[i] = Integer.parseInt(splitArr[0]);
//            b[i] = Integer.parseInt(splitArr[1]);
//            d[i] = Integer.parseInt(splitArr[2]);
            a[i] = scan.nextLong();
            b[i] = scan.nextLong();
            d[i] = scan.nextLong();
            if(i%4==1)
                smallest[i] = smallest[i-1] + (a[i]-a[i-1])*n + b[i] - b[i-1];
            else if(i%4==2)
                smallest[i] = smallest[i-1] + ((b[i-1]+d[i-1])-(b[i]+d[i]))*n + (a[i]-a[i-1]);
            else if(i%4==3)
                smallest[i] = smallest[i-1] + ((a[i-1]+d[i-1])-(a[i]+d[i]))*n + (b[i-1]+d[i-1])-(b[i]+d[i]);
            else if(i%4==0)
                smallest[i] = smallest[i-1] + (b[i]-b[i-1])*n + (a[i-1]+d[i-1])-(a[i]+d[i]);
        }
        w = scan.nextInt();
        for(int j=0;j<w;j++) {
            num = scan.nextLong();
            l=0;h=q;
            while(l!=h) {
                m = (l+h+1)/2;
                if(num>=smallest[m]&&num<(smallest[m]+(d[m]+1)*n)&&(num%n)>=(smallest[m]%n)&&(num%n)<=(smallest[m]%n+d[m]))
                    l = m;
                else
                    h = m-1;
            }
            x = (num-smallest[l])/n;
            y = (num-smallest[l])%n;
            if(l%4==0)
                strBuffer.append((a[l]+x)+" "+(b[l]+y)+"\n");
            else if(l%4==1)
                strBuffer.append((a[l]+y)+" "+(b[l]-x+d[l])+"\n");
            else if(l%4==2)
                strBuffer.append((a[l]-x+d[l])+" "+(b[l]-y+d[l])+"\n");
            else if(l%4==3)
                strBuffer.append((a[l]-y+d[l])+" "+(b[l]+x)+"\n");
        }
        scan.close();
        System.out.println(strBuffer.toString());
    }
}
/*OUTPUT::
Input (stdin)

7
4
1 2 4
2 3 3
3 4 1
3 4 0
7
0
6
9
11
24
25
48
Your Output (stdout)

1 1
1 7
4 6
3 4
2 5
2 4
7 7

Expected Output

1 1
1 7
4 6
3 4
2 5
2 4
7 7
*/
