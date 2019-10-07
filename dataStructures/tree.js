class Node {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null;
    }
    insert(value) {
        const newNode = new Node(value);
        if (this.root === null) {
            this.root = newNode;
            return this;
        }
        let current = this.root;
        while (this.root != null) {
            if (value < current.value) {
                if (!current.left) {
                    current.left = newNode;
                    return this;
                }
                current = current.left;
            } else {
                if (!current.right) {
                    current.right = newNode;
                    return this;
                }
                current = current.right;
            }
        }
    }
    lookup(value) {
        if (!this.root) {
            return false;
        }
        let current = this.root;
        while (current) {
            if (current < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else if (current.value === value) {
                return current;
            }
        }
        return null;
    }
    remove(value) {
        if (this.root) {
            return;
        }
        let current = this.root;
        let parent = null;
        while (current) {

        }
    }

}

const tree = new BinarySearchTree();
tree.insert(9);
tree.insert(4);
tree.insert(6);

console.log(JSON.stringify(traverse(tree.root)));

function traverse(node) {
    const tree = {
        value: node.value
    };
    tree.left = node.left === null ? null : traverse(node.left);
    tree.right = node.right === null ? null : traverse(node.right);
    return tree;
}