import java.util.*;
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

	/* traverse binary tree */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preorderTraverse(root, result);
		return result;
	}

	private static void preorderTraverse(TreeNode root, List<Integer> result){
		if(root == null) {
			return;
		}
		result.add(root.val);
		preorderTraverse(root.left, result);
		preorderTraverse(root.right, result);
	}

	//
// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		return Math.max(leftDepth, rightDepth)+1;
	}


	//Example 1:

	// Given the following tree [3,9,20,null,null,15,7]:

	//     3
	//    / \
	//   9  20
	//     /  \
	//    15   7
	// Return true.

	// Example 2:

	// Given the following tree [1,2,2,3,3,null,null,4,4]:

	//        1
	//       / \
	//      2   2
	//     / \
	//    3   3
	//   / \
	//  4   4
	// Return false.
	public boolean isBalanced(TreeNode root) {
		return decideIfBalanced(root).isBalanced;
	}

	private ResultType decideIfBalanced(TreeNode root){
		if(root == null) {
			return new ResultType(true, 0);
		}
		ResultType left = decideIfBalanced(root.left);
		ResultType right = decideIfBalanced(root.right);

		if(!left.isBalanced || !right.isBalanced) {
			return new ResultType(false, -1);
		}

		if(Math.abs(left.maxDepth - right.maxDepth) >1) {
			return new ResultType(false, -1);
		}
		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth)+1);
	}

    private class ResultType {
        public boolean isBalanced;
        public int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
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
		if(root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //         _______6______
		//        /              \
		//       2                8
        if(left != null && right != null) {
        	return root;
        }
        //         _______6______
		//        /              \
		//     ___2__             8
		//    /      \        
		//   0        4
        if(left != null) {
        	return left;
        }
        //         _______6______
		//        /              \
		//        2            ___8__
		//                    /      \
		//                   7        9
        if(right != null) {
        	return right;
        }

		return null;
	}

	public static TreeNode lowestCommonAncestorSolution2(TreeNode root, TreeNode p, TreeNode q) {
		while(true) {
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

	//653. Two Sum IV - Input is a BST
	public static boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		inOrderTraverse(root, list);
		int l=0, r=list.size()-1;
		while(l<r) {
			int sum = list.get(l) + list.get(r);
			if(sum == k) {
				return true;
			} else if(sum < k) {
				l++;
			} else {
				r--;
			}
		}
		return false;
	}

	private static void inOrderTraverse(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		inOrderTraverse(root.left, list);
		list.add(root.val);
		inOrderTraverse(root.right, list);
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		while(root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
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
	    /   \
	   2     2
	  / \   / \
  null  3 null 3
	*/
	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
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

	public boolean isSymmetricSolution2(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) {
			return true;
		}
		if(t1 == null || t2 == null) {
			return false;
		}
		return (t1.val == t2.val) && isMirror(t1.right, t2.left)
		&& isMirror(t1.left, t2.right);
	}

	//
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-10,-3,0,5,9};
		TreeNode root = sortedArrayToBST(nums);
		//System.out.println(sortedArrayToBST(nums).val);
		//System.out.println(preorderTraversal(root));
		//System.out.println(maxDepth(root));
		System.out.println(findTarget(root, -4));
	}
	
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 