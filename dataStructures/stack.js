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
        if (!this.top) {
            return null;
        }
        //
        if (this.length === 1) {
            this.bottom = null;
        }
        const holding = this.top;
        this.top = this.top.next;
        this.length--;
        return holding;
    }
}

let myStack = new Stack();
myStack.push(0);
myStack.push(1);
myStack.push(2);
myStack.pop();
console.log(myStack);

class StackByArray {
    constructor() {
        this.array = [];
    }
    peek() {
        return this.array[this.array.length - 1];
    }

    push(value) {
        this.array.push(value);
        return this;
    }

    pop() {
        this.array.pop();
        return this;
    }
}