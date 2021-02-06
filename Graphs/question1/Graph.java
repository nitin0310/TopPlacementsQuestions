package question1;
import java.util.*;

public class Graph {
	
	LinkedList<Edge> adjList[];
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Edge>();
		}
	}
	
	void addNewEdge(int source,int destination,int distance) {
		adjList[source].add(new Edge(source,destination,distance));
		adjList[destination].add(new Edge(destination,source,distance));
	}
	
	void printAdjacencyList(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(Edge neighbor:adjList[i]) {
				System.out.print(neighbor.destination+" : "+neighbor.distance+" ");
			}
			System.out.println();
		}
	}
	
	
	void bfsTraversal(int source,int vertex) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[vertex];
		
		visited[source]=true;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			
			int frontNode=queue.remove();
			System.out.print(frontNode+" ");
			for(Edge neighbor:adjList[frontNode]) {
				
				if(!visited[neighbor.destination]) {
					visited[neighbor.destination]=true;
					queue.add(neighbor.destination);
				}
			}
		}
		
		System.out.println();
	}
	
	void dfsTraversal(int source,int vertex) {
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]=new boolean[vertex];
		
		stack.push(source);
		visited[source]=true;
		
		while(!stack.isEmpty()) {
			
			int topVertex=stack.pop();
			System.out.print(topVertex+" ");
			for(Edge neighbor:adjList[topVertex]) {
				
				if(!visited[neighbor.destination]) {
					visited[neighbor.destination]=true;
					stack.push(neighbor.destination);
				}
			}
		}
		
		System.out.println();
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
			int distance=scan.nextInt();
			
			graph.addNewEdge(source, destination, distance);
		}
		
		graph.printAdjacencyList(vertices);
		graph.bfsTraversal(0, vertices);
		graph.dfsTraversal(0, vertices);
	}
}

class Edge{
	int source;
	int destination;
	int distance;//weight
	
	Edge(int source,int destination,int distance){
		this.source=source;
		this.destination=destination;
		this.distance=distance;
	}
}