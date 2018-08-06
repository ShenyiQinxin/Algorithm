public class TreeQs{
	
}

/**
preorder/inorder traversal binary tree ------------- O(n)
1. recursive solution
2. iterative using a stack (remember the solution)


Recursive 3 steps:
1. definition: put a btree (with root)'s' preorder traversal in the  "result"
traverse(TreeNode root, ArrayList<Integer> result){
	...
}

2. break down: result.add(root.val);
traverse(root.left, result);
traverse(root.right, result);

3. exit
if(root == null) return;



dividsion --------------------------------------- O(n)
if(root==null) return 0;
int leftDepth=maxDepth(root.left);
int rightDepth=maxDpeth(root.right);
return Math.max(leftDepth,rightDepth)+1;
*/

/**
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?

**********My thought:
deifine, preorderTraversal(TreeNode, result)
exit: root==null
steps: root, left, right

**********better solution:
List<Integer> list= new ArrayList();;

**********TakeAway:
division method : List<Integer> preorderTraversal(TreeNode root) 
recursion method: void traverse(TreeNode root,...)

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
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list= new ArrayList<>();;

        if(root == null) return list;
        List<Integer> left=preorderTraversal(root.left);
        List<Integer> right=preorderTraversal(root.right);

        list.add(root.val);
        list.add(left);
        list.add(right);
        return list;
    }
}

class Solution144 {
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	
        List<Integer> result= new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, ArrayList<Integer> result){
    	if(root==null) return;
    	result.add(root.val);
    	traverse(root.left, result);
    	traverse(root.right, result);
    }
}

/**
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

**********My thought:
root exit
left depth, right depth, max
division
**********Better solution:
non-recursive
**********TakeAway:

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
class Solution104 {
    public int maxDepth(TreeNode root) {
    	if(root==null) return 0;

    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);

    	return Math.max(left, right)+1;
    }
}

/**
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

**********My thought:
tree is balanced meaning difference of depths of left and right is <=1

**********Better solution:
ResultType(boolean isBalanced, int maxDepth)
**********TakeAway:
create a custom data type, use recursion division
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
class Solution110 {
    public boolean isBalanced(TreeNode root) {
    	
    	return decideIfBalanced(root).isBalanced;
    	
    }

    ResultType decideIfBalanced(TreeNode root){
    	if(root==null) return new ResultType(true, 0);

    	ResultType left = decideIfBalanced(root.left);
    	ResultType right = decideIfBalanced(root.right);

    	if(!left.isBalanced || !right.isBalanced){
    		return new ResultType(false, -1);
    	}

    	if(Math.abs(left.maxDepth - right.maxDepth) > 1) {
    		return new ResultType(false, -1);
    	}

    	return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    	
    }

	private class ResultType {
    	public boolean isBalanced;
    	public int maxDepth;
    	public ResultType(boolean isBalanced, int maxDepth) {
        	this.isBalanced = isBalanced;
        	this.maxDepth = maxDepth;
    	}
	}


}

/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.

Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the binary tree.

**********My thought:
recursion?

**********Better solution:

recursion, division
**********TakeAway:
decide right and left
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
class Solution236LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
        	return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left !=null && right !=null) {
			return root;
		}

		if(left != null) {
			return left;
		}

		if(right != null){
			return right;
		}

		return null;
    }
}

/**
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.

Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the BST.


**********My thought:
recursion, division, left < mid < right

**********Better solution:
iterative,
p.val >= root.val or p.val<=root.val
root=root.right
root=root.left

**********TakeAway:
BST is ordered

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
class Solution235LowestCommonAncestorofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val <= root.val && q.val >= root.val ||
                q.val <= root.val && p.val >= root.val) {
                return root;
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
               root = root.left; 
            }

        }
       
    }
}
