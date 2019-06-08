
/**
 * Input: [1,2,3,4,5,6] Output: Node 4 from this list
 *
 * if there are 2 middle nodes, return the 2nd one
 *
 */
public class MiddleLinkedList {
    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        System.out.println(middleNode(head).val);
        // System.out.println(head.val + " " + head.next.val + " " + head.next.next.val
        // + " " + head.next.next.next.val
        // + " " + head.next.next.next.next.val);
    }
}
