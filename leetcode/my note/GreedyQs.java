public class GreedyQs {
	
}

/*
121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were ONLY permitted to complete at most ONE transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
**********My thoughts
maintain the minPrice and maxProfit
**********Better solution

**********Takeaways
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
        	minPrice = Math.min(minPrice, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        }
        return maxProfit;
    }
}
/*
122. Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete 
as many transactions as you like (i.e., buy one and sell one share of the stock MULTIPLE times).

Note: You may not engage in multiple transactions at the same time 
(i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
    	for (int i=1; i<prices.length; i++) {
    		if(prices[i] > prices[i-1]) {
    			maxProfit += prices[i] - prices[i-1];
    		}
    	}
    	return maxProfit;
    }
}
/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int rob(int[] nums) {
    	int prevPrevMax = 0;
    	int prevMax = 0;
    	for (int curr : nums) {
    		int temp = prevMax;
    		prevMax = Math.max(prevPrevMax+curr, prevMax);
    		prevPrevMax = temp;
    	}
    	return prevMax;
    }
}
/*
252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could 
**attend all meetings**.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
**********My thoughts

**********Better solution

**********Takeaways
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
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

/*
628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int maximumProduct(int[] nums) {
    	if(nums.length<3) throw new IllegalArgumentException();
    	
	    int highest = Math.max(nums[0], nums[1]);
	    int lowest;
	    int highestProductOf2;
	    int lowestProductOf2;
	    int highestProductOf3;

        for (int i = 2; i < nums.length; i++) {
        	int current = nums[i];
        	highestProductOf3;
        	highestProductOf2;
        	lowestProductOf2;
        	highest;
        	lowest;
        }
        return highestProductOf3;
 	}

}
