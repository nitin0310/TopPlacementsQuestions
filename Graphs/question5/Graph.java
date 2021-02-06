package question5;

import java.util.*;

/*
 done using greedy method, which works by finding min of distances[] everytime
 
 Dijkstra ka simple funda hai,
 source node se sbhi node tk ka minimum distance nikalna hai using weight(bcz weight defines cost to reach that node)
 
 steps:
 
 visited[] ---taaki pta lgta rhe kiske neighbors se calculate ho chuka hai distance
 distance[] ---to hold distances,initially infinity kr denge sbka then source ka 0 hoga bcz source se source ka distance 0 hoga
 
 main role distance ka hai yahan,bcz it works as like queue (tells which node should come next so that we can check for its adjacent)
 so yahan koi queue ya stack nhi hai,yahan distance[] me jiska minimum hoga uske adjacent dekhenge,but visited me bhi check kr lenge ki visited na ho
 ,taaki dobara us se distance na nikale
 
 finally (source se us node tk ka distance+weight) < already weight se, to update kr denge
 that's it
 
 O(V^2) time
 O(V) space ---- distance,visited
 */

public class Graph {
	
	//create adjacency(connected) matrix
	int adjMatrix[][];
	
	//initialize graph/allocate memory for matrix
	Graph(int vertex){
		adjMatrix=new int[vertex][vertex];
	}
	
	
	//add edge between source and destination
	void addEdge(int source,int destination,int weight) {
		adjMatrix[source][destination]=weight;
		adjMatrix[destination][source]=weight;
	}
	
	
	void printGraph(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(int j=0;j<vertex;j++) {
				if(adjMatrix[i][j]==1) {//it means there's an edge between them
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}
	
	void dijkstraAlgo(int vertex,int source) {
		boolean visited[]=new boolean[vertex];
		int distance[]=new int[vertex];
		
		//initializing all weight to infinity
		for(int i=0;i<vertex;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		
		//now source to source distance would be 0
		distance[source]=0;
		
		for(int i=0;i<vertex;i++) {
			int node=findMinIndex(distance,visited,vertex);
			
			visited[node]=true;//min element, iske sbhi adjacent check krenge
			
			
			//conditions: edge ho(to get weight)  visited na ho   distance already infinity na ho
			for(int j=0;j<vertex;j++) {
				if(adjMatrix[node][j]!=0   &&   !visited[j]   &&   distance[node]!=Integer.MAX_VALUE) {
					
					if((adjMatrix[node][j]+distance[node]) < distance[j]) {
						distance[j] = adjMatrix[node][j]+distance[node];
					}
					
				}
			}
		}
		
		printDistances(distance,source,vertex);
	}
	
	int findMinIndex(int dis[],boolean vis[],int vertex) {
		int min=Integer.MAX_VALUE;//initializing minimum variable
		int index=-1;
		
		for(int i=0;i<vertex;i++) {
			if(dis[i]<min && vis[i]!=true) {		//it must be min and not visited,bcz we have already counted as possible distance from it, to other vertices
				min=dis[i];
				index=i;
			}
		}
		
		return index;
	}
	
	void printDistances(int[] distance,int source,int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.println(source+" -> "+i+" : "+distance[i]);
		}
	}
	
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter vertices and edges : ");
		int vertex=scan.nextInt();
		int edges=scan.nextInt();
		
		Graph graph=new Graph(vertex);
		
		System.out.println("Enter "+edges+" edges : ");
		for(int i=0;i<edges;i++) {
			int source=scan.nextInt();
			int destination=scan.nextInt();
			int weight=scan.nextInt();
			
			graph.addEdge(source,destination,weight);
		}
		

		System.out.println("Shortest distances from source : ");
		graph.dijkstraAlgo(vertex, 0);
		
		
	}
}