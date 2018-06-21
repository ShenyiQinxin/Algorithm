

public thirtyFour{
//arrayString
	public static List<Meeting> mergeRanges(List<Meeting> meetings){
		//sort meetings
		//merge sortedMeetings
		for(Meeting currentMeeting: sortedMeetings){
			Meeting lastMeeting = mergedMeetings.get(size-1);
			if(lastMeeting.endTime >= currentMeeting.startTime){
				//there is an overlap
				lastMeeting.endTime(max(lastMeeting.endTime,currentMeeting.endTime));
			} else {
				//no overlap, hence add the next/current meeting
				mergedMeeting.add(currentMeeting);
			}
		}
		return mergedMeetings;
	}


	public static int[] mergeArrays(int[] myArray, int[] alicesArray){
		//create a mergedArray, when index is still within the range, 
		//keep adding elements from myArray n alicesArray
		//compare 2 elements from 2 arrays
		//if 1 array is exhausted , and the other is not, then just add the non-exhausted one
		while(currentIndexMerged<length){
			if(!myArrayExhausted &&
				(isAlicesArrayExhausted ||
			(myArray[currentIndexMine]<alicesArray[currentIndexAlices]))){
				mergedArray[currentIndexMerged]=myArray[currentIndexMine];
				currentIndexMine++;
			} else {
				mergedArray[currentIndexMerged]=alicesArray[currentIndexAlices];
				currentIndexAlices++;
			}
			currentIndexMerged++;
		}
		return mergedArray;
	}

	public static void reverseInPlace(char[] arrayOfChar){
		while(left< right){
			swap(left, right);
			left++;
			right--;
		}
	
	}

	public ReverseWords{

		public static void reverseWords(char[] message){
			reverseCharacters(message, 0, length-1);
			for(int i=0; i<=message.length; i++){
				if(i==message.length || message[i]==' '){
					reverseCharacters(message, currentWordIndex, i-1);
					currentWordIndex = i+1;
				}
			}
		}
	
		private static void reverseCharacters(char[] message, int l, int r){
			
		}
		
	}

	public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffleDeck){
		for(int card: shuffleDeck){
			//every card in the shuffleDeck must be either from half1 or half2
			if(half1Index < half1.length && card == half1[half1Index]){
				half1Index++;
			} else if(half2Index <half2.length && card == half2[half2Index]){
				half2Index++;
			} else {
				return false;
			}
		}
		return true;
	}
//bitManipulation
	public static int findUniqueDeliveryId(int[] deliveryIds) {
		//0 ^ N = N
		//N ^ N = 0
		//non-unique deliveryId will be cancelled out
		int uniqueDeliveryId = 0;
		for(int deliveryId : deliveryIds){
			uniqueDeliveryId ^= deliveryId;
		}
		return uniqueDeliveryId;
	}

//dynamicProgramming
	public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity){
		//create an array of maxValuesAtCapacities, capacities are from 0 to weightCapacity
		//for each capacity, get the currentMaxValue
		//currentMaxValue is calculated by trying over cakeTypes
		for(CakeType cakeType: cakeTypes){
			if(cakeType.weight <=currentCapacity){
				//each cake value is added on top of the maxValue At a Capacity before 
				//this cake weight
				long maxValueUsingCake = cake.value +
					maxValueAtCapacities[currentCapacity-cakeType.weight];
				//currentMaxValue is from another cakeType, 
				//maxValueUsingCake is from the current cake tring
				currentMaxValue = max(maxValueUsingCake, currentMaxValue);
			}
		}
		maxValueAtCapacities[currentCapacity] = currentMaxValue;
		return maxValuesAtCapacities[weightCapacity];
	}

	public static int fib(int n){
		//0th prePrev is 0
		//1st prev is 1
		//2nd current initialized
		//start from 2nd to nth 
		//the addtion of 0th and 1st is the 2nd
		//thus nth fib number could be calculated
		for(int i=2; i<=n; i++){
			current = prev+prevPrev;
			prevPrev = prev;
			prev = current;
		}
		return current;
	}
	
	public static int fibRecursive(int n){
		if(n==0 || n==1){
			return n;
		}
		return fibRecursive(n-1)+fibRecursive(n-2);
	}

	public static Set<String> getPermutations(String inputString){
		//the base case is when length is 1, return the inputString 
		// extract the string without the last char and the lastChar
		//get a set of permutations of allCharsExceptLast
		for(String each: permutationsOfAllCharsExceptLast){
			for(int i=0; i<=length; i++){
				//from the index 0 to index length-1, length
				String permutation = each.substring(0, i)+lastChar+each.substring(i);
				permutations.add(permutation);
			}
		}
		return permutations;
	}
//generalProgramming
	private static RangeOverlap findRangeOverlap(int point1, int length1, 
	int point2, int length2) {
		//get the overlap startPoint and range length
		int highestStartPoint = max(point1, point2);
		int lowestEndPoint = min(point1+length1, point2+length2);
		//when highestStartPoint>=lowestEndPoint, then no overlap
		int overlapLength = lowestEndPoint - highestStartPoint;
		return new RangeOverlap(highestStartPoint, overlapLength);
	}
	public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {
		//find the overlap ranges of x and y
		RangeOverlap xOverlap = findRangeOverlap(rect1.getLeftX(), rect1.getWith(),
			rect2.getLeftX(), rect2.getWith());
		RangeOverlap yOverlap == findRangeOverlap(rect1.getBottomY(), rect1.getHeight(),
			rect2.getBottomY(), rect2.getHeight());
		return new Rectangle(xOverlap.getStartPoint(), yOverlap.getStartPoint(),
			xOverlap.getLength(), yOverlap.getLength());
	}

	private static class TempTracker {
		private int[] occurrences = new int[111];
		private int maxOccurrences;
		private int mode;
		
		private int numberOfReadings;
		private long totalSum;
		private double mean;
		
		private int minTemp = Integer.MAX_VALUE;
		private int maxTemp = Integer.MIN_VALUE;
		
		public void insert(int temperature){
			//mode
			occurrences[temperature]++;
			if(occurrences[temperature]>maxOccurrences){
				mode = temperature;
				maxOccurrences = occurrences[temperature];
			}
			//mean
			numberOfReadings++;
			totalSum +=temperature;
			mean = (double) totalSum/numberOfReadings;
			//min max
			minTemp = min(minTemp, temperature);
			maxTemp = max(maxTemp, temperature);
		}
		
		public int getMax(){
			return maxTemp;
		}
		
		public int getMin(){
			return minTemp;
		}
		
		public int getMean(){
			return mean;
		}
		
		public int getMode(){
			return mode;
		}
		
	}
//greedyAlgorithms
	public static int getMaxProfit(int[] stockPrices){
		//track minPrice and maxProfit
		for(int i=1; i<stockPrices.length; i++){
			int currentPrice = stockPrices[i];
			int currentProfit = currentPrice - minPrice;
			maxProfit = max(maxProfit, currentProfit);
			minPrice = min(minPrice, currentPrice);
		}
		return maxProfit;
	}

	public static int highestProductOf3(int[] arrayOfInts){
		//meantain highest, lowest, highestProductOf3, highestProductOf2, lowestProductOf2
		for(int i=2; i<arrayOfInts.length; i++){
			int current = arrayOfInts[i];
		}
		return highestProductOf3;
	}

	public InplaceShuffle{
		getRandom(floor, ceiling);
		
		shuffle(int[] theArray){
			//get random index from i to the end of theArray
			int randomChoiceIndex = getRandom(i, theArray.length-1);
			//if the randomeChoiceIndex is not index i, then swap it to index i
		}
	}

	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray){
		//for each index i
		//first pass, muliply all elements before  i
		for(int i=0; i<intArray.length; i++){
			productsOfAllIntsExceptAtIndex[i] = productSoFar;
			productSoFar *= intArray[i];
		}
		productSoFar = 1;
		//2nd pass, muliply all elements after  i
		for(int i=intArray.length-1; i>=0; i--){
			productsOfAllIntsExceptAtIndex[i] *= productSoFar;
			productSoFar *= intArray[i];
		}
		return productsOfAllIntsExceptAtIndex;
	}

//hashingHashtable
	public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength){
		//for each firstMovieLength, get the matchingSecondMovieLength 
		//if the 2nd movie is already in the movieLengthsSeen Set, then it is possible 
		//of watching 2 full movies duing flight
		//if the 2nd movie is not in the set, then add it in for next try
		for(int 1st: movieLength){
			int match2nd = flightLength - 1st;
			if(movieLengthSeen.contains(match2nd)){
				return true;
			}
			movieLengthSeen.add(1st);
		}
		return false;
	}

	public static boolean hasPalindromePermutation(String theString){
		//if there are repeated characters, and only one unique character, then
		//theString is a palindrom permutation
		for(char c: theString.toCharArray){
			if(unpairedCharacters.contains(c)){
				unpairedCharacters.remove(c);
			} else {
				unpairedCharacters.add(c);
			}
		}
		return unpairedCharacters.size() <=1;
	}

	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore){
		//scores as indexes, counts as values
		int[] scoreCounts = new int[highestPossibleScore+1];
		//scores are natually sorted by indexes from descendently
		for(int score = highestPossibleScore; score>=0; score--){
			int count = scoreCounts[score];
			for(int occurence: count){
				sortedScore[currentSortedIndex] = score;
				currentSortedIndex++;
			}
		}
		
		
		return sortedScores;
	}

//linkedList
	public class LinkedListNode {
		public int value;
		public LinkedListNode next;
		public LinkedListNode(int value){
			this.value = value;
		}
	}
	public static boolean containsCycle(LinkedListNode firstNode){
		//slowRnner and fastRunner start from firstNode
		while(fastRunner != null && fastRunner.next != null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if(fastRunner == slowRunner){
				//when 2 runners reach to the same position
				return true;
			}
		}
		return false;
	}

	public static void deleteNode(LinkedListNode nodeToDelete){
		if(nodeToDelete.next != null){
			//move nodeToDelete.next to replace nodeToDelete
			nodeToDelete.value = nodeToDelete.next.value;
			nodeToDelete.next = nodeToDelete.next.next;
		}
	}
	
	
	public static LinkedListNode kthToLastNode(int k, LinkedListNode head){
		//get the length of LinkedList
		//move currentNode to the last kth
		currentNode = head;
		for(int i=0; i<listLength-k; i++){
			currentNode = currentNode.next;
		}
		return currentNode;//return the last kth element
	}

	public static LinkedListNode reverse(LinkedListNode headOfList){
		//rotate currentNode, previousNode, and nextNode
		while(currentNode != null){
			//assign nextNode as currentNode.next
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			peviousNode = currentNode;
			currentNode = nextNode;
		}
		//return the head of this linkedlist
		return previousNode;
	}

//otherMath
	public static boolean binarySearch(int target, int[] nums) {
		//floorIndex and ceilingIndex are the 2 ends of the nums array: -1 and nums.length
		while(floorIndex +1<ceilingIndex){
			int guessIndex = floorIndex + (ceilingIndex-floorIndex)/2;
			int guessValue = nums[guessIndex];
			if(guessValue == target){
				return true;
			} 
			if(guessValue > target){
				ceilingIndex = guessIndex;
			} else {
				floorIndex = guessIndex;
			}
		}
		return false;
	}

	public static int rand5() {
		int result = 7;
		while(result >5){
			result = rand7();
		}
		return result;
	}

	public static int findRepeat(int[] numbers) {
		int sumWithoutDuplicate = (n*n+n)/2;
		int actualSum = 0;
		for(int number: numbers){
			actualSum +=number;
		}
		return actualSum - sumWithoutDuplicate;
	}
//queueStack
	public static boolean isValid(String code){
		Map<Character, Character> openersToClosers = new HashMap<>();
		openersToClosers.put('(',')');
		openersToClosers.put('[',']');
		openersToClosers.put('{','}');
		//openers, closers, openerStack
		for(char c: code.toCharsArray()){
			if(openers.contains(c)){
				openerStack.push(c);
			} else if(closer.contains(c)){
				if(openerStack.empty()){
					return false;
				} else {
					char lastUnclosedOpener = openerStack.pop();
					if(openersToClosers.get(lastUnclosedOpener)!= c){
						return false;
					}
				}
			}
		}
		//all the openers in openerStack are poped out
		return openerStack.empty();
	}

	public class MaxStack{
		//stack, maxesStack
		void push(int item){
			stack.push(item);
			if(maxesStack.empty() || item>=maxesStack.peek()){
				maxesStack.push(item);
			}
		}
		
		int pop(){
			int item = stack.pop();
			if(item == maxesStack.peek()){
				maxesStack.pop();
			}
			return item;
		}
		
		getMax(){
			return maxesStack.peek();
		}
		
	}

	public static int getClosingParen(String sentence, int openingParenIndex){
		//given the 1st open parenthesis index, find the corresponding close parenthesis
		for(int position=openingParenIndex+1; position<sentence.length(); position++){
			char c = sentence.charAt(position);
			if(c == '('){
				//after the 1st (, there comes another (
				//so the count ++;
				openNestedParens++;
			} else if(c==')'){
				if(openNestedParens==0){
					//found the last closing parenthesis
					return position;
				} else {
					//not yet to the last closing parenthesis
					openNestedParens--;
				}
			}
		}
		
	}

	public Queue2Stacks{
		
		//inStack and outStack
		void enqueue(int item){
			inStack.push(item);
		}
		
		int dequeue(){
			if(outStack.empty()){
				while(!inStack.empty()){
					outStack.push(inStack.pop());
				}
				if(outStack.empty()){
					//...
				}
			}
			return outStack.pop();
		}
	}
//sortingSearchingLogarithms

	public static int findRepeat(int[] theArray){
		while(floor < ceiling){
			int midpoint = floor+(ceiling-floor)/2;
			//lower and upper range floors and ceilings
			int itemsInLowerRange = 0;
			for(int item:theArray){
				if(item >= lowerRangeFloor && item <=lowerRangeCeiling){
					itemsInLowerRange+=1;
				}
			}
			
			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling-lowerRangeFloor+1;
			if(itemsInLowerRange > distinctPossibleIntegersInLowerRange){
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {
				floor = upperRangeFloor;
				ceiling = lowerRangeCeiling;
			}
		}
		return floor;
	}

	public static int findRotationPoint(String[] words){
		//firstWord, floorIndex, ceilingIndex
		while(floorIndex < ceilingIndex){
			int guessIndex = floorIndex + ((ceilingIndex - floorIndex)/2);
			if(words[guessIndex].compareTo(firstWord)<0){
				//guessed word is small, maybe it is the smallest, hence need to be the ceiling
				ceilingIndex = guessIndex
			} else {
				floorIndex = guessIndex;
			}
			if(floorIndex +1 == ceilingIndex){
				break;
			}
		}
		return ceilingIndex;
	}
//treeGraph
	public class BinaryTreeNode{
		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		
		public BinaryTreeNode(int value){
			this.value = value;
		}
		
		public BinaryTreeNode insertLeft(int leftValue){
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}
		
		public BinaryTreeNode insertRight(int rightValue){
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}
	
	public class BalancedBinaryTree{
		private static class NodeDepthPair{
			BinaryTreeNode node;
			int depth;
			public NodeDepthPair(BinaryTreeNode node, int depth){
				this.node = node;
				this.depth = depth;
			}
		}
		
		public static boolean isBalanced(BinaryTreeNode treeRoot){
			List<Integer> depths= new ArrayList<>();
			Stack<NodeDepthPair> nodeDepthPairs = new Stack<>();
			nodeDepthPairs.push(new NodeDepthPair(treeRoot,0));
			while(!nodeDepthPairs.empty()){
				NodeDepthPair nodeDepthPair = nodeDepthPairs.pop();
				BinaryTreeNode node =nodeDepthPair.node;
				int depth =nodeDepthPair.depth;
				if(node.left == null && node.right == null){
					if(!depths.contains(depth)){
						depths.add(depth);
						if(depths.size()>2 ||
						(depths.size() == 2 && abs(depths.get(0)-depths.get(1))>1)){
							return false;
						}
					}
				} else {
					if(node.left != null){
						nodeDepthPairs.push(new NodeDepthPair(node.left, depth+1));
					}
					if(node.right != null){
						nodeDepthPairs.push(new NodeDepthPair(node.right, depth+1));
					}
				}
			}
			return true;
		}// end isBalanced()
	}

	public class BinarySearchTreeChecker{
		private static class NodeBounds{
			BinaryTreeNode node;
			int lowerBound;
			int upperBound;
		    NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound){
				this.node = node;
				this.lowerBound = lowerBound;
				this.upperBound = upperBound;
			}
		}
	
		public static boolean isBinarySearchTree(BinaryTreeNode root){
			//nodeAndBoundsStack, push root with MIN_VALUE and MAX_VALUE bounds
			while(!nodeAndBoundsStack.empty()){
				//with node, lowerBound, upperBound
				if(node.left != null){
					//node.value becomes the new upperBound
					nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
				}
				if(node.right != null){
					//node.value becomes the new lowerBound
					nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
				}
			}
			return true;
		}
	}
	
	public static boolean isBinarySearchTreeRecursive(BinaryTreeNode root){
		
		return isBinarySearchTreeRecursive(BinaryTreeNode root, 
	Integer.MIN_VALUE, Integer.MAX_VALUE);
			
	}
	
	public static boolean isBinarySearchTreeRecursive(BinaryTreeNode root, 
	int lowerBound, int upperBound){
		//root == null , root is out of boundary
		return isBinarySearchTreeRecursive(root.left, lowerBound, root.value)
			&& isBinarySearchTreeRecursive(root.right, root.value, upperBound);
	} // end isBinarySearchTreeRecursive()
	

	public class SecondElementBST{
		private static int findLargest(BinarySTreeNode rootNode){
			BinarySTreeNode current = rootNode;
			while(current.right != null){
				current = current.right;
			}
			return current.value;
		}
		
		public static int findSecondLargest(BinarySTreeNode rootNode){
			BinarySTreeNode current = rootNode;
			while(true){
				//when there is a leftsubtree current.left != null && current.right == null
				if(current.left != null && current.right == null){
					return findLargest(current.left);
				}
				//when there is a rightsubtree with 2 leaves
				if(current.right != null && current.right.left == null &&
				current.right.right == null){
					return current.value;
				}
				//other situations
				current = current.right;
			}
		}// end findSecondLargest()
	}		
	
}//end all