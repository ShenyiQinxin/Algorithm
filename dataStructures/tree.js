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
        if (!this.root) {
            this.root = newNode;
        } else {
            let current = this.root;
            while (current) {
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
    }

    get(value) {
        if (!this.root) {
            return false;
        }
        let current = this.root;
        while (current) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else if (value === current.value) {
                return current;
            }
        }
        return null;
    }

    remove(value) {
        if (!this.root) {
            return false;
        }
        let current = this.root;
        let parent = null;
        while (current) {
            if (value < current.value) {
                parent = current;
                current = current.left;
            } else if (value > current.value) {
                parent = current;
                current = current.right;
            } else if (value === current.value) {

                //remove the node and move some child up to the removed position
            }
        }
    }
}

function traverse(node) {
    const tree = {
        value: node.value
    };
    tree.left = node.left === null ? null : traverse(node.left);
    tree.right = node.right === null ? null : traverse(node.right);
    return tree;
}
let tree = new BinarySearchTree();
tree.insert(9);
tree.insert(4);
tree.insert(6);
tree.insert(20);
tree.insert(170);
tree.insert(15);
tree.insert(1);
const gotNode = tree.get(1);
//console.log(gotNode);
const treeString = JSON.stringify(traverse(tree.root));
//console.log(treeString);
