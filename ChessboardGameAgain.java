import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ChessboardGameAgain {

    private static final int[][] dd = new int[][]{{-2, 1}, {-2, -1}, {1, -2}, {-1, -2}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Integer[][] mem = new Integer[15][15];
        while (t-- > 0) {
            int m = in.nextInt();
            int s = 0;
            while (m-- > 0) {
                s ^= f(in.nextInt() - 1, in.nextInt() - 1, mem);
            }
            System.out.println(s > 0 ? "First" : "Second");
        }
    }

    private static int f(int i, int j, Integer[][] mem) {
        if (mem[i][j] != null) return mem[i][j];

        List<Integer> list = new ArrayList<>();
        for (int[] d : dd) {
            int i2 = i + d[0];
            int j2 = j + d[1];
            if (i2 >= 0 && j2 >= 0 && i2 < 15 && j2 < 15) {
                list.add(f(i2, j2, mem));
            }
        }
        return mem[i][j] = mex(list);
    }

    private static int mex(List<Integer> list) {
        Collections.sort(list);
        int mex = 0;
        for (int x : list) {
            if (mex == x) {
                mex++;
            } else if (mex < x) {
                break;
            }
        }
        return mex;
    }

}
