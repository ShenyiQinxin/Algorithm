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

	public static ListNode deleteNode(ListNode node) {
		node.val = node.next.val;
		System.out.print(node.next.val+" ");
		node.next = node.next.next;
		return node.next;
	}

	public ListNode removeElements(ListNode head, int val) {
		while(head!=null && head.val==val) {
            head=head.next;
        }

		return null;
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
		ListNode node = deleteNode(head);
		while(head != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
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
