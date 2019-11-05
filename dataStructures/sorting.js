const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function bubbleSort(array) {
    const length = array.length;
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length; j++) {
            if (array[j] > array[j + 1]) {
                let tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }
}

function selectionSort(array) {
    const length = array.length;
    for (let i = 0; i < length; i++) {
        let min = i;
        let minElement = array[i];
        for (let j = i + 1; j < length; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        //swap
        array[i] = array[min];
        array[min] = minElement;
    }
    return array;
}

function insertSort(array) {
    const length = array.length;
    for (let i = 0; i < length; i++) {
        if (array[i] < array[0]) {
            array.unshift(array.splice(i, 1)[0]);//remove one element at i
        } else {
            if (array[i] < array[i - 1]) {//shift i to the left
                for (let j = 1; j < i; j++) {
                    if (array[i] >= array[j - 1] && array[i] < array[j]) {//move i to between j-1 and j
                        array.splice(j, 0, array.splice(i, 1)[0]);
                        //remove one element at i, and insert it in front of index j 
                    }
                }
            }
        }

    }
}

function mergeSort(array) {
    if (array.length === 1) {
        return array;
    }
    const length = array.length;
    const middle = Math.floor(length / 2);
    const left = array.slice(0, middle);
    const right = array.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
    const result = [];
    let l = 0;
    let r = 0;
    while (l < left.length && r < r.length) {
        if (left[l] < right[r]) {
            result.push(left[l]);
            l++;
        } else {
            result.push(right[r]);
            r++;
        }
    }
    return result.concat(left.slice(l)).concat(right.slice(r));
}

selectionSort(numbers);
console.log(numbers);