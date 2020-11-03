package question18;
import java.util.*;

public class UsingStack {
	//O(n) --time			O(n) --worst case
	public static void main(String[] args)  
    { 
        int arr[] = { 11, 2, 5, 13 }; 
        int n = arr.length; 
        printNGE(arr, n);
    } 

	static void printNGE(int arr[], int n)  
    {
		Stack<Integer> s=new Stack<Integer>();
        int i = 0;
        int element, next; 

        s.push(arr[0]); 

        for (i = 1; i < n; i++)  
        { 
            next = arr[i]; 
  
            if (s.isEmpty() == false)  
            {
                element = s.pop();
                
                while (element < next)  
                { 
                    System.out.println(element + " --> " + next); 
                    if (s.isEmpty() == true) 
                        break; 
                    element = s.pop(); 
                } 

                if (element > next) 
                    s.push(element); 
            } 

            s.push(next); 
        } 
  
        while (s.isEmpty() == false)  
        { 
            element = s.pop(); 
            next = -1; 
            System.out.println(element + " -- " + next); 
        } 
    }

}
