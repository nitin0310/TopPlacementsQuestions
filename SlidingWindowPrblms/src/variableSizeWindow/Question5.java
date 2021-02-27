package variableSizeWindow;

public class Question5 {
	public static void main(String args[]) {
		
	}
	
	static int minimumWindowSubstring(char[] string,char[] sub) {
		
		int[] subCharCount=new int[256];
		int[] stringCharCount=new int[256];
		
		int n=string.length;
		int start=0;
		int minLength=Integer.MAX_VALUE;
		
		for(int i=0;i<sub.length;i++)	subCharCount[sub[i]]++;
		
		
		for(int end=0;end<n;end++) {
			stringCharCount[string[end]]++;
			
			if(isSubFoundValid(subCharCount,stringCharCount,sub)) {
				if(end-start+1<minLength) {
					minLength=end-start+1;
				}
			}
		}
	}
	
	static boolean isSubFoundValid(int[] subCharCount,int[] stringCharCount,char[] sub) {
		for(int i=0;i<sub.length;i++) {
			if(stringCharCount[sub[i]]<subCharCount[sub[i]]) {
				return false;
			}
		}
		
		return true;
	}
}
