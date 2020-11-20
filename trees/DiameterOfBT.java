package trees;

class Pair<T, V>{
	public T first;             // for height
	public V second;            // for diameter
}

public class DiameterOfBT {
	// Basic approach    (O(n*h))
	static int diameter(Tnode root)
	{
		if(root == null)
			return 0;           
		
		int option1 = height(root.left)+height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		return Math.max(option1, Math.max(option2, option3));
	}
	
	static int height(Tnode root)
	{
		if(root == null)
			return 0;
		
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	// Better Approach
	
	// O(N) solution
	
	static Pair<Integer, Integer> heightDiameter(Tnode root)
	{
		if(root == null)
		{
			Pair<Integer, Integer> output= new Pair();
			output.first = 0;
			output.second = 0;
			return output;
		}
		
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		
		Pair<Integer, Integer> output= new Pair();
		output.first = Math.max(lo.first, ro.first) + 1;     // storing height
        int option1 = lo.first + ro.first;       // here we are counting edges(to count nodes add 1 in this i.e)
        // int option1 = lo.first + ro.first + 1;
        
        int option2 = lo.second;   // max diameter from left side
        int option3 = ro.second;   // max diameter from right side
        
        output.second = Math.max(option1, Math.max(option2, option3));
        
        return output;
		
	}

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        System.out.println(diameter(bt.root));
		System.out.println("Diameter"+heightDiameter(bt.root).second);
		System.out.println("Height"+heightDiameter(bt.root).first);

	}

}

// Another Method
//Diameter of tree can be calculated only using the height function, because the diameter of a tree is nothing but
//maximum value of (leftHeight + RightHeight +1) for each node
