package trees;

// A version of this question is to convert binary tree to circular linked list

public class BTtoDLL {
	
	static Tnode prev;
	static Tnode head;
	
	static Tnode conversion(Tnode root)
	{
		conversionAsset(root);
		return head;
	}
  // conversion in inorder
	static void conversionAsset(Tnode tree)
	{
		if(tree==null)
		{
			return ;
		}
		
		conversionAsset(tree.left);
		
		if(prev==null)
			head=tree;
		else
		{
			prev.right=tree;
			tree.left=prev;
		}
		prev=tree;
		
		conversionAsset(tree.right);
		
	}
	
	static void traverseHead(Tnode head)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Tnode temp=head;
			while(temp!=null)
			{
			    System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        Tnode head=conversion(bt.root);
        traverseHead(head);

	}

}
