import java.util.*;
public class GreedyQs {

	/* Input: [-2,1,-3,4,-1,2,1,-5,4],
	   Output: 6
	   [4,-1,2,1] has the largest sum = 6.
	*/
	public static int maxSubArray(int[] nums) {
		int max1 = nums[0];
		int max2 = nums[0];
		for(int i=1; i<nums.length; i++){
			max2 = Math.max(max2+nums[i], nums[i]);
			max1 = Math.max(max1, max2);
		}
		return max1;
	}

	/* Input: [7,1,5,3,6,4]
	   Output: 5
	   Explanation: Buy on day 2 (price = 1) 
	   and sell on day 5 (price = 6), profit = 6-1 = 5.
	*/
	public static int maxProfit1(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0; i<prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}

	/* Input: [7,1,5,3,6,4]
		Output: 7
		Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), 
		profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), 
        profit = 6-3 = 3.
             */
	public static int maxProfit2(int[] prices) {
		int maxProfit = 0;
		for(int i=1; i<prices.length; i++) {
			if(prices[i] > prices[i-1]) {
				maxProfit += prices[i]-prices[i-1];
			}
		}
		return maxProfit;
	}

	/* Input: [2,7,9,3,1]
		Output: 12
		Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) 
		and rob house 5 (money = 1).
		Total amount you can rob = 2 + 9 + 1 = 12.*/
	public static int rob(int[] nums) {
		int prevPrevMax = 0;
    	int prevMax = 0;
    	for(int curr : nums) {
    		int temp = prevMax;
    		prevMax = Math.max(prevPrevMax+curr, prevMax);
    		prevPrevMax = temp;
    	} 
    	return prevMax;
	}



	/* Input: [[0,30],[5,10],[15,20]]
	   Output: false
	*/
	public static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		for (int i=0; i<intervals.length-1; i++) {
			if(intervals[i].end > intervals[i+1].start) {
				return false;
			}
		}
		return true;

	}	

	/* Input: [1,2,3]
	   Output: 6
    */
    public static int maximumProduct(int[] nums) {
    	if(nums.length < 3) {
    		throw new IllegalArgumentException();
    	}
    	int highest = Math.max(nums[0], nums[1]);
    	int lowest = Math.min(nums[0], nums[1]);
    	int highestProductOf2 = nums[0]*nums[1];
    	int lowestProductOf2 = nums[0]*nums[1];
    	int highestProductOf3 = nums[0]*nums[1]*nums[2];

    	for(int i= 2; i<nums.length; i++){
    		int current = nums[i];
    		highestProductOf3 = Math.max(lowestProductOf2*current 
    			,highestProductOf2*current);
    		highestProductOf2 = Math.max(highest*current, lowest*current);
    		lowestProductOf2 = Math.min(highest*current, lowest*current);
    		highest = Math.max(highest, current);
    		lowest = Math.min(lowest, current);
    	}
    	return highestProductOf3;
    }


	public static void main(String[] args) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int[] prices = new int[]{7,1,5,3,6,4};
		int[] nums1 = new int[]{2,7,9,3,1};
		int[] nums2 = new int[]{1,2,3};
		//System.out.println(maxSubArray(nums));
		//System.out.println(maxProfit1(prices));
		//System.out.println(maxProfit2(prices));
		//System.out.println(rob(nums1));
		Interval i1 = new Interval(7, 10);
		Interval i2 = new Interval(2, 4);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[]{i1, i2};
		//System.out.println(canAttendMeetings(intervals));
		System.out.println(maximumProduct(nums2));
	}
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }