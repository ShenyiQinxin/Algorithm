class TwoSum {
    //
    static int[] twoSum(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l<r) {
            int sum=nums[l]+nums[r];
            if(sum==target){
                return new int[]{l+1, r+1};
            } else if(sum>target){
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}