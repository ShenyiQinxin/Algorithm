import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/**
A tree is "superbalanced" 
if the difference between the depths of any two leaf nodeDepthPairs is no greater than one.

1. There are more than 2 different leaf depths
2. There are exactly 2 leaf depths and they are more than 1 apart.
*/
public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }
	
    public BinaryTreeNode insertLeft(int leftValue) {
		//give the left node a value
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}




public class BalancedBinaryTree{
	private static class NodeDepthPair{
		BinaryTreeNode node;
		int depth;
		public NodeDepthPair(BinaryTreeNode node, int depth){
			this.node = node;
			this.depth = depth;
		}
	}
	
	public static boolean isBalanced(BinaryTreeNode treeRoot){
		if(treeRoot == null){
			return true;
		}
		
		List<Integer> depths = new ArrayList<>();
		Stack<NodeDepthPair> nodeDepthPairs = new Stack<>();
		nodeDepthPairs.push(new NodeDepthPair(treeRoot, 0));
		while(!nodeDepthPairs.empty()){
			NodeDepthPair nodeDepthPair = nodeDepthPairs.pop();
			BinaryTreeNode node = nodeDepthPair.node;
			int depth = nodeDepthPair.depth;
			//leaf
			if(node.left == null && node.right == null){
				//new depth
				if(!depths.contains(depth)){
					depths.add(depth);
					//now we might have a unbalanced tree 
					//1 there are >2 depths
					//2 there are 2 depths but the difference >1
					if(depths.size()>2 || 
					(depths.size()==2 && abs(depths.get(0)-depths.get(1))>1)){
						return false;
					}
							
				}
			} else {//non leaf
				//step down to the left
				if(node.left != null){
					nodeDepthPairs.push(new NodeDepthPair(node.left, depth+1));
				}
				//step down to the right
				if(node.right != null){
					nodeDepthPairs.push(new NodeDepthPair(node.right, depth+1));
				}
			}
			
		}
		return true;
	}//end method
	
}