

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