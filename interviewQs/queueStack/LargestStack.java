import java.util.Stack;

public class MaxStack{
	//for all items
	private Stack<Integer> stack = new Stack<>();
	//for max items
	private Stack<Integer> maxesStack = new Stack<>();
	
	
	public void push(int item){
		//all items go into stack
		stack.push(item);
		//larger item go into maxesStack
		if(maxesStack.empty() || item >= maxesStack.peek()){
			maxesStack.push(item);
		}
	}
	
	public int pop(){
		int item = stack.pop();
		//if the item is the max item which is stored in maxesStack, pop it out
		if(item == maxesStack.peek()){
			maxesStack.pop();
		}
		return item;
	}
	
	//maxesStack is for the max item
	public int getMax(){
		return maxesStack.peek();
	}
	
}