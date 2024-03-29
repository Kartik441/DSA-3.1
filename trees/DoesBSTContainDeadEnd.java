package trees;
// given a binary tree containing only positive integers, check for a dead end(we are not able to insert
// any node after that node)
import java.util.HashSet;

public class DoesBSTContainDeadEnd {
	
	static HashSet<Integer> nodes = new HashSet<>();
	static HashSet<Integer> leaves = new HashSet<>();
	
	
	static boolean deadEnd(Tnode root)
	{
		fillSet(root);
		
		for(int leaf : leaves)
		{
			if(leaf == 1)
			{
				if(nodes.contains(leaf + 1))
					return true;
			}
			else
			{
				if(nodes.contains(leaf + 1)  && nodes.contains(leaf - 1))
					return true;
			}
		}
		
		return false;
	}
	
	static void fillSet(Tnode root)
	{
		if(root == null)
			return;
		fillSet(root.left);
		if(root.left == null && root.right == null)
		{
			nodes.add(root.data);
			leaves.add(root.data);
		}
		else {
			nodes.add(root.data);
		}
		fillSet(root.right);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        System.out.println(deadEnd(bt.root));

	}

}
