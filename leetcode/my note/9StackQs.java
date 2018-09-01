public class StackQs{
	
}

/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
**********My thoughts

**********Better solution

**********Takeaways
*/
class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
	 	stack = new Stack<>();
	 	minStack = new Stack<>();
	 }

	public void push(int x) {
	 	stack.push(x);
	 	if(minStack.empty() || x<=minStack.peek()) {
	 		minStack.push(x);
	 	}
	 }

	public void pop() {
	  	if(stack.empty()) throw new IllegalArgumentException();
	  	int item = stack.pop();
	  	if(item == minStack.peek()) {
	  		minStack.pop();
	  	}
	  }
	public int top() {
		return stack.peek();
	}

	public int getMin() {
		retun minStack.peek();
	}
}
/*
**********My thoughts

**********Better solution

**********Takeaways
*/

