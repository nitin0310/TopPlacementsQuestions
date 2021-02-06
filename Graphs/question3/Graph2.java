package question3;

import java.util.*;

/*
 Using BFS
 
 isme parent ko inside loop me update kr denge,bcz ab wo queue me nhi hai and upcoming usi ka neighbor
 hai to wo current removed uska parent hoga,that's it
 
 time O(V+E)
 space O(V)
 
 */

public class Graph2 {
	LinkedList<Integer> adjList[];
	Graph2(int vertex){
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
		
		for(int i=0;i<vertex;i++) {
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
		int par=parent;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			int frontVertex=queue.remove();
		
			for(int neighbor:adjList[frontVertex]) {
				
				if(!visited[neighbor]) {
					visited[neighbor]=true;
					queue.add(neighbor);
					par=frontVertex;
				}else if(neighbor!=par) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter vertices and edges : ");
		int vertices=scan.nextInt();
		int edges=scan.nextInt();
		
		Graph2 graph=new Graph2(vertices);
		
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
