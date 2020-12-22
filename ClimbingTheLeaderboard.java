import java.util.Scanner;

public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        /* Save input - discard duplicates in leaderboard */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int lastScore = -1;
        int[] scores = new int[n];
        int index = 0;
        while (n-- > 0) {
            int currScore = scan.nextInt();
            if (currScore != lastScore) {
                scores[index] = currScore;
                index++;
            }
            lastScore = currScore;
        }
        int m = scan.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) {
            alice[i] = scan.nextInt();
        }
        scan.close();

        /* Print ranks */
        int i = index - 1;
        for (int aliceScore : alice) {
            while (i >= 0) {
                if (aliceScore < scores[i]) {
                    System.out.println(i + 2);
                    break;
                }
                i--;
            }
            if (i < 0) {
                System.out.println(1);
            }
        }
    }
}
/*Output:
7
100 100 50 40 40 20 10
4
5 25 50 120
Your Output (stdout)

6
4
2
1
Expected Output

6
4
2
1
*/
