package variableSizeWindow;

public class Question5 {
	public static void main(String args[]) {
		String string="TOTMTAOA";
		String sub="TTA";
		
		System.out.println(minimumWindowSubstring(string.toCharArray(),sub.toCharArray()));
	}
	
	static int minimumWindowSubstring(char[] string,char[] sub) {
		
		HashMap<Character,Integer> subCharCount=new HashMap<Character,Integer>();
		
		int n=string.length;
		int start=0;
		int minLength=Integer.MAX_VALUE;
		
		for(int i=0;i<sub.length;i++) {
			if(subCharCount.containsKey(sub[i])) {
				subCharCount.put(sub[i], subCharCount.get(sub[i])+1);
			}else{
				subCharCount.put(sub[i], 1);
			}
		}
		int uniqueItemCount=subCharCount.size();
		
		for(int end=0;end<n;end++) {
			if(subCharCount.containsKey(string[end])) {
				subCharCount.put(string[end], subCharCount.get(string[end])-1);
				if(subCharCount.get(string[end])==0) {
					uniqueItemCount--;
				}
			}
			
			while(uniqueItemCount==0) {
				if(end-start+1<minLength) {
					minLength=end-start+1;
				}
				
				if(subCharCount.containsKey(string[start])){
					subCharCount.put(string[start], subCharCount.get(string[start])+1);
					if(subCharCount.get(string[start])==1) {
						uniqueItemCount++;
					}
				}
				
				start++;
			}
			
		}
		
		return minLength;
	}
}
