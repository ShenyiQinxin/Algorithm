'use strict';

class Array {
    constructor() {
        this.length = 0;
        this.data = {};
    }

    get(index) {
        return this.data[index];
    }

    push(item) {
        this.data[this.length] = item;
        this.length++;
        return this.data;
    }

    pop() {
        const lastItem = this.data[this.length - 1];
        delete this.data[this.length - 1];
        this.length--;
        return lastItem;
    }

    deleteAt(index) {
        const item = this.data[index];
        this.shiftItems[index];
        return item;
    }

    shiftItems(index) {
        for (let i = index; i < this.length; i++) {
            this.data[i] = this.data[i + 1];
        }
        delete this.data[this.length - 1];
        this.length--;
    }
}

const myArray = new Array();
myArray.push('hi');
myArray.push('you');
myArray.push('!');
myArray.pop();
myArray.deleteAt(0);
myArray.push('are');
myArray.push('nice');
myArray.shiftItems(0);
console.log(myArray);

function reverse1(str) {
    if (!str || str.length < 2 || typeof str != 'string') {
        return;
    }
    const backwards = [];
    for (let i = str.length - 1; i >= 0; i--) {
        backwards.push(str[i]);
    }
    return backwards.join('');
}

function reverse2(str) {
    return str.split('').reverse().join('');
}

function reverse3(str) {
    return [...str].reverse().join('');
}

function mergeSortedArrays(a1, a2) {
    const merged = [];
    let item1 = a1[0];
    let item2 = a2[0];
    let i = 1;
    let j = 1;
    if (a1.length === 0) {
        return a2;
    }

    if (a2.length === 0) {
        return a1;
    }

    while (item1 || item2) {
        if (!item2 || item1 < item2) {
            merged.push(item1);
            item1 = a1[i];
            i++;
        } else {
            merged.push(item2);
            item2 = a2[j];
            j++;
        }
    }
    return merged;
}

console.log(mergeSortedArrays([0, 3, 4, 31], [4, 6, 30]));