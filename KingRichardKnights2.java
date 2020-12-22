import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KingRichardKnights2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        long[] a = new long[s+1];
        long[] b = new long[s+1];
        long[] d = new long[s+1];
        long[] tln = new long[s+1];
        a[0] = 1;
        b[0] = 1;
        d[0] = n-1;
        for (int i = 1; i <= s; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            d[i] = sc.nextInt();
            if (i%4==1) {
                tln[i] = tln[i-1]+(a[i]-a[i-1])*n+(b[i]-b[i-1]);
            } else if (i%4==2) {
                tln[i] = tln[i-1]+((b[i-1]+d[i-1])-(b[i]+d[i]))*n+(a[i]-a[i-1]);
            } else if (i%4==3) {
                tln[i] = tln[i-1]+((a[i-1]+d[i-1])-(a[i]+d[i]))*n+((b[i-1]+d[i-1])-(b[i]+d[i]));
            } else if (i%4==0) {
                tln[i] = tln[i-1]+(b[i]-b[i-1])*n+((a[i-1]+d[i-1])-(a[i]+d[i]));
            }
        }
        
        int l = sc.nextInt();
        long[] w = new long[l];
        for (int i = 0; i < l; i++) {
            w[i] = sc.nextLong();
            int low = 0;
            int high = s;
            while (low != high) {
                int mid = (low+high+1)/2;
                if (w[i] >= tln[mid] && w[i] < tln[mid]+(d[mid]+1)*n && w[i]%n >= tln[mid]%n && w[i]%n <= (tln[mid]%n)+d[mid])
                    low = mid;
                else
                    high = mid-1;
            }
            long off1 = (w[i]-tln[low])/n;
            long off2 = (w[i]-tln[low])%n;
            if (low%4==0) {
                System.out.println((a[low]+off1)+" "+(b[low]+off2));
            } else if (low%4==1) {
                System.out.println((a[low]+off2)+" "+(b[low]+d[low]-off1));
            } else if (low%4==2) {
                System.out.println((a[low]+d[low]-off1)+" "+(b[low]+d[low]-off2));
            } else if (low%4==3) {
                System.out.println((a[low]+d[low]-off2)+" "+(b[low]+off1));
            }
        }
    }
}
