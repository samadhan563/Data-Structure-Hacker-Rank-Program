import java.util.Scanner;

public class DijkstraAlgo 
{
    
    static int v;
    static int e;
    static int adjMat[][];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        int startVertex;
        for (int i = 0; i < T; i++) 
        {
            v = sc.nextInt();
            e = sc.nextInt();
            adjMat = new int[v+1][v+1];
            for (int j = 0; j <e; j++)
            {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int w = sc.nextInt();
                adjMat[v1][v2] =(adjMat[v1][v2] == 0 || adjMat[v1][v2]>w)?w:adjMat[v1][v2];
                adjMat[v2][v1] = adjMat[v1][v2];
            }
            startVertex = sc.nextInt();
            Algo(startVertex);
        }
    }  
    public static void Algo(int startNode)
    {
        int dist[] = new int[v+1];
        boolean[] mstSet  = new boolean[v+1];
        
        for (int i = 0; i < dist.length; i++)
        {
            dist[i] = (int) Double.POSITIVE_INFINITY;
        }
        dist[startNode] = 0;        
        for (int i = 0; i < v; i++)
        {   
            int u = min(dist, mstSet);
            mstSet[u] = true;
            for (int j = 0; j < v+1; j++) 
            {
                if(adjMat[u][j]>0 && !mstSet[j] && dist[u]+adjMat[u][j]<dist[j])
                {
                    dist[j] = dist[u]+adjMat[u][j];
                }
            }
        }
        //print result
        for (int i = 1; i < v+1; i++) 
        {
            if(i==startNode) continue;
            if(dist[i] == (int)Double.POSITIVE_INFINITY)
            {
                System.out.print(-1+" ");
            }
          else
            {
                System.out.print(dist[i]+" ");
            }
        }
        System.out.println();
        
    }
    
    public static int min(int[]dist, boolean[]mstSet)
    {
        int min = (int)Double.POSITIVE_INFINITY, min_index = 0;
        for (int i = 0; i < v+1; i++) 
        {
            if(!mstSet[i] && dist[i]<min)
            {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
/*Output:
Input (stdin)

1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
Your Output (stdout)

24 3 15 
Expected Output

24 3 15
*/
