package process;
import java.io.*;
import java.util.*;
class pair implements Comparable
{
    int f;
    long s;
    pair(int fi,long se)
    {
        f=fi;
        s=se;
    }
    public int compareTo(Object o)
    {
        pair pr=(pair)o;
        if(s>pr.s)
            return 1;
        if(s==pr.s)
        {
            if(f>pr.f)
                return 1;
            else
                return -1;
        }
        else
            return -1;
    }
}
public class Findresult 
{
	static long inf=(long)100000000*100000000;
    static long Euclideandist(long x1,long y1,long x2,long y2)
    {
        long dist=(long)Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
        return dist;
    }
	public static void main(String args[])throws Exception
	{
	}
	public static long gi(int src,int dest)
	{
		try
		{
			BufferedReader in=new BufferedReader (new FileReader("C:\\Users\\hp\\Desktop\\Problem\\problem setting\input_text.txt"));
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			ArrayList<pair>g[]=new ArrayList[n+1];
			int x[]=new int[n+1];
			int y[]=new int[n+1];
			for(int i=1;i<=n;i++)
				g[i]=new ArrayList<>();
			for(int i=1;i<=m;i++)
			{
				st=new StringTokenizer(in.readLine());
				st.nextToken();
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				g[u].add(new pair(v,w));
				g[v].add(new pair(u,w));
				//if(i==1)
				//	System.out.println(u+" "+v+" "+w);
			}
			in=new BufferedReader (new FileReader("/Users/amol/Desktop/Floridagraphcoord.txt"));
			for(int i=1;i<=n;i++)
			{
				st=new StringTokenizer(in.readLine());
				st.nextToken();
				st.nextToken();
				x[i]=Integer.parseInt(st.nextToken());
				y[i]=Integer.parseInt(st.nextToken());
				//if(i==1)
				//	System.out.println(x[i]+" "+y[i]);
			}
			long dist[]=new long[n+1];
            int vis[]=new int[n+1];
            PriorityQueue<pair>pq=new PriorityQueue<>();
            for(int i=1;i<=n;i++)
            {
                if (i == src)
                    dist[i] = 0;
                else
                    dist[i] = inf;
                vis[i] = 0;
                pq.add(new pair(i, dist[i]));
            }
            while(!pq.isEmpty())
            {
                pair p=pq.remove();
                int u=p.f;
                if(u==dest)
                    break;
                if(vis[u]==1)
                    continue;
                vis[u]=1;
                for(pair pp : g[u])
                {
                    int v=pp.f;
                    long w=pp.s - Euclideandist(x[u],y[u],x[dest],y[dest]) + Euclideandist(x[v],y[v],x[dest],y[dest]);
                    if(dist[v]>dist[u]+w)
                    {
                        dist[v]=dist[u]+w;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }
            long ans=0;
            if(dist[dest]>=inf)
                ans=-1;
            else
                ans=dist[dest] + Euclideandist(x[src],y[src],x[dest],y[dest]);
			in.close();
			return ans;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
}
