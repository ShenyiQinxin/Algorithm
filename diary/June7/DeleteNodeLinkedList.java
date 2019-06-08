/**
 * Input: head = [4,5,1,9], node = 5
 * 
 * Output: [4,1,9]
 * 
 * 
 */
public class DeleteNodeLinkedList {
    static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 
     * Input: 1->2->6->3->4->5->6, val = 6
     * 
     * Output: 1->2->3->4->5
     */
    static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
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
        // deleteNode(node2);
        ListNode headOfRemoved = removeElements(head, 2);
        System.out.println(head.val + " " + head.next.val + " " + head.next.next.val + " " + head.next.next.next.val);
    }
}