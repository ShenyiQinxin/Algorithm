/**
 * 
 * @param {*} nums [0,1,0,3,12]
 * [1,3,12,0,0]
 */
var moveZeroes = function (nums) {
    let count = 0, pos;
    //when the item of 0 is found, the position
    while (~(pos = nums.indexOf(0))) {
        count++;
        //remove 1 item at index pos, return the rest
        nums.splice(pos, 1);
    }
 nums.splice(nums.length, 0, ...((new Array(count)).fill(0)));
 return nums;
};
console.log(moveZeroes([0,1,0,3,12]));