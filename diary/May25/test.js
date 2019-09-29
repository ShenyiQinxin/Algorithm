function closureExample(){
    let count =0;
    return () => {
        count++;
        console.log(count);
    }
}

console.log(closureExample());