public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
/*
LinkedListNode a = new LinkedListNode(1);
LinkedListNode b = new LinkedListNode(2);
LinkedListNode c = new LinkedListNode(3);

a.next = b;
b.next = c;

deleteNode(b);
*/
public DeleteANode{
	public static void deleteNode(LinkedListNode nodeToDelete){
		
		if(nodeToDelete.next != null){
			nodeToDelete.value = nodeToDelete.next.value;
			nodeToDelete.next = nodeToDelete.next.next;
		} else {
			throw new IllegalArgumentException("Can't delete the last node with this technique!");
		}
	}
}