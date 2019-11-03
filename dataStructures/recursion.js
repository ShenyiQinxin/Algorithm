// 5*4!
// 3*2! - 6
// 2*1! - 2
// 1*0! - 1
// 5! = 5*4*3*2*1
function factorialRecursive(number) {
    if (number === 2) {
        return 2;
    }
    return number * factorialRecursive(number - 1);
}

function factorialIterative(number) {
    let answer = 1;
    if (number === 2) {
        answer = 2;
    }
    for (let i = 2; i <= number; i++) {
        answer = answer * i;
    }
    return answer;
}

function fibonacciIterative(n) {
    let arr = [0, 1];
    for (let i = 2; i < n + 1; i++) {
        arr.push(arr[i - 2] + arr[i - 1]);
    }
    return arr[n];
}

//0 1 1 2 3 5 8 13
function fibonacciRecursive(n) {
    if (n < 2) {
        return n;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

function reverseStringRecursive(str) {
    if (str === "") {
        return "";
    }
    return reverseStringRecursive(str.substr(1)) + str.charAt(0);
}

function reverseString(str) {
    return str.split("").reverse().join("");
}

console.log(factorialRecursive(5));
console.log(factorialIterative(5));
console.log(fibonacciIterative(7));
console.log(fibonacciRecursive(7));
console.log(reverseStringRecursive('yoyo mastery'));
console.log(reverseString("yoyo mastery"));