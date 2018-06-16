
//the largest element is simply the "rightmost" element.
public class SecondElementBST{
	
	private static int findLargest(BinarySTreeNode rootNode){
		BinarySTreeNode current = rootNode;
		//in BST, the largest value is the "rightmost" one
		while(current.right != null){
			current = current.right;
		}
		return current.value;
	}//end method
	
	public static int findSecondLargest(BinarySTreeNode rootNode){
		if(rootNode == null || (rootNode.left == null && rootNode.right == null)){
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		}
		BinarySTreeNode current = rootNode;
		
		while(true){
			//there is a left subtree, the right one is a leaf
			if(current.left != null && current.right == null){
				//the largest of the left subtree
				return findLargest(current.left);
			}
			//there is a right subtree with 2 leaves
			if(current.right != null &&
				current.right.left == null &&
			current.right.right == null){
				return current.value;
			}
			//if there is a right subtree with more than 2 leaves, continue find
			current = current.right;
		}
		
	}//end method
	
}