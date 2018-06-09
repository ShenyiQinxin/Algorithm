

public ReversingALinkedList{
	public static LinkedListNode reverse(LinkedListNode headOfList){
		LinkedListNode currentNode = headOfList;
		LinkedListNode previousNode = null;
		LinkedListNode nextNode = null;
		
		while(currentNode != null){
			//copy the pointer currentNode.next to nextNode
			nextNode = currentNode.next;
			//save previousNode in currentNode.next
			currentNode.next = previousNode;
			//save currentNode in previousNode
			previousNode = currentNode;
			//save nextNode in currentNode
			currentNode = nextNode;
		}
		return previousNode;
	}//end method 
}