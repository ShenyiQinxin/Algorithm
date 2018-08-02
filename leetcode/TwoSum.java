/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
import java.util.List;
import java.util.ArrayList;

public class TwoSum{
	public static int[] twoSum(int[] nums, int target){
		List<Integer> list = new ArrayList<>();
		int first = 0;
		int second = 0;
		for(; second<nums.length; second++){

			int rest = target- nums[second];

			if(!list.contains(rest)){

				list.add(nums[second]);

			} else {//set contains the rest, and nums[second] is the other one
				first = list.indexOf(rest);
				break;
			}
		}
		return new int[]{first, second};
	}

	public static void main(String[] args){
		int[] nums = {11, 2,21, 7};
		int target = 9;
		int[] result = twoSum(nums, target);
		for(int i: result){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}