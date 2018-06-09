

public KthToLastNode{
	
	
	public static LinkedListNode kthToLastNode(int k, LinkedListNode head){
		if(k<1){
			throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
		}
		
		int listLength = 1;
		LinkedListNode currentNode = head;
		//traverse the whole list, get listLength
		while(currentNode.next != null){
			currentNode = currentNode.next;
			listLength++;
		}
		
		if(k>listLength){
			throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
		}
		
		//traverse to the target node , the kth one
		int howFarToGo = listLength-k;
		currentNode = head;
		for(int i=0; i<howFarToGo; i++){
			currentNode = currentNode.next;
		}
		return currentNode;
		
	}//end method
}