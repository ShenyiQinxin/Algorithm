var fib = function (n) {
    let arr = [0, 1];
    for (let i = 2; i <= n; i++) {
        arr.push(arr[i - 2] + arr[i - 1]);
    }
    return arr;
};

//console.log(fib(6));

var fibRecursive= function(n) {
    if(n<=1){
        return n;
    }
    return fibRecursive(n-1)+fibRecursive(n-2);

}
for(let i=1; i<7; i++){
    console.log(fibRecursive(i));
}

