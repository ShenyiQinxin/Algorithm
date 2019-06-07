class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Input: 1->2->3->4->5->NULL
 *
 * Output: 5->4->3->2->1->NULL
 *
 * pre -> current -> current.next -> next
 *
 *
 */
public class ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseList(head);
        System.out.println(node.val + " " + node.next.val + " " + node.next.next.val + " " + node.next.next.next.val
                + " " + node.next.next.next.next.val + " ");
    }
}
