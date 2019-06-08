
/**
 * Input: 1->2->2->1
 * 
 * 1 2 1 2
 * 
 * Output: true
 */
public class PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = MiddleLinkedList.middleNode(head);
        ListNode rNode = ReverseLinkedList.reverseList(middle);
        while (rNode != null) {
            if (head.val != rNode.val) {
                return false;
            }
            head = head.next;
            rNode = rNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(head));
    }
}