public class LinkedListQs {
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode reverseNode(ListNode node){
		if(node == null || node.next == null){
            return node;
        }
        
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null) {
        	ListNode temp = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = temp;
        }
        return prev;
	}

	// Example 1:

	// Input: 1->2
	// Output: false
	// Example 2:

	// Input: 1->2->2->1
	// Output: true
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		// 1, 2, 3, 4, 5  -> 3
		ListNode middle = middleNode(head);
		// reverse the right half
		// 1, 2, 5, 4, 3  -> the right half is reversed
		ListNode rNode = reverseNode(middle);

		//compare the left half and the right half
		// 1 n 3, 2 n 4, 5
		while(rNode != null) {
			if(head.val != rNode.val) {
				return false;
			}
			head = head.next;
			rNode = rNode.next;
		}
		return true;
	}

	//Input: head = [4,5,1,9], node = 1
	//Output: [4,5,9]
	public static ListNode deleteNode(ListNode node) {
		node.val = node.next.val;
		System.out.print(node.next.val+" ");
		node.next = node.next.next;
		return node.next;
	}

	//Input:  1->2->6->3->4->5->6, val = 6
	//Output: 1->2->3->4->5
	public static ListNode removeElements(ListNode head, int val) {
		//remove head
		while(head!=null && head.val==val) {
            head=head.next;
        }
        //remove curr.next
        ListNode curr = head;
        while(curr != null && curr.next != null) {
        	if(curr.next.val == val) {
        		curr.next = curr.next.next;
        	} else {
        		curr = curr.next;
        	}
        }

		return head;
	}	

	// Input: 1->2->4, 1->3->4
    // Output: 1->1->2->3->4->4
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
		}
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}

	//A:          a1 → a2
    //                  ↘
    //                    c1 → c2 → c3
    //                  ↗            
	//B:     b1 → b2 → b3
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode a = headA, b= headB;
		while(a != b) {
			a = (a!=null) ? a.next : headB;
			b = (b!=null) ? b.next : headA;
		}
		return headA;
	}
 


	private static ListNode createNodeList(int length) {
		ListNode head = new ListNode(1);
		System.out.print(head.val + " ");

		ListNode current = head;
		for(int i=2; i<length; i++) {
			ListNode newNode = new ListNode(i);
			System.out.print(newNode.val+" ");
			current.next = newNode;
			current = newNode;
		}
		System.out.println();
		return head;
	}

	public static void main(String[] args) {
		ListNode head = createNodeList(9);
		//System.out.println(middleNode(head).val);
		//System.out.println(isPalindrome(head));
		// ListNode node = deleteNode(head);
		// while(head != null) {
		// 	System.out.print(node.val+" ");
		// 	node = node.next;
		// }
		System.out.println(removeElements(head, 6).val);
	}
}

/* Definition for singly-linked list.  */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
