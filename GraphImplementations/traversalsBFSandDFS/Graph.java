package traversalsBFSandDFS;
import java.util.*;

public class Graph {
	
	LinkedList<Integer> adjList[];
	
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
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
	void BFS(int source,int vertex) {
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean visited[]=new boolean[vertex];
		
		//when we add a vertex/node to queue,it means we have visited it,so make it true
		queue.add(source);
		visited[source]=true;
		
		while(!queue.isEmpty()) {
			int frontVertex=queue.remove();
			System.out.print(frontVertex+" ");
			
//			for(int i=0;i<adjList[frontVertex].size();i++) {//checking its all connections, if there's anyone who is not visited,do visit it,then move further
//				if(!visited[adjList[frontVertex].get(i)]) {
//					queue.add(adjList[frontVertex].get(i));
//					visited[adjList[frontVertex].get(i)]=true;
//				}
//			}
			//same
			for(int neighbor:adjList[frontVertex]) {
				if(!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor]=true;
				}
			}
		}
		System.out.println();
	}
	
	//the main difference is, it push single vertex at a time and then traverse one connected node of it, and then traverse one connected node of last visited vertex
	//it won't travel all connected vertex of a vertex at a time
	void DFSUsingStacks(int source,int vertex) {
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]=new boolean[vertex];
		
		stack.push(source);
		visited[source]=true;
		
		while(!stack.isEmpty()) {
			int topVertex=stack.pop();
			visited[topVertex]=true;
			System.out.print(topVertex+" ");
			
//			for(int i=0;i<adjList[topVertex].size();i++) {
//				if(!visited[adjList[topVertex].get(i)]) {
//					stack.push(adjList[topVertex].get(i));
//					visited[adjList[topVertex].get(i)]=true;
//				}
//			}
			//same
			for(int neighbor:adjList[topVertex]) {
				if(!visited[neighbor]) {
					stack.push(neighbor);
					visited[neighbor]=true;
				}
			}
		}
		System.out.println();
	}
	
	void DFSRecursionHelper(int source,boolean[] visited) {
		System.out.print(source+" ");
		visited[source]=true;
		
		//here we making within recusive call to go further to check its neighbor,that's it else every thing is similar
		for(int neighbor:adjList[source]) {
			if(!visited[neighbor]) {
				DFSRecursionHelper(neighbor,visited);
			}
		}
	}
	
	void DFSUsingRecursion(int vertex) {
		boolean[] visited=new boolean[vertex];
		
		DFSRecursionHelper(0,visited);//passing 0 as source
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
		graph.BFS(0, vertex);
		System.out.println("DFS : ");
		graph.DFSUsingStacks(0, vertex);
		graph.DFSUsingRecursion(vertex);
	}
}
