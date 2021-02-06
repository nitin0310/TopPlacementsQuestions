package knightTourProblem;

/*
 for every block we land we calculate make call for 8 blocks
 O(8 ^ (the no. of blocks we have to traverse))
 O(8^ (n^2)) time
 O(1) space
 
 backtracking is somewhere similar to DFS call
 */
public class Backtracking {
	
	static int count=0;
	
	public static void main(String args[]) {
		int n=8;
		
		int[][] tour=new int[n][n];
		knightTour(tour,n,0,0);
		printTour(tour,n);
		
	}
	
	static void knightTour(int[][] tour,int n,int x,int y) {
		
		tour[x][y]=count++;
		
		for(int i=-2;i<=2;i++) {
			for(int j=-2;j<=2;j++) {
				if(i==0 || j==0) {
					continue;
				}
				if(i!=j && i!=-j) {
					int newX=x+i;
					int newY=y+j;
					
					if(valid(newX,newY,n) && tour[newX][newY]==0 && !firstBlock(newX,newY)) {	//it means that block isn't visited and as initially every block is zero,but at last only (0,0) can be zero, so checking the block must not be 0,0
						knightTour(tour,n,newX,newY);
					}
				}
			}
		}
	}
	
	static void printTour(int[][] tour,int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(tour[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean valid(int x,int y,int n) {
		if(x<0 || x>=n || y<0 || y>=n) {	//to keep our moves within board
			return false;
		}
		return true;
	}
	
	static boolean firstBlock(int x,int y) {
		if(x==0 && y==0) {
			return true;
		}
		
		return false;
	}
}
