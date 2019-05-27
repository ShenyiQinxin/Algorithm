var removeDuplicates = function(nums) {
    nums.splice(0, nums.length, ...(new Set(nums)));
    //replace all nums at index 0 by Set(nums)
};
console.log(removeDuplicates([0,0,1,1,1,2,2,3,3,4]));