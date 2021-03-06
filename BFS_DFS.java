/*********************************************************************************************************************
     **
     **  BFS & DFS of graph
     **  queue is used for BFS and stack for DFS
     **  Input in the form of array
     **  Output is printed in listed manner
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;

public class Main
{

	public static void main(String[] args) 
	{

		// create list to store edges of graph
		LinkedList<Integer> list[]=new LinkedList[4];
		
		int [][]edges={{0, 1},{0, 2},{1, 2},{2, 0},{2, 3},{3, 3}};
		
		for(int i=0;i<4;i++)
		    list[i]=new LinkedList();
		    
		for(int i=0;i<6;i++)
		    list[edges[i][0]].add(edges[i][1]);
		
		//breadth first 
		String s=bfs(list,2);
		System.out.println(s);
		
		//depth first
		boolean[]visited=new boolean[4];
		dfs(list,2,visited);
			
	}

	public static String bfs(LinkedList<Integer>[]list,int root)
	{

	    Queue<Integer> queue=new LinkedList<Integer>();
	    queue.add(root);
	    boolean[] visited=new boolean[list.length];
	    visited[root]=true;
	    String s="";

	    while(queue.size()!=0)
	    {
	        Integer t=queue.poll();
	        s+=t+" ";
	        Iterator<Integer> itr=list[t].iterator();
	        while(itr.hasNext())
	        {
	            int tmp=itr.next();
	            if(!visited[tmp])
	            {
	                visited[tmp]=true;
	                queue.add(tmp);
	            }
	        }
	    }
	    return s;

	}

	public static void dfs(LinkedList<Integer>[]list,int n,boolean[]visited)
	{

	    visited[n]=true;
	    
	    System.out.print(n+" ");
	    Iterator<Integer> itr=list[n].iterator();
	    
	    while(itr.hasNext())
	    {
	        int t=itr.next();
	        if(!visited[t])
	        {
	            dfs(list,t,visited);
	        }
	    }
	}

}
