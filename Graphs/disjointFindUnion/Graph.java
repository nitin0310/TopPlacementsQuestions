package disjointFindUnion;

/*
 why we are using disjoint set,
 disjoint set = two sets having no element similar
 
 find = it simply returns the absolute root of that set
 
 union = it simply connects or joins two sets to make them a universal set,that includes all values of set1 and set2
 
 how disjoint set is helping us?
 --> it works for UNDIRECTED GRAPH ONLY,
 
 if we are provided an edge (src to dest)
 now if both src and dest are in different sets,it means there's no path exist between them already
 then we union both sets to make that edge, now both src and dest exists in same set, we successfully added that edge
 
 now if any other edge came and its both src and dest exists in this set,
 it means we already have a path between them,either direct edge or other path, but it exists
 
 and we are again said to add this edge,src to dest
 it means there exists a cycle, we are said to link src and dest that already in same set(already have path btw them)
 
 we can't find with Directed?
 bcz in directed we can't find union, a->b or b->a
 */
public class Graph{
	
	int[] parent;
	
	Graph(int vertex){
		parent=new int[vertex];
		
		for(int i=0;i<vertex;i++) {	//bcz at initial they all are root of their own set
			parent[i]=i;			//at initial it is current node is root of itself
		}
	}
	
	
	int find(int element) {	//finds absolute root of element
		if(parent[element]==element) {//if node meets itself, it means it is root of current set
			return element;
		}
		
		parent[element]=find(parent[element]);//make recursive else, this element is a child
		return parent[element];
	}
	
	void setUnion(int element1,int element2) { //if both elements are of different set then do union to make single set,both set have different root,then simply link one root to another
		int root1=find(element1);
		int root2=find(element2);
		
		parent[root1]=root2;
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
