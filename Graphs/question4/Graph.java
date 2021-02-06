package question4;

import java.util.*;

/*
 BFS-----bcz DFS t pta ni unecessary path pe se kb tk aaye
 
 main funda ye hai ki,ek distance array lenge jo source se us node tk ka minimum
 distance hold krega
 
 source to source 0 hoga jo ki ditance[] declaration se hi 0 initialize ho jayega
 now ab hum jb bhi kisi pe move krenge to
 agar wo visited nhi hai to uska source(jiske through wo yahan aaya hai) uska distance+1,
 else
 agar visited hai to matlab koi na koi yahan tk aa chuka to usme stored distance se current k distance+1 me se
 minimum usme update kr denge, that's it
 
 
 */

public class Graph {
	LinkedList<Integer> adjList[];
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	void addNewEdge(int source,int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
	}
	
	void printAdjacencyList(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(int neighbor:adjList[i]) {
				System.out.print(neighbor+" ");
			}
			System.out.println();
		}
	}
	
	int findMinDistance(int source,int destination,int vertex) {
		boolean visited[]=new boolean[vertex];
		int distance[]=new int[vertex];
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		visited[source]=true;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			
			int frontVertex=queue.remove();
			
			for(int neighbor:adjList[frontVertex]) {
				//-------------------------------------------------
				if(!visited[neighbor]) {
					visited[neighbor]=true;
					distance[neighbor]=distance[frontVertex]+1;
					queue.add(neighbor);
				}else {//						already jo tha     vs     jiske through ab aaye hai+1 
					distance[neighbor]=Math.min(distance[neighbor], distance[frontVertex]+1);
				}
				//-------------------------------------------------
			}
		}
		
		return distance[destination];
	}
	
	
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter vertices and edges : ");
		int vertices=scan.nextInt();
		int edges=scan.nextInt();
		
		Graph graph=new Graph(vertices);
		
		System.out.println("Enter "+edges+" edges with weights");
		for(int i=0;i<edges;i++) {
			int source=scan.nextInt();
			int destination=scan.nextInt();
			
			graph.addNewEdge(source, destination);
		}
		
		graph.printAdjacencyList(vertices);
		
		System.out.println("Enter source and destination : ");
		int source=scan.nextInt();
		int destination=scan.nextInt();
		
		System.out.println("Minimum distance : "+graph.findMinDistance(source, destination, vertices));
	}
}
