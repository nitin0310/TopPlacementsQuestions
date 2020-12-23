package question11;
import java.util.*;

public class UsingQueue {
	//O(r*c) time									O(r*c) space
	//somewhere related to BFS, and queue is helpful in count/phase type questions as well
	public static void main(String args[]) {
		int oranges[][]= {
				{2,1,0,2,1},
				{1,0,1,2,1},
				{1,0,0,2,1}
		};
		
		System.out.println(checkTime(oranges,3,5));
	}
	
	static int checkTime(int[][] oranges,int r,int c) {
		
		int timeOrLap=0;
		//so queue is helping as passes by using a delimiter
		Queue<Cell> queue=new LinkedList<Cell>();
		
		//adding all rotten oranges at first
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(oranges[i][j]==2)
					queue.add(new Cell(i,j));
			}
		}
		
		//adding delimiter after adding all rotten oranges of first phase
		queue.add(new Cell(-1,-1));
		
		while(!queue.isEmpty()) {//O(max can reach upto r*c when every cell is added to queue)
			boolean changed=false;
			
			while(!isDelimiter(queue.peek())) {
				Cell cell = queue.remove();
				//check for right
				if(checkCellIsValid(cell.x,cell.y+1,r,c) && oranges[cell.x][cell.y+1]==1) {
					if(!changed) {
						changed=true;//means for this phase or lap, changes occurred or time is counted
						timeOrLap++;
					}
					oranges[cell.x][cell.y+1]=2;
					queue.add(new Cell(cell.x,cell.y+1));
				}
				//check for left
				if(checkCellIsValid(cell.x,cell.y-1,r,c) && oranges[cell.x][cell.y-1]==1) {
					if(!changed) {
						changed=true;
						timeOrLap++;
					}
					oranges[cell.x][cell.y-1]=2;
					queue.add(new Cell(cell.x,cell.y-1));
				}
				//check for top
				if(checkCellIsValid(cell.x-1,cell.y,r,c) && oranges[cell.x-1][cell.y]==1) {
					if(!changed) {
						changed=true;
						timeOrLap++;
					}
					oranges[cell.x-1][cell.y]=2;
					queue.add(new Cell(cell.x-1,cell.y));
				}
				//check for bottom
				if(checkCellIsValid(cell.x+1,cell.y,r,c) && oranges[cell.x+1][cell.y]==1) {
					if(!changed) {
						changed=true;
						timeOrLap++;
					}
					oranges[cell.x+1][cell.y]=2;
					queue.add(new Cell(cell.x+1,cell.y));
				}
				
			}
			queue.remove();//removing delimiter
			
			if(!queue.isEmpty()) {
				queue.add(new Cell(-1,-1));//it means it still have rotten oranges in queue,so adding delimiter for that
			}
		}
		return checkIfAnyLeft(oranges)?-1:timeOrLap;//checking for any fresh orange left, if any
	}
	
	static boolean isDelimiter(Cell cell) {
		return (cell.x==-1 && cell.y==-1) ? true:false;
	}
	
	static boolean checkCellIsValid(int x,int y,int r,int c) {
		if((x<0 || x>r-1) || (y<0 || y>c-1)) {
			return false;
		}
		return true;
	}
	
	static boolean checkIfAnyLeft(int[][] oranges) {
		for(int i=0;i<oranges.length;i++) {
			for(int j=0;j<oranges[i].length;j++) {
				if(oranges[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}
}

class Cell{
	int x;
	int y;
	
	Cell(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class ForNearbyCell{
	int x;
	int y;
}
