public class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}
/*
LinkedListNode a = new LinkedListNode("Angel Food");
LinkedListNode b = new LinkedListNode("Bundt");
LinkedListNode c = new LinkedListNode("Cheese");
LinkedListNode d = new LinkedListNode("Devil's Food");
LinkedListNode e = new LinkedListNode("Eccles");

a.next = b;
b.next = c;
c.next = d;
d.next = e;

kthToLastNode(2, a);

// returns the node with value "Devil's Food" (the 2nd to last node)
//from the end, walk back 2 node
*/
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
		
		//traverse to the target node , the kth one from the end 50-2
		int howFarToGo = listLength-k;//48
		currentNode = head;
		for(int i=0; i<howFarToGo; i++){
			currentNode = currentNode.next;
		}
		return currentNode;
		
	}//end method
}

/*
		
		currentNode = head;
		for(int i=0; i<listLength-k; i++){
			currentNode = currentNode.next;
		}
*/
