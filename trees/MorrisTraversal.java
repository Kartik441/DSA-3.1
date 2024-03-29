package trees;

// morris traversal of inorder traversal

public class MorrisTraversal {
	
	static void morrisInorder(Tnode root) 
    { 
        Tnode current, pre; 
  
        if (root == null) 
            return; 
  
        current = root; 
        while (current != null) { 
            if (current.left == null) { 
                System.out.print(current.data + " "); 
                current = current.right; 
            } 
            else { 
                /* Find the inorder predecessor of current */
                pre = current.left; 
                while (pre.right != null && pre.right != current) 
                    pre = pre.right; 
  
                /* Make current as right child of its inorder predecessor */
                // means we are visiting this node first time
                if (pre.right == null) { 
                    pre.right = current; 
                    current = current.left; 
                } 
  
                /* Revert the changes made in the 'if' part to restore the  
                    original tree i.e., fix the right child of predecessor*/
                else { 
                    pre.right = null; 
                    System.out.print(current.data + " "); 
                    current = current.right; 
                } /* End of if condition pre->right == NULL */
  
            } /* End of if condition current->left == NULL*/
  
        } /* End of while */
    } 
	
	public static void main(String args[]) 
	{
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        morrisInorder(bt.root);        
		
	}

}
