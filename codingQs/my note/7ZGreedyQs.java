public class ZGreedyQs {

//Q1===========================================================================
    public int maxSubArray(int[] nums) {
    	int maxSoFar = nums[0];
    	int maxEndingHere = nums[0];
    	for(int i=1; i<nums.length; i++){

    		maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);;
    		maxSoFar = Math.max(maxSoFar, maxEndingHere);
    	}
    	return maxSoFar;
    }

    //ONE
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
        	minPrice = Math.min(minPrice, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        }
        return maxProfit;
    }

	//MANY
    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
    	for (int i=1; i<prices.length; i++) {
    		if(prices[i] > prices[i-1]) {
    			maxProfit += prices[i] - prices[i-1];
    		}
    	}
    	return maxProfit;
    }

	//
    public int rob(int[] nums) {
    	int prevPrevMax = 0;
    	int prevMax = 0;
    	//prevMax and prePrevMax swap
    	//prevPrevMax+curr becomes preMax, when prePrevMax+curr larger than  prevMax
    	//preMax becomes prePrevMax when try the next curr 
    	for (int curr : nums) {
    		int temp = prevMax;
    		prevMax = Math.max(prevPrevMax+curr, prevMax);
    		prevPrevMax = temp;
    	}
    	return prevMax;
    }

	//
    public int maximumProduct(int[] nums) {
    	if(nums.length<3) throw new IllegalArgumentException();
    	
	    int highest = Math.max(nums[0], nums[1]);
	    int lowest = Math.min(nums[0], nums[1]);
	    int highestProductOf2 = nums[0]*nums[1];
	    int lowestProductOf2 = nums[0]*nums[1]; 
	    int highestProductOf3 = nums[0]*nums[1]*nums[2];

        for (int i = 2; i < nums.length; i++) {
        	int current = nums[i];
        	highestProductOf3 = Math.max( Math.max(highestProductOf2 , highestProductOf2*current),
        	 lowestProductOf2*current);
        	highestProductOf2 = Math.max(Math.min(highestProductOf2 ,highest* current), lowest*current);
        	lowestProductOf2 = Math.min(Math.min(lowestProductOf2 ,highest*current), lowest*current);
        	highest = Math.max(highest, current);
        	lowest = Math.min(current, lowest);
        }
        return highestProductOf3;
 	}

 	//
    public boolean canAttendMeetings(Interval[] intervals) {
    	Arrays.sort(intervals, new Comparator<Interval>() {
    		public int compare(Interval i1, Interval i2) {
    			return i1.start - i2.start;
    		}
    	});

    	for (int i=0; i<intervals.length-1; i++) {
    		if(intervals[i].end > integers[i+1].start) return false;
    	}
    	return true;
    }

}

