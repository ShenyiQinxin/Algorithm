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

    clear() {
        this.head = null;
    }

    getFirst() {
        return this.head;
    }

    removeFirst() {
        if (!this.head) {
            return;
        }
        this.first = this.first.next;
    }

    addFirst(data) {
        this.first = new Node(data, this.head);
    }

    size() {
        let counter = 0;
        let node = this.head;
        while (node) {
            counter++;
            node = node.next;
        }
        return counter;
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

    getAt(index) {
        let counter = 0;
        let node = this.head;
        while (node) {
            if (counter === index) {
                return node;
            }
            counter++;
            node = node.next;

        }
        return null;
    }


    addLast(data) {
        const last = this.getLast();
        if (last) {
            last.next = new Node(data);
        } else {
            this.head = new Node(data);
        }

    }

    /**
     * practice
     * */
    removeLast() {
        if (!this.head) {
            return;
        }

        if (this.head.next) {
            this.head = null;
            return;
        }

        let pre = this.head;
        let node = this.head.next;
        while (node) {
            prev = prev.next;
            node = node.next;
        }
        prev.next = null;

    }

    addAt(data, index) {
        if (!this.head) {
            this.head = new Node(data);
        }
        if (index === 0) {
            this.head = new Node(data, this.head);
            return;
        }

        const prev = this.getAt(index - 1) || this.getLast();
        prev.next = new Node(data, prev.next);

    }


    removeAt(index) {
        if (!this.head) {
            this.head = new Node(data);
        }

        if (index === 0) {
            this.head = new Node(data, this.head);
        }

        const prev = this.getAt(index - 1);
        if (!prev || !prev.next) {
            return;
        }
        prev.next = prev.next.next;

    }

}