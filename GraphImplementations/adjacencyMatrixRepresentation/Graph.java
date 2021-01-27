package adjacencyMatrixRepresentation;
import java.util.*;

/*

 don't get confused with if vertex=5 then if we want to connect 1 to 6, no!
 bcz here vertex=5 means we are having 5 vertexes, not value of node is 5, no!
 this is count of vertex,
 
 if we are making edge between vertex 1 to 4,it means vertex 1 connect to vertex 4,
 not vertex with value 1 to vertex with 4. that's it
 
 So it simply means vertex = 5, then vertex 1 cannot connect to 6, bcz vertex 6 doesn't even exists
 Simple

*/

public class Graph {
	
	//create adjacency(connected) matrix
	int adjMatrix[][];
	
	//initialize graph/allocate memory for matrix
	Graph(int vertex){
		adjMatrix=new int[vertex][vertex];
	}
	
	
	//add edge between source and destination
	void addEdge(int source,int destination) {
		adjMatrix[source][destination]=1;
		adjMatrix[destination][source]=1;
	}
	
	
	void printGraph(int vertex) {
		for(int i=0;i<vertex;i++) {
			System.out.print(i+" -> ");
			for(int j=0;j<vertex;j++) {
				if(adjMatrix[i][j]==1) {//it means there's an edge between them
					System.out.print(j+" ");
				}
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
