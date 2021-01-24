package question25;

public class UsingRecursion {
	//O(n) time							O(1) space
	public static void main(String args[]) {
		Tree tree1 = new Tree(1); 
        tree1.root.left = new Node(2); 
        tree1.root.right = new Node(3); 
        tree1.root.left.left = new Node(4); 
        tree1.root.left.right = new Node(5); 
        tree1.root.right.left = new Node(6); 
        tree1.root.left.right.left = new Node(7); 
        tree1.root.left.right.right = new Node(8); 
   
        Tree tree2 = new Tree(1);  
        tree2.root.left = new Node(3); 
        tree2.root.right = new Node(2); 
        tree2.root.right.left = new Node(4); 
        tree2.root.right.right = new Node(5); 
        tree2.root.left.right = new Node(6); 
        tree2.root.right.right.left = new Node(8); 
        tree2.root.right.right.right = new Node(7); 
   
        if (isIsomorphic(tree1.root, tree2.root) == true) 
            System.out.println("Yes"); 
        else
            System.out.println("No");
	}
	
	static boolean isIsomorphic(Node node1,Node node2) {
		//if both null,nothing to compare return true
		if(node1==null && node2==null) {
			return true;
		}
		
		if(node1==null || node2==null) {//bcz we can't compare one is null here so they can't be isomorphic
			return false;
		}
		
		//so basically ye check kr rha hai ki same level pe dono tree me agar kisi posiblility me same values hai
		//to wo isomorphic hai,bcz same values hai same level pe to wo flip bhi kr skte hai
		return (isIsomorphic(node1.left,node2.left) && isIsomorphic(node1.right,node2.right)) || (isIsomorphic(node1.left,node2.right) && isIsomorphic(node1.right,node2.left));
	}//			n1->left  n2->left && n1->right  n2->right   ya     n1->left  n2->right && n1->right n2->left
}
