package disjointFindUnionOptimized;

/*
	simply, when we call find, so if less nodes connected in that path then complexity decreases,
	so here every time whenever we find root of a node,we directly link all nodes coming in that path
	to root-- now time complexity reduced to O(log V)
	
	concept of Rank?
	whenever we add or merge or do union of two sets, we increase rank of the root of newly created universal set,so that in future it will help us to make smaller height tree or set from the root,
	bcz it tells us the no. of sets connected,
	so if we add greater rank set to smaller rank,then it will increase height,
	and smaller to greater not increase, that's why
	
	if both are having same rank, then simply connect root1 to root,we can connect anyone
	if rank of root1 is smaller then connect it to root2
 */
public class Graph{
	
	int[] parent;
	int[] rank;
	
	Graph(int vertex){
		parent=new int[vertex];
		rank=new int[vertex];
		
		for(int i=0;i<vertex;i++) {	//bcz at initial they all are root of their own set
			parent[i]=i;
		}
	}
	
	//whenever we call find we simply update all parent to absolute root, which came in that path that node to root
	//O(log n)
	int find(int element) {
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
			rank[root1]++;
		}else if(rank[root1]<=rank[root2]) {
			parent[root1]=root2;
			rank[root2]+=1;
		}
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
