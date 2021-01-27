package _weightedGraphs;
import java.util.*;

/*
 in weighted, we need to modify an edge bcz it contain weight as well
 weighted isn't carry by vertex,it is carry by edge
 */
public class Graph {
	
	LinkedList<Edge> adjList[];
	
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Edge>();
		}
	}
	
	
	//undirected to connecting to both sides
	void addEdge(int source,int destination,int weight) {
		adjList[source].add(new Edge(destination,weight));
		adjList[destination].add(new Edge(source,weight));
	}
	
	
	void printGraph(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(Edge connected:adjList[i]) {
				System.out.print(connected.destination+" : weight "+connected.weight+" ");
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
			int weight=scan.nextInt();
			
			graph.addEdge(source,destination,weight);
		}
		
		graph.printGraph(vertex);
		
	}
}

class Edge{
	int destination;
	int weight;
	
	Edge(int destination,int weight){
		this.destination=destination;
		this.weight=weight;
	}
}