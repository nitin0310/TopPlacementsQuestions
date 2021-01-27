package shortestPathUsingBFS;
import java.util.*;

/*
 we are using parent[] bcz it help in getting minimum edges in path and
 can also help to track all nodes came in that path,
 how its giving shortest path? bcz as it will update its parent, and bfs
 add first upcoming parent,then mark it as true,so that after upcoming parent would not
 be able to change it.
 
 while finding shortest path,we just go to its parent increase count,that's it
 */
public class Graph {
	
	LinkedList<Integer> adjList[];
	int parent[];
	
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		parent=new int[vertex];
		
		//must condition, to initialize each linked list else we get null pointer exception
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	
	void addEdge(int source,int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
	}
	
	
	void printGraph(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(int j=0;j<adjList[i].size();j++) {//getting size bcz may this node connected to 0 nodes or may to 5 nodes
				System.out.print(adjList[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	
	//if source not given then we can pick any value
	void shortestPathBFS(int source,int vertex) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[vertex];
		
		queue.add(source);
		visited[source]=true;
		parent[source]=-1;//parent of source should be -1,so that it can help to terminate while calculating distance
		
		while(!queue.isEmpty()) {
			int frontVertex=queue.remove();
			System.out.print(frontVertex+" ");
			
			for(int neighbor:adjList[frontVertex]) {
				if(!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor]=true;
					parent[neighbor]=frontVertex;//this will add the parent who reached this node first
				}
			}
		}
		System.out.println();
	}
	
	void findDistance(int source,int destination) {
		int temp=parent[destination];
		int count=0;
		
		while(temp!=-1) {
			count++;//we counted first bcz, as we have already initialized temp with first parent
			temp=parent[temp];
		}
		
		System.out.println("shortest path have : "+count+" edges");
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
		System.out.println("BFS : ");
		graph.shortestPathBFS(0, vertex);
		graph.findDistance(0, 5);
	}
}
