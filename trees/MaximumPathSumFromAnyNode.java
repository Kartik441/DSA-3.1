package trees;

// MAximum Path sum from any node to any node

public class MaximumPathSumFromAnyNode {
	
	static int res = Integer.MIN_VALUE;
	
	static int maxPath(Tnode root)
	{
		if(root == null)
			return 0;
		
		int left = maxPath(root.left);
		int right = maxPath(root.right);
	

		int temp = root.data + Math.max(left, right);
		
		// now check whether to temp is useful or only this node is giving max value
		
		temp = Math.max(temp, root.data);
		
		int ans = Math.max(temp, root.data + left + right);
		
		// this might be greater than the result
		res = Math.max(res, ans);
		
		return temp;
	}
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        maxPath(bt.root);
        System.out.println(res);

	}

}
