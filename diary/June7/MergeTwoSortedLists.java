/**
 * Input: 1->2->4, 1->3->4
 * 
 * Output: 1->1->2->3->4->4
 */
class MergeTwoSortedLists {
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l21 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        l2.next = l21;

        ListNode head = mergeTwoLists(l1, l2);
        System.out.println(head.val + " " + head.next.val + " " + head.next.next.val + " " + head.next.next.next.val
                + " " + head.next.next.next.next.val);
    }
}