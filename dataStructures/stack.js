class Node {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}

class Stack {
    constructor() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }
    peek() {
        return this.top;
    }

    push(value) {
        const node = new Node(value);

        if (this.length === 0) {
            this.bottom = node;
            this.top = node;
        } else {
            const prevTop = this.top;

            this.top = node;
            this.top.next = prevTop;
        }

        this.length++;

    }

    pop() {

    }

    listToArray() {
        const array = [];
        let node = this.head;
        while (node != null) {
            array.push(node.value);
            node = node.next;
        }
        return array;
    }
}

let myStack = new Stack();
myStack.push(0);
myStack.push(1);
myStack.push(2);
console.log(myStack)
console.log(myStack.listToArray());