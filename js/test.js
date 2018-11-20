function largestOfFour1(mainArray) {
  return mainArray.map(function(subArray) {
    return Math.max.apply(null, subArray);
  });
}

function largestOfFour2(mainArray) {
  return mainArray.map(function (subArray){
    return subArray.reduce(function (previousLargestNumber, currentLargestNumber) {
      return (currentLargestNumber > previousLargestNumber) ? currentLargestNumber : previousLargestNumber;
    }, 0);
  });
}

//console.log(largestOfFour2([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]]));
const numbers = [1,2,3,-4];
const items = {
	orders: numbers,
	names: 'container'
}
console.log(items.orders);
function largestNumber(items) {
	const numbers = items.orders;
	return Math.max(...numbers);
}
//console.log(largestNumber(numbers));