'use strict';

class HashTable {
    constructor(size) {
        this.data = new Array(size);
    }

    _hash(key) {
        let hash = 0;
        for (let i = 0; i < key.length; i++) {
            hash = (hash + key.charCodeAt(i) * i) % this.data.length;
            console.log(hash);
        }
        return hash;
    }

    set(key, value) {
        let address = this._hash(key);
        if (!this.data[address]) {
            this.data[address] = [];

        }
        const bucket = this.data[address].push([key, value]);
        console.log(this.data);
        return bucket;

    }

    get(key) {
        let address = this._hash(key);
        const found = this.data[address];
        console.log(found);
        if (found) {
            for (let i = 0; i < found.length; i++) {
                if (found[i][0] === key) {
                    return found[i][1];;
                }
            }
        }
        return found;
    }

    keys() {
        const keysArray = [];
        for (let i = 0; i < this.data.length; i++) {
            if (this.data[i]) {
                keysArray.push(this.data[i][0][0]);
            }
        }
        return keysArray;
    }
}

const myHashTable = new HashTable(50);
myHashTable.set('grapes', 10000);
myHashTable.set('apples', 10000);
myHashTable.set('oranges', 2);

console.log(myHashTable);
console.log(myHashTable.get('apples'));
console.log(myHashTable.keys());