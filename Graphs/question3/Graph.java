package question3;

import java.util.*;

/*
 Undirected me main funda ye ha ki, true 2 baar aa skta hai,
 1 jab cycle exist krti ho
 2 jab parent node traverse ho jaaye
 
 now simple si thing hai cycle wo hogi,
 jo node visited bhi ho or parent bhi na ho,that'so it
 
 now bss hum parent ko neighbour call me pass krte rhenge
 
 time O(V+E)
 space O(V) used visited[] and currenDFS[] to keep track of vertices
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
	
	boolean detectCycle(int vertex) {
		boolean[] visited=new boolean[vertex];
		
		for(int i=0;i<vertex;i++) {//run dfs for every node,till we haven't get loop at last
			if(!visited[i]) {
				if(detectCycleHelper(i,visited,-1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	

	boolean detectCycleHelper(int source,boolean[] visited,int parent) {
		visited[source]=true;
		
		for(int neighbor:adjList[source]) {
			
			if(!visited[neighbor]) {//visted nhi hai! to visit kr k or aage move krenge
				if(detectCycleHelper(neighbor,visited,source)) {
					return true;
				}
			}else if(neighbor!=parent) {//node already visited hai,but instead of parent
				return true;
			}
		}
		
		return false;
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
		System.out.println("cycle? : "+graph.detectCycle(vertices));
	}
}
