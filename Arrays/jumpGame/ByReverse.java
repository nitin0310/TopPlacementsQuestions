package jumpGame;

public class ByReverse {
	public static void main(String args[]) {
		//it tells if we be able to reach end from start
		//if we can then return 1
		//else return 0
	}
	
	
	//it can only say, is possible or not,
	//can't guarantee for min
	
	//eg 2 1 2 0 3 ----1 and 2 both can reach 2,
	static int canReach(int[] nums, int N) {
        int lastPos = nums.length - 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos==0?1:0;
    }
}