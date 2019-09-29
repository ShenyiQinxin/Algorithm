class Node {
    constructor(data, next = null) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }

    getFist() {
        return this.head;
    }

    insertFirst(data) {
        this.head = new Node(data, this.head);
    }

    removeFist() {
        if (!this.head) {
            return;
        }
        this.head = this.head.next;
    }

    getLast() {
        let node = this.head;
        while (node) {
            if (!node.next) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //
    removeLast() {
        if (!this.head) {
            return;
        }
        if (!this.head.next) {
            this.head = null;
            return;
        }

        let prev = this.head;
        let node = this.head.next;
        while (node.next) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    //
    insertLast(data) {
        last = this.getLast();
        if (last) {
            last.next = new Node(data);
        } else {
            this.head = new Node(data);
        }
    }

    getAt(index) {
        let counter = 0;
        let node = this.head;
        while (node) {
            if (index === counter) {
                return node;
            }
            node = node.next;
            counter++;
        }
        return null;
    }

    removeAt(index) {
        if (!this.head) {
            return;
        }
        let prev = getAt(index - 1);
        if (!prev || !prev.next) {
            return;
        }
        prev.next = prev.next.next;
    }

    insertAt(index) {

    }

}