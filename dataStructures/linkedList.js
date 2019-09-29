'use strict';
class Node {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}
class LinkedList {
    constructor(value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    };

    addLast(value) {
        const node = new Node(value);
        this.tail.next = node;
        this.tail = node;
        this.length++;
        return this;
    }

    addFirst(value) {
        this.head = new Node(value, this.head);
        this.length++;
        return this;
    }

    addAt(value, index) {
        if (index >= this.length) {
            return this.addLast(value);
        }
        if (index === 0) {
            return this.addFirst(value);
        }

        const prev = this.getAt(index - 1);
        prev.next = new Node(value, prev.next);
        this.length++;
    }

    getAt(index) {
        if (index >= this.length) {
            return null;
        }
        if (index === 0) {
            return this.head;
        }
        let counter = 0;
        let node = this.head;
        while (counter !== index) {
            node = node.next;
            counter++;
        }
        return node;
    }

    remove(index) {
        if (index >= this.length) {
            return null;
        }
        if (index === 0) {
            this.head = this.head.next;
            return this;
        }
        const prev = this.getAt(index - 1);
        if (prev) {
            prev.next = prev.next.next;
        }

        this.length--;
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

let myLinkedList = new LinkedList(1);
myLinkedList.addLast(2);
myLinkedList.addFirst(0);
console.log(myLinkedList.length);
myLinkedList.addAt(9, 5);
myLinkedList.remove(0);
console.log(myLinkedList.listToArray());

class DoublyNode {
    constructor(value, next = null, prev = null) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    constructor(value) {
        this.head = new DoublyNode(value);
        this.tail = this.head;
        this.length = 1;
    };

    addLast(value) {
        const node = new DoublyNode(value, null, this.tail);
        this.tail.next = node;
        this.tail = node;
        this.length++;
        return this;
    }

    addFirst(value) {
        const node = new DoublyNode(value, this.head, null);
        this.head.prev = node;
        this.head = node;
        this.length++;
        return this;
    }

    addAt(value, index) {
        if (index >= this.length) {
            return this.addLast(value);
        }
        if (index === 0) {
            return this.addFirst(value);
        }


        const leader = this.getAt(index - 1);
        const holdingPointer = leader.next;
        const node = new DoublyNode(value, holdingPointer, leader);
        leader.next = node;

        this.length++;
        return this;
    }

    getAt(index) {
        if (index >= this.length) {
            return null;
        }
        if (index === 0) {
            return this.head;
        }
        let counter = 0;
        let node = this.head;
        while (counter !== index) {
            node = node.next;
            counter++;
        }
        return node;
    }

    remove(index) {
        if (index >= this.length) {
            return null;
        }
        if (index === 0) {
            this.head = this.head.next;
            return this;
        }
        const prev = this.getAt(index - 1);
        if (prev) {
            prev.next = prev.next.next;
        }

        this.length--;
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
let myDoublyLinkedList = new DoublyLinkedList(1);
myDoublyLinkedList.addLast(2);
myDoublyLinkedList.addFirst(0);
myDoublyLinkedList.addAt(0);
console.log(myDoublyLinkedList.listToArray());
// myLinkedList.addFirst(0);
// console.log(myLinkedList.length);
// myLinkedList.addAt(9, 5);
// myLinkedList.remove(0);
// console.log(myLinkedList.listToArray());