package question2;

import java.util.*;

/*
 why using DFS?
 bcz BFS will take a lot time to detect,and even DFS, uses recursive calls that helps to 
 eliminate node from current ongoing DFS paths
 
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
		boolean[] visited=new boolean[vertex];//to check which node is already visited
		boolean[] currDFS=new boolean[vertex];//to check which node is included in current dfs
		
		for(int i=0;i<vertex;i++) {//run dfs for every node,till we haven't get loop at last
			if(!visited[i]) {
				if(detectCycleHelper(i,visited,currDFS)) {
					return true;
				}
			}
		}
		
		//agar kisi bhi node se dfs me koi bhi cycle nhi mili to ye reach krega
		return false;
	}
	
	//if in ongoing dfs path we find loop then it return true
	boolean detectCycleHelper(int source,boolean[] visited,boolean[] currDFS) {
		currDFS[source]=true;//including node in current running dfs path
		visited[source]=true;//mark it true when we visit it
		
		//exploring neighbors or moving further in dfs path
		for(int neighbor:adjList[source]) {
			
			if(currDFS[neighbor]==true) {//it means it is already included in this ongoing dfs path and we reached it again,so it is obviously making a cycle
				return true;
			}
			
			//let if we havn't yet reached to it,so now explore its neighbor
			//or agar pehle se visited hai to matlab,jis dfs path me ye include hua hoga usme cycle mil gyi hoga ya nhi,dobara is pe hum aa rhe hai matlab nhi hi mili hogi
			if(visited[neighbor]==false) {
				if(detectCycleHelper(neighbor,visited,currDFS)) {
					return true;//explore krte krte ye bolta hai ki,mere hi dfs me maine same node ko reach kiya 2 baar, to true return krdega
				}
			}
		}
		
		//else ongoing dfs path me kisi ko same node dobara nhi mila, to is dfs path me cycle nhi hai,to sbhi nodes ko is dfs path se remove krte chalo
		currDFS[source]=false;
		return false;//it means is dfs path me mujhe koi cycle nhi mili
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
