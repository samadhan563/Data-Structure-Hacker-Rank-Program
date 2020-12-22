import java.io.*;
public class MissingNumbers
{
    public static void main(String args[]) throws IOException
    {
        int n,m,a[],b[],hash[],min_b;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        a=new int[n];
        String st=br.readLine();
        String num[]=st.split(" ");
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(num[i]);
        }
        m=Integer.parseInt(br.readLine());
        b=new int[m];
        st=br.readLine();
        num=st.split(" ");
        for(int i=0;i<m;i++)
        {
            b[i]=Integer.parseInt(num[i]);
        }
        min_b=find_min(b);
        hash=new int[100];
        for(int i=0;i<b.length;i++)
        {
            hash[b[i]-min_b]++;
        }
        for(int i=0;i<a.length;i++)
        {
            if((a[i]-min_b)>=0)
            {
                hash[a[i]-min_b]--;
            }
        }
        for(int i=0;i<100;i++)
        {
            if(hash[i]>0)
            {
                System.out.print((i+min_b)+" ");
            }
        }
        
    }
    static int find_min(int b[])
    {
        int min=b[0];
        for(int i=1;i<b.length;i++)
        {
            if(min>b[i])
            {
                min=b[i];
            }
        }
        return min;
    }
}
/* OUTPUT:
Input (stdin)

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Your Output (stdout)

204 205 206 
Expected Output

204 205 206
*/
