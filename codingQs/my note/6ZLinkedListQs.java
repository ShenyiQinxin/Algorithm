public class ZLinkedListQs {

//Q1===========================================================================
    public ListNode middleNode(ListNode head) {
           ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    

    //if node==head, then it is to reverse linked list
    private ListNode reverseNode(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode middle = middleNode(head); //middle node
        //the right node to the middle, after reverse the right half
        ListNode rNode = reverseNode(middle);
        
        while(rNode!=null){
            if(head.val != rNode.val){
                return false;
            }
            head = head.next;
            rNode = rNode.next;
        }
        return true;
    }

//Q2==========================================================================
    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        
    }

    //return the head of the list
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) {
            head=head.next;
        }
        ListNode curr = head;
        while(curr!=null && curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
        
    }

//Q3==========================================================================
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode prehead = new ListNode(-1);
    	ListNode prev = prehead;
    	while(l1 !=null && l2!= null) {
    		if(l1.val <=l2.val) {
    			pre.next = l1;
    			l1 = l1.next;
    		} else {
    			prev.next = l2;
    			l2 = l2.next;
    		}
    	}
    	prev.next = l1==null ? l2 : l1;
    	return prehead.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB) return null;
        ListNode a = headA, b = headB;
        while(a !=b) {
        	a = (a!=null) ? a.next : headB;
        	b = (b != null) ? b.next : headA;
        }
    }

    
}