import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public BracesValidator{
	public static boolean isValid(String code){
		Map<Character, Character> openersToClosers = new HashMap<>();
		openersToClosers.put('(',')');
		openersToClosers.put('[',']');
		openersToClosers.put('{','}');
		Set<Character> openers = openersToClosers.keySet();
		Set<Character> closers = new HashSet<>(openersToClosers.values());
		Stack<Character> openerStack =new Stack<>();
		for(char c: code.toCharArray()){
			//If we see an opener, we push it onto the stack
			if(openers.contains(c)){
				openerStack.push(c);
				//If we see a closer,
			} else if(closer.contains(c)){
				if(openerStack.empty()){
					return false;
				} else {
					//check to see if it is the closer for the opener at the top of the stack
					char lastUnclosedOpener = openerStack.pop();
					if(openersToClosers.get(lastUnclosedOpener) != c){
						return false;
					}
				}
			}
		}//end for
		return openerStack.empty();
	}//end method
	
}