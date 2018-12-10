/**
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], 
which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
public class BinarySearchTreeQs {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		TreeNode head = getHead(nums, 0, nums.length-1);
		return head;
	}

	private static TreeNode getHead(int[] nums, int l, int r) {
		if(l > r) {
			return null;
		}
		int mid = (l+r)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = getHead(nums, l, mid-1);
		node.right = getHead(nums, mid+1, r);
		return node;
	}

	//Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// Example 1:

// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, 
		TreeNode q) {
		
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-10,-3,0,5,9};
		System.out.println(sortedArrayToBST(nums).val);
	}
	
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 