

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