package question2;
import java.io.*;
import java.util.*;

public class UsingQueueOnly {
	//O(n) time										O(1) space(bcz this is not extra space apart queue we are using)
	static Queue<Node> queue = new LinkedList<Node>();
	static int N;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter cache size : ");
		int n = Integer.parseInt(br.readLine());
		N=n;
		System.out.println("Enter query count : ");
		int queries = Integer.parseInt(br.readLine());
		
		while(queries!=0) {
			System.out.println("Enter query : \n1 : set\n2 : get");
			int choice = Integer.parseInt(br.readLine());
			int key;
			switch(choice) {
			case 1:
				System.out.println("Enter key");
				key = Integer.parseInt(br.readLine());
				System.out.println("Enter value");
				int value = Integer.parseInt(br.readLine());
				Node node=new Node(key,value);
				set(node);
				break;
			case 2:
				System.out.println("Enter key");
				key = Integer.parseInt(br.readLine());
				System.out.println(get(key));
				break;
			}
			queries--;
		}
	
	}
	
	static void set(Node node) {
		if(queue.size()<N) {
			queue.add(node);
		}else {
			queue.remove();
			queue.add(node);
		}
	}
	
	static int get(int key) {
		if(queue.isEmpty()) {
			return -1;
		}else {
			Iterator itr=queue.iterator();
			while(itr.hasNext()) {
				Node temp=(Node)itr.next();
				if(temp.key==key) {
					return temp.value;
				}
			}
			return -1;
		}
	}
	
}

class Node{
	int key;
	int value;
	Node(int key,int value){
		this.key=key;
		this.value=value;
	}
}
