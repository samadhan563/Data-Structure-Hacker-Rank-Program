import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreadthFirstSearchShortestReach {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) 
    {
        int adj[][]=new int[n][n];
        boolean visited[]=new boolean[n];
        for(int i=0;i<m;i++)
        {
            adj[edges[i][0]-1][edges[i][1]-1]=6;
            adj[edges[i][1]-1][edges[i][0]-1]=6;            
        }
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        dis[s-1]=0;
        for(int i=0;i<n-1;i++)
        {
            int u=-1,min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(min>dis[j] && !visited[j])
                {
                    min=dis[j];
                    u=j;
                }
            }
            if(u!=-1)
                visited[u]=true;
            else
                break;
            for(int j=0;j<n;j++)
            {
                if(!visited[j] && adj[u][j]!=0 && (dis[u]+adj[u][j])<dis[j])
                    dis[j]=dis[u]+adj[u][j];
            }
        }
        int ret[]=new int[n-1];
        int index=0;
        for(int i=0;i<n;i++)
        {
            if(i!=s-1)
            {
                if(dis[i]==Integer.MAX_VALUE)
                    ret[index++]=-1;
                else
                    ret[index++]=dis[i];
            }
        }
        return ret;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) 
        {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++)
            {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++)
                {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) 
            {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1)
                {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
