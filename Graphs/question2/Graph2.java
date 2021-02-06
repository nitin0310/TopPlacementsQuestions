package question2;

import java.util.*;

/*
 Using BFS
 
 time O(V+E),why?
 bcz hum ek continous path ko check krenge as in bfs, but agar us path pe cycle nhi hai to
 uske nodes ko visited ho gye na, dobara ab kbhi bhi traverse nhi honge unke aage k path,that's why
 space O(V) used visited[] and currentBFS[] to keep track of vertices
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
		boolean[] currBFS=new boolean[vertex];//to check which node is included in current dfs
		
		for(int i=0;i<vertex;i++) {//run dfs for every node,till we haven't get loop at last
			if(!visited[i]) {
				if(detectCycleHelper(i,visited,currBFS)) {
					return true;
				}
			}
		}
		
		//agar kisi bhi node se dfs me koi bhi cycle nhi mili to ye reach krega
		return false;
	}
	
	//if in ongoing dfs path we find loop then it return true
	boolean detectCycleHelper(int source,boolean[] visited,boolean[] currBFS) {
		currBFS[source]=true;//including node in current running bfs path
		visited[source]=true;//mark it true when we visit it
		
		//exploring neighbors or moving further in bfs path
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			int frontVertex=queue.remove();
			
			//simply hum ek front node remove krenge use bfs path me add krenge fir usi k neighbors ko explore krenge
			//agar koi path hoga to wo currBFS ka node hoga or visited bhi hoga
			for(int neighbor:adjList[frontVertex]) {
				
				if(currBFS[neighbor]==true) {
					return true;
				}
				
				if(!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor]=true;
					currBFS[neighbor]=true;
				}
			}
			//wrna at last sbhi neighbor ko explore kr liya lekin koi cycle nhi mili to us node ko currBFS path se remove kr do
			
			currBFS[frontVertex]=false;//yahan recursive call nhi hai, but ek hi node k sbhi neighbor check ho rhe hai to at last koi cycle nhi mile to use false mark kr
			//do us BFS path se
		}
		
		
		//else ongoing dfs path me kisi ko same node dobara nhi mila, to is dfs path me cycle nhi hai,to sbhi nodes ko is dfs path se remove krte chalo
		currBFS[source]=false;
		return false;//it means is dfs path me mujhe koi cycle nhi mili
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
