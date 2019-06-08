public class IntersectionLinkedLists {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }

    /**
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA =
     * 2, skipB = 3
     * 
     * Output: Reference of the node with value = 8
     * 
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(8);
        l1.next = l11;
        l11.next = l12;
        l2.next = l21;

        ListNode head = getIntersectionNode(l1, l2);
        System.out.println(head);
    }

}