public class LinkedListQs {
	
}

/*
141. Linked List Cycle
DescriptionHintsSubmissionsDiscussSolution
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
**********My thoughts

**********Better solution

**********Takeaways
*/

/*
876. Middle of the Linked List
DescriptionHintsSubmissionsDiscussSolution
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Note:

The number of nodes in the given list will be between 1 and 100.
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
           ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/*
206. Reverse Linked List
DescriptionHintsSubmissionsDiscussSolution
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
        
     
    }
}

/*
234. Palindrome Linked List
DescriptionHintsSubmissionsDiscussSolution
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode middle = findMiddle(head); //middle node
        ListNode rNode = reverseNode(middle);//the right node to the middle, after reverse the right half
        
        while(rNode!=null){
            if(head.val != rNode.val){
                return false;
            }
            head = head.next;
            rNode = rNode.next;
        }
        return true;
    }
    
    private ListNode findMiddle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
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
    
}

/*
237. Delete Node in a Linked List
DescriptionHintsSubmissionsDiscussSolution
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

    4 -> 5 -> 1 -> 9
Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list
             should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list
             should become 4 -> 5 -> 9 after calling your function.
Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        
    }
}

/*
203. Remove Linked List Elements
DescriptionHintsSubmissionsDiscussSolution
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}


/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
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
}
/*
160. Intersection of Two Linked Lists
DescriptionHintsSubmissionsDiscussSolution
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB) return null;
        ListNode a = headA, b = headB;
        while(a !=b) {
        	a = (a!=null) ? a.next : headB;
        	b = (b != null) ? b.next : headA;
        }
    }
}
/*
**********My thoughts

**********Better solution

**********Takeaways
*/

/*
**********My thoughts

**********Better solution

**********Takeaways
*/

/*
**********My thoughts

**********Better solution

**********Takeaways
*/

/*
**********My thoughts

**********Better solution

**********Takeaways
*/