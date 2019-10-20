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
        let tmp = array[i];
        for (let j = i + 1; j < length; j++) {
            if (array[j] < array[i]) {
                min = j;
            }
        }
        array[i] = array[min];
        array[min] = tmp;
    }
    return array;
}


bubbleSort(numbers);
console.log(numbers);