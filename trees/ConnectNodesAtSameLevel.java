package trees;

import java.util.LinkedList;
import java.util.Queue;

// code in progress
class Nnode
{
	int data;
	Nnode left;
	Nnode right;
	Nnode next;
	
	Nnode(int data)
	{
		this.data = data;
	}
}



public class ConnectNodesAtSameLevel {
	// Using level Order Traversal
	// TC: O(n)
	// SC: O(n)
	static void connectNodes(Nnode root)
	{
		Queue<Nnode> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty())
		{
			Nnode prev = null;
			int size = q.size();
			
			while(size > 0)          // This loop will execute for a particular level
			{
				Nnode x = q.remove();
				if(prev!=null)
				{
					prev.next = x;
				}
				
				prev = null;
				
				if(x.left!=null)
					q.add(x.left);
				if(x.right != null)
					q.add(x.right);
				
				size -- ;
			}
			
		}
		
	}
	
	// Using recursive preorder
	// TC : O(n * O(nodes in a level)
	// SC : O(1)
	
	static void connectNodes1(Nnode root)
	{
		if(root == null)
			return ;
		
		while(root != null)
		{
			Nnode temp = root;
			
			while(temp != null)
			{
				if(temp.left != null)
				{
					if(temp.right != null)
					{
						temp.left.next = temp.right;
					}
					else
					{
						temp.right.next = getNextRight(temp);
					}
				}
				
				if(temp.right != null)
				{
					temp.right.next = getNextRight(temp);
				}
				
				temp = temp.next;
			}
			
			if(root.left != null)
			{
				root = root.left;
			}
			else if(root.right != null)
			{
				root = root.right;
			}
			else
			{
				root = getNextRight(temp);
			}
		}
	}
	
	static Nnode getNextRight(Nnode node)
	{
		Nnode temp = node.next;
		
		while(temp!=null)
		{
			if(temp.left != null)
				return temp.left;
			else if(temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {
		Nnode root = new Nnode(10); 
		root.left = new Nnode(8); 
        root.right = new Nnode(2); 
        root.left.left = new Nnode(3); 
        root.right.right = new Nnode(90); 
        
        connectNodes(root);
        
        int a = root.next != null ?  
                root.next.data : -1; 
int b = root.left.next != null ?  
            root.left.next.data : -1; 
int c = root.right.next != null ?  
           root.right.next.data : -1; 
int d = root.left.left.next != null ?  
             root.left.left.next.data : -1; 
int e = root.right.right.next != null ?  
              root.right.right.next.data : -1; 

// Now lets print the values 
System.out.println("Following are populated nextRight pointers in "
+ " the tree(-1 is printed if there is no nextRight)"); 
System.out.println("nextRight of " + root.data + " is " + a); 
System.out.println("nextRight of " + root.left.data  
                                  + " is " + b); 
System.out.println("nextRight of " + root.right.data +  
                                      " is " + c); 
System.out.println("nextRight of " + root.left.left.data +  
                                       " is " + d); 
System.out.println("nextRight of " + root.right.right.data +  
                                        " is " + e); 

	}

}
