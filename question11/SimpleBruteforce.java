package question11;

public class SimpleBruteforce {
	//O(max(r,c) * r *c) time 								O(1) space
	public static void main(String args[]) {
		int oranges[][]= {
				{2,1,0,2,1},
				{1,0,1,2,1},
				{1,0,0,2,1}
		};
		
		System.out.println(checkTime(oranges,3,5));
	}
	
	//checks the position we are looking for is valid or not i.e its exists or not in the array
	static boolean isSafe(int i, int j,int r,int c)
	{
	    if (i >= 0 && i < r && j >= 0 && j < c)
	        return true;
	    
	    return false;
	}
	
	static int checkTime(int[][] oranges,int r,int c) {
		int no=2;//no indicates the rotten orange
		boolean changed=false;
		
		//O(max(r,c) * r *c)--The matrix needs to be traversed again and again until there is no change in the matrix
		while(true) {//no not run infinte bcz, inside we are checking changed,when it set to false,it break the while loop;
			//O(r*c)
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					//------------------------------
					if (oranges[i][j] == no) {//every time no changes +1,so  we need to update here as well while checking for next path
	                    if (isSafe(i + 1, j,r,c) && oranges[i + 1][j] == 1) {//down
	                        oranges[i + 1][j] = oranges[i][j] + 1;
	                        changed = true;
	                    }
	                    if (isSafe(i, j + 1,r,c) && oranges[i][j + 1] == 1) {//right
	                        oranges[i][j + 1] = oranges[i][j] + 1;
	                        changed = true;
	                    }
	                    if (isSafe(i - 1, j,r,c) && oranges[i - 1][j] == 1) {//up
	                        oranges[i - 1][j] = oranges[i][j] + 1;
	                        changed = true;
	                    }
	                    if (isSafe(i, j - 1,r,c) && oranges[i][j - 1] == 1) {//left
	                        oranges[i][j - 1] = oranges[i][j] + 1;
	                        changed = true;
	                    }
	                }
					//--------------------------------
				}
			}
			
			if(!changed)//at final if there's no change happened then simply return
				break;
			changed=false;//update value
			no++;//because no hum +1 hi store kr rhe hai, at every next iteration
		}
		for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	 
	            // if any orange is found to be
	            // not rotten then ans is not possible
	            if (oranges[i][j] == 1)
	                return -1;
	        }
	    }
		
		return no-2;//bcz from start hum 2 me hi add krte jaate hai +1,that's why
	}
}
