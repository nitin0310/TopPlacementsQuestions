package findArticulationPoint;

import java.util.*;

/*
 time O(V+E)
 space O(V)
 */

public class UsingTarjanAlgorithm {
	public static void main(String args[]) {
		Graph graph=new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		graph.addEdge(3, 0);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		graph.addEdge(3, 5);
		graph.addEdge(5, 3);
		
		graph.findArticularPoints(6);
		graph.printArticulationPoint(6);
	}
	
	
}

class Graph{
	
	LinkedList<Integer>[] adjList;
	int disc[];										//discovery time
	int low[];										//node reachable with lowest discovery time
	int parent[];
	boolean artPoint[];
	
	int discTime=0;
	
	
	Graph(int vertex){
		adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	
	void addEdge(int src,int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src);
	}
	
	void findArticularPoints(int vertex) {
		disc=new int[vertex];
		low=new int[vertex];
		parent=new int[vertex];
		artPoint=new boolean[vertex];
		
		for(int i=0;i<vertex;i++) {
			disc[i]=-1;
			low[i]=-1;
			parent[i]=-1;
			artPoint[i]=false;
		}
		
		for(int i=0;i<vertex;i++) {
			if(disc[i]==-1) {
				findArticularPointsHelper(i);
			}
		}
	}
	
	//here if given graph is undirected then we aren't taking care of same edge in reverse
	void findArticularPointsHelper(int source) {
		disc[source]=discTime;
		low[source]=discTime;
		discTime++;
		
		int children=0;
		
		for(int neighbor:adjList[source]) {
			
			//here we deal with single direction only
			if(disc[neighbor]==-1) {								//when neighbor isn't visited yet
				
				//every time we increase children, when we visit its neighbor
				children++;											//as we are checking one of it's neighbor,then for sure it is one of source's children
				parent[neighbor]=source;
				findArticularPointsHelper(neighbor);
				low[source]=Math.min(low[source], low[neighbor]);	//update low[] again, bcz we may have encountered back edge,and need to update low[] of source
				
				if(parent[source]==-1 && children>1) {				//Case -- if it is root node,and having more than 1 children, then for sure it would be articulation point
					artPoint[source]=true;
				}
				if(parent[source]!=-1 && low[neighbor]>=disc[source]) {	//case -- if it is not root node,and none of its children have encountered back edge, so if haven't found any back edge then for sure, we can't get children if source is not there
					artPoint[source]=true;
				}
				
			}//as in undirected, same with reverse direction, we only deal with if not that node's parent
			else if(neighbor!=parent[source]) {					//if neighbor is visited and it is not its parent,then we can update low[] for source
				low[source]=Math.min(low[source], disc[neighbor]);
			}
			
		}
	}
	
	void printArticulationPoint(int vertex) {
		for(int i=0;i<vertex;i++) {
			if(artPoint[i]) {
				System.out.println(i);
			}
		}
	}
	
}