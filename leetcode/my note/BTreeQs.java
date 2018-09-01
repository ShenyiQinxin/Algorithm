public class BTreeQs {

}


/*
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    	if(root = null) return 0;
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	return Math.max(left, right)+1;
    }
}
/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
    	return decideIfBalanced(root).isBalanced;
    }

    private ResultType decideIfBalanced(TreeNode root){
    	if(root == null) return new ResultType(true, 0);
    	 ResultType left = decideIfBalanced(root.left);
    	 ResultType right = decideIfBalanced(root.right);
    	 if(!left.isBalanced || !right.isBalanced) {
    	 	return new ResultType(false, -1);
    	 }
    	 if(Math.abs(left.maxDepth-right.maxDepth)>1) {
    	 	return new ResultType(false, -1);
    	 }
    	 return new ResultType(true, Math.max(left.maxDepth, right.maxDepth)+1);
    }

    private class ResultType{
    	public boolean isBalanced;
    	public int maxDepth;
    	public ResultType(boolean isBalanced, int maxDepth) {
        	this.isBalanced = isBalanced;
        	this.maxDepth = maxDepth;
    	}
    }
}
/*
226. Invert Binary Tree
DescriptionHintsSubmissionsDiscussSolution
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	//continue do this while queue is not empty
    	while(!queue.isEmpty()) {
    		TreeNode current = queue.poll();
    		//swap left and right
    		TreeNode temp = current.left;
    		current.left = current.right;
    		current.right = temp;
    		//add left to the queue if left node is not null
    		if(current.left != null) queue.add(current.left);
    		if(current.right != null) queue.add(current.right);
    	}
    	return root;
    }
}
/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
public boolean isSymmetric(TreeNode root) {
	return isMirror(root, root);
}

private boolean isMirror(TreeNode t1, TreeNode t2){
	if(t1==null && t2==null) return true;
	if(t1==null || t2==null) return false;
	return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
}
}

class Solution {
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);//for left
		q.add(root);//for right
		while(!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if(t1 == null && t2 == null) continue;
			if(t1 == null || t2 == null) return false;
			if(t1.val != t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
}
