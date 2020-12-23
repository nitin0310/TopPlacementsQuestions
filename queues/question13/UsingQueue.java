package question13;
import java.util.*;

public class UsingQueue {
	//O((r^2)*(c^2)) time							O(r*c) space
	public static void main(String args[]) {
		int[][] matrix= {
				{0,0,0,1},
				{0,0,1,1},
				{0,1,1,0}
		};
		int r=3,c=4;
		int result[][]=findDistance(matrix,r,c);
		
		for(int i=0;i<r;i++) {//--------O(r*c)
			for(int j=0;j<c;j++) {
				System.out.print(result[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	static int[][] findDistance(int[][] matrix,int r,int c) {
		Queue<Cell> queue = new LinkedList<Cell>();
		int[][] result = new int[r][c];
		
		for(int i=0;i<r;i++) {//--------O(r*c)
			for(int j=0;j<c;j++) {
				if(matrix[i][j]==1) {
					queue.add(new Cell(i,j));
				}
			}
		}
		
		for(int i=0;i<r;i++) {//--------O(r*c)
			for(int j=0;j<c;j++) {
				if(matrix[i][j]==1) {
					result[i][j]=0;
				}else{
					result[i][j]=findMin(i,j,queue);//---O(r*c) worst case
				}
			}
		}
		
		return result;
	}
	
	static int findMin(int i2,int j2,Queue<Cell> queue) {
		int distance=Integer.MAX_VALUE;
		
		Iterator itr=queue.iterator();
		while(itr.hasNext()) {
			Cell cell=(Cell)itr.next();
			System.out.print(cell.i1+" -- "+cell.j1+" || ");
			int i=cell.i1-i2<0?(cell.i1-i2)*(-1):(cell.i1-i2);
			int j=cell.j1-j2<0?(cell.j1-j2)*(-1):(cell.j1-j2);
			
			int result = i+j;
			if(result<distance) {
				distance=result;
			}
		}
		System.out.println("\n=========");
		return distance;
	}
}

class Cell{
	int i1;
	int j1;
	
	Cell(int i,int j){
		this.i1=i;
		this.j1=j;
	}
}