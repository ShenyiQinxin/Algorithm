public class ZBSTQs{

//Q1===========================================================================
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	/*[-10,-3,0,5,9] to 
	  0
     / \
   -3   9
   /   /
 -10  5
 */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode head = getHead(nums, 0, nums.length -1);
        return head;
    }

    private TreeNode getHead(int[] nums, int l, int r) {
    	if(l > r) return null;
    	int mid = (l+r)/2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = getHead(nums, l, mid-1);
    	node.right = getHead(nums, mid+1, r);
    	return node;
    }

    //bt
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result= new ArrayList<>();
        preorderTraverse(root, result);
        return result;
    }

    private void preorderTraverse(TreeNode root, ArrayList<Integer> result){
        if(root==null) return;
        result.add(root.val);
        preorderTraverse(root.left, result);
        preorderTraverse(root.right, result);
    }

    //binar tree
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;
    }

    //binary tree
    public boolean isBalanced(TreeNode root) {
        
        return decideIfBalanced(root).isBalanced;
        
    }

    private ResultType decideIfBalanced(TreeNode root){
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

    //binar tree
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

//Q2===========================================================================
    //
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


	//653. Two Sum IV - Input is a BST
	//if there exist two elements in the BST such that their sum is equal to the given target.
    public boolean findTarget(TreeNode root, int k) {
    	List<Integer> list = new ArrayList<>();
    	inOrderTraverse(root, list);
    	int l=0, r=list.size()-1;

    	while(l<r){
    		int sum = list.get(l) + list.get(r);
    		if(sum == k) {
    			return true;
    		} else if (sum<k) {
    			l++;
    		} else {
    			r--;
    		}
    	}
    	return false;
    }

	//bt
    private void inOrderTraverse(TreeNode root, List<Integer> list) {
    	if(root == null) return;
    	inOrderTraverse(root.left, list);
    	list.add(root.val);
    	inOrderTraverse(root.right, list);
    }

    //
    public TreeNode searchBST(TreeNode root, int val) {
    	while(root != null && root.val != val) {
    		root = val < root.val ? root.left : root.right;
    	}
    	return root;
    }



	//BST
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

    //binar tree
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

	//binar tree
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
