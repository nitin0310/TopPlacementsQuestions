package disjointUndirectedCycleDetectionOptimized;
import java.util.*;

/*
 
 
 
 O(E log(V)) time			--(V for calling find or union in worst case, skewed,   E for processing all edge)
 O(E) space 		    	--parent[],rank[]
 */
public class Graph{
	
	LinkedList<Integer>[] adjList;							//this is just to add single side edge to edge array
	int[] parent;
	int[] rank;
	static ArrayList<Edge> edges=new ArrayList<Edge>();
	
	public static void main(String args[]) {
		Graph graph=new Graph(4);
		graph.edges.add(new Edge(0,1));
		graph.edges.add(new Edge(1,2));
		graph.edges.add(new Edge(2,3));
		graph.edges.add(new Edge(3,0));
		
		
		System.out.println(graph.detectCycle(edges));
	}
	
	//O(log n)
	boolean detectCycle(ArrayList<Edge> edges) {
		
		for(Edge edge:edges) {
			int r1=find(edge.src);
			int r2=find(edge.dest);
			
			if(r1==r2) {							//check if both belongs to same set or not
				return true;
			}
			
			//if not, then union both set
			setUnion(edge.src,edge.dest);
			
		}
		return false;
	}
	
	
	//O(log n)
	int find(int element) {	//finds absolute root of element
		if(parent[element]==element) {
			return element;
		}
		
		parent[element]=find(parent[element]);//and in parallel this is directly linking that node to root,so it decreasing height
		return parent[element];
	}
	
	//O(log n)
	void setUnion(int element1,int element2) { //if both elements are of different set then do union to make single set,both set have different root,then simply link one root to another
		int root1=find(element1);
		int root2=find(element2);
		
		if(rank[root1]>rank[root2]) {
			parent[root2]=root1;
		}else if(rank[root1]<rank[root2]) {
			parent[root1]=root2;
		}else {
			parent[root1]=root2;
			rank[root2]+=1;
		}
	}
	
	Graph(int vertex){
		parent=new int[vertex];
		rank=new int[vertex];
		
		for(int i=0;i<vertex;i++) {	//bcz at initial they all are root of their own set
			parent[i]=i;
		}
	}
	
	void addEdge(int src,int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src);
	}
}

class Edge{
	int src;
	int dest;
	
	Edge(int source,int destination){
		this.src=source;
		this.dest=destination;
	}
}
