package _unweightedGraphs;
import java.util.*;

public class Graph {
	
	LinkedList<Integer> adjList[];
	
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	
	//undirected to connecting to both sides
	void addEdge(int source,int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
	}
	
	
	void printGraph(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(int connected:adjList[i]) {
				System.out.print(connected+" ");
			}
			System.out.println();
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
			
			graph.addEdge(source,destination);
		}
		
		graph.printGraph(vertex);
		
	}
}
