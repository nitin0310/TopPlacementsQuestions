package question14;

public class UsingPreOrderAndArray {
/*
 the thing we can do here is,
 do preOrder traversal,and while doing just each node to an array,
 now while traversing we aslo check that node is already present in the array,
 if it is-
 	then we retrieve that index and run loop for 2 next element to it, if they matches,
 	then the contains duplicate and surely update flag to true
 else
 	keep going
 	
 	//O(2 n^2) time	--recursion,linear search			O(n) space--for array
 	 
 	 *but may fail in edge cases let if that subtree is skeewed, where ever it is present 
 	 then traversal gonna give true, when it is not actually duplicate
 */
}
