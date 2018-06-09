import java.util.NoSuchElementException;
import java.util.Stack;

//implement a queue using in stack and out stack
public Queue2Stacks{
	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();
	
	public void enqueue(int item){
		inStack.push(item);
	}
	
	public int dequeue(){
		
		if(outStack.empty()){
			//push all the inStack items into outStack
			while(!inStack.empty()){
				outStack.push(inStack.pop());
			}
			//when outStack gets to be empty
			if(outStack.empty()){
				throw new NoSuchElementException("Can't dequeue from empty queue!");
			}
		}
		//the 1st in-item is on the top of outStack to be poped out
		return outStack.pop();
	}//end dequeue
}