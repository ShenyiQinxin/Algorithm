public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}

public ContainsACycle{
	public static boolean containsCycle(LinkedListNode firstNode){
		LinkedListNode slowRunner = firstNode;
		LinkedListNode fastRunner = firstNode;
		while(fastRunner != null && fastRunner.next != null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			
			if(fastRunner == slowRunner){
				return true;
			}
		}
		return false;
	}//end method
}

/*
		while(fastRunner != null && fastRunner.next != null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			
			if(fastRunner == slowRunner){
				return true;
			}
		}
*/